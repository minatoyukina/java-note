package design_pattern.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TunnelDigger extends MineWorker {
    private static final Logger LOGGER = LoggerFactory.getLogger(TunnelDigger.class);

    @Override
    public void work() {
        LOGGER.info("{} creates another promising tunnel.", name());
    }

    @Override
    public String name() {
        return "tunnel digger";
    }
}
