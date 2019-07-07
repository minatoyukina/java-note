package design_pattern.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FishingBoat {
    private static final Logger LOGGER = LoggerFactory.getLogger(FishingBoat.class);

    void sail() {
        LOGGER.info("The fishing boat is sailing");
    }
}
