package design_pattern.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoisonPotion implements Potion {
    private static final Logger LOGGER = LoggerFactory.getLogger(PoisonPotion.class);

    @Override
    public void drink() {
        LOGGER.info("You feel poisonous. (Potion={})", System.identityHashCode(this));
    }
}
