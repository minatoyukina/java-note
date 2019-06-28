package design_pattern.observer.generic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {
    private List<O> observers;

    Observable() {
        observers = new CopyOnWriteArrayList<>();
    }

    public void addObserver(O observer) {
        observers.add(observer);
    }

    @SuppressWarnings("unchecked")
    void notifyObservers(A argument) {
        observers.forEach(o -> o.update((S) this, argument));
    }
}
