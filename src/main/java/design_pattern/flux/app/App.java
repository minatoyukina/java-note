package design_pattern.flux.app;

import design_pattern.flux.action.MenuItem;
import design_pattern.flux.dispatcher.Dispatcher;
import design_pattern.flux.store.ContentStore;
import design_pattern.flux.store.MenuStore;
import design_pattern.flux.view.ContentView;
import design_pattern.flux.view.MenuView;

public class App {
    public static void main(String[] args) {
        MenuStore menuStore = new MenuStore();
        Dispatcher.getInstance().registerStore(menuStore);
        ContentStore contentStore = new ContentStore();
        Dispatcher.getInstance().registerStore(contentStore);
        MenuView menuView = new MenuView();
        menuStore.registerView(menuView);
        ContentView contentView = new ContentView();
        contentStore.registerView(contentView);

        menuView.render();
        contentView.render();

        menuView.itemClicked(MenuItem.COMPANY);
        menuView.itemClicked(MenuItem.PRODUCTS);
        menuView.itemClicked(MenuItem.HOME);
    }
}
