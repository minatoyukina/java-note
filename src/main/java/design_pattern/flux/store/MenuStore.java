package design_pattern.flux.store;

import design_pattern.flux.action.Action;
import design_pattern.flux.action.ActionType;
import design_pattern.flux.action.MenuAction;
import design_pattern.flux.action.MenuItem;

public class MenuStore extends Store {
    private MenuItem selected = MenuItem.HOME;

    @Override
    public void onAction(Action action) {
        if (action.getType().equals(ActionType.MENU_ITEM_SELECTED)) {
            MenuAction menuAction = (MenuAction) action;
            selected = menuAction.getMenuItem();
            notifyChange();
        }
    }

    public MenuItem getSelected() {
        return selected;
    }
}
