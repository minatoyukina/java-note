package design_pattern.promise;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;

class Promise<T> extends PromiseSupport<T> {
    private Runnable fulfillmentAction;
    private Consumer<? super Throwable> exceptionHandler;

    Promise() {

    }

    @Override
    void fulfill(T value) {
        super.fulfill(value);
        postFulfillment();
    }

    private void postFulfillment() {
        if (fulfillmentAction == null) {
            return;
        }
        fulfillmentAction.run();
    }

    @Override
    void fulfillExceptionally(Exception exception) {
        super.fulfillExceptionally(exception);
        handleException(exception);
        postFulfillment();
    }

    private void handleException(Exception exception) {
        if (exceptionHandler == null) {
            return;
        }
        exceptionHandler.accept(exception);
    }

    Promise<T> fulfillInAsync(final Callable<T> task, Executor executor) {
        executor.execute(() -> {
            try {
                fulfill(task.call());
            } catch (Exception ex) {
                fulfillExceptionally(ex);
            }
        });
        return this;
    }

    Promise<Void> thenAccept(Consumer<? super T> action) {
        Promise<Void> dest = new Promise<>();
        fulfillmentAction = new ConsumeAction(this, dest, action);
        return dest;
    }

    Promise<T> onError(Consumer<? super Throwable> exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
        return this;
    }

    <V> Promise<V> thenApply(Function<? super T, V> func) {
        Promise<V> dest = new Promise<>();
        fulfillmentAction = new TransformAction<>(this, dest, func);
        return dest;
    }

    private class ConsumeAction implements Runnable {
        private final Promise<T> src;
        private final Promise<Void> dest;
        private final Consumer<? super T> action;

        private ConsumeAction(Promise<T> src, Promise<Void> dest, Consumer<? super T> action) {
            this.src = src;
            this.dest = dest;
            this.action = action;
        }

        @Override
        public void run() {
            try {
                action.accept(src.get());
                dest.fulfill(null);
            } catch (Throwable throwable) {
                dest.fulfillExceptionally((Exception) throwable.getCause());
            }
        }
    }

    private class TransformAction<V> implements Runnable {
        private final Promise<T> src;
        private final Promise<V> dest;
        private final Function<? super T, V> func;

        private TransformAction(Promise<T> src, Promise<V> dest, Function<? super T, V> func) {
            this.src = src;
            this.dest = dest;
            this.func = func;
        }

        @Override
        public void run() {
            try {
                dest.fulfill(func.apply(src.get()));
            } catch (Throwable throwable) {
                dest.fulfillExceptionally((Exception) throwable.getCause());
            }
        }
    }
}