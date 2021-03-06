package effective_java.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoldierVisitor implements UnitVisitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(SoldierVisitor.class);

    @Override
    public void visitSoldier(Soldier soldier) {
        LOGGER.info("Greetings {}", soldier);
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {
    }
}
