package design_pattern.flux.view;

import design_pattern.flux.store.Store;

public interface View {
    void storeChanged(Store store);

    void render();
}
