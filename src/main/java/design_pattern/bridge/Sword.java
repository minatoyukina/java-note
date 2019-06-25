package design_pattern.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sword implements Weapon {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sword.class);
    private final Enchantment enchantment;

    @Override
    public void wield() {
        LOGGER.info("The sword is wielded.");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        LOGGER.info("The sword is swung.");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        LOGGER.info("The sword is unwielded.");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }

    Sword(Enchantment enchantment) {
        this.enchantment = enchantment;
    }
}
