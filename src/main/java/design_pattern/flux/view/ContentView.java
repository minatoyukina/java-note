package design_pattern.flux.view;

import design_pattern.flux.action.Content;
import design_pattern.flux.store.ContentStore;
import design_pattern.flux.store.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentView implements View {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContentView.class);
    private Content content = Content.HOME;

    @Override
    public void storeChanged(Store store) {
        ContentStore contentStore = (ContentStore) store;
        content = contentStore.getContent();
        render();
    }

    @Override
    public void render() {
        LOGGER.info(content.toString());
    }
}
