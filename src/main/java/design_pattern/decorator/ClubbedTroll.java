package design_pattern.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClubbedTroll extends TrollDecorator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClubbedTroll.class);

    ClubbedTroll(Troll decorated) {
        super(decorated);
    }

    @Override
    public void attack() {
        super.attack();
        LOGGER.info("The troll swings at you with a club!");
    }

    @Override
    public int getAttackPower() {
        return super.getAttackPower() + 10;
    }
}
