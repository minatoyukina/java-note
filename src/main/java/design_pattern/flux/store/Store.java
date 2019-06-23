package design_pattern.flux.store;

import design_pattern.flux.action.Action;
import design_pattern.flux.view.View;

import java.util.LinkedList;
import java.util.List;

public abstract class Store {
    private List<View> views = new LinkedList<>();

    public abstract void onAction(Action action);

    public void registerView(View view) {
        views.add(view);
    }

    void notifyChange() {
        views.forEach(view -> view.storeChanged(this));
    }
}
