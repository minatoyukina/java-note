package design_pattern.flux.view;

import design_pattern.flux.action.MenuItem;
import design_pattern.flux.dispatcher.Dispatcher;
import design_pattern.flux.store.MenuStore;
import design_pattern.flux.store.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuView implements View {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuView.class);
    private MenuItem selected = MenuItem.HOME;

    @Override
    public void storeChanged(Store store) {
        MenuStore menuStore = (MenuStore) store;
        selected = menuStore.getSelected();
        render();
    }

    @Override
    public void render() {
        for (MenuItem item : MenuItem.values()) {
            if (selected.equals(item)) {
                LOGGER.info("* {}", item);
            } else {
                LOGGER.info(item.toString());
            }
        }
    }

    public void itemClicked(MenuItem item) {
        Dispatcher.getInstance().menuItemSelected(item);
    }
}
