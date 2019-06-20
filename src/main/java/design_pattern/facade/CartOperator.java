package design_pattern.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartOperator extends MineWorker {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartOperator.class);

    @Override
    public void work() {
        LOGGER.info("{} moves golds chunks out of the mine.", name());
    }

    @Override
    public String name() {
        return "cart operator";
    }
}
