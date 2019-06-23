package design_pattern.flux.dispatcher;

import design_pattern.flux.action.*;
import design_pattern.flux.store.Store;

import java.util.LinkedList;
import java.util.List;

public final class Dispatcher {
    private static Dispatcher instance = new Dispatcher();
    private List<Store> stores = new LinkedList<>();

    public static Dispatcher getInstance() {
        return instance;
    }

    private Dispatcher() {
    }

    public void registerStore(Store store) {
        stores.add(store);
    }

    public void menuItemSelected(MenuItem menuItem) {
        dispatchAction(new MenuAction(menuItem));
        switch (menuItem) {
            case HOME:
                dispatchAction(new ContentAction(Content.HOME));
                break;
            case PRODUCTS:
                dispatchAction(new ContentAction(Content.PRODUCTS));
                break;
            case COMPANY:
                dispatchAction(new ContentAction(Content.COMPANY));
                break;
            default:
                dispatchAction(new ContentAction(Content.HOME));
                break;
        }
    }

    private void dispatchAction(Action action) {
        stores.forEach(store -> store.onAction(action));
    }
}
