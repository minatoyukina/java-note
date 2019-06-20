package design_pattern.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoldDigger extends MineWorker {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoldDigger.class);

    @Override
    public void work() {
        LOGGER.info("{} digs for gold.", name());
    }

    @Override
    public String name() {
        return "gold digger";
    }
}
