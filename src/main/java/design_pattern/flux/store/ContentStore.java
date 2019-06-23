package design_pattern.flux.store;

import design_pattern.flux.action.*;

public class ContentStore extends Store {
    private Content content = Content.PRODUCTS;

    @Override
    public void onAction(Action action) {
        if (action.getType().equals(ActionType.CONTENT_CHANGED)) {
            ContentAction contentAction = (ContentAction) action;
            content = contentAction.getContent();
            notifyChange();
        }
    }

    public Content getContent() {
        return content;
    }
}
