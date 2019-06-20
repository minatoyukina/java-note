package design_pattern.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MineWorker {
    private static final Logger LOGGER = LoggerFactory.getLogger(MineWorker.class);

    private void goToSleep() {
        LOGGER.info("{} goes to sleep.", name());
    }

    private void wakeUp() {
        LOGGER.info("{} wake up.", name());
    }

    private void goHome() {
        LOGGER.info("{} goes home.", name());
    }

    private void goToMine() {
        LOGGER.info("{} goes to the mine.", name());
    }

    private void action(Action action) {
        switch (action) {
            case GO_TO_SLEEP:
                goToSleep();
                break;
            case WAKE_UP:
                wakeUp();
                break;
            case GO_HOME:
                goHome();
                break;
            case GO_TO_MINE:
                goToMine();
                break;
            case WORK:
                work();
                break;
            default:
                LOGGER.info("undefined action");
        }
    }

    void action(Action... actions) {
        for (Action action : actions) {
            action(action);
        }
    }


    public abstract void work();

    public abstract String name();

    enum Action {
        GO_TO_SLEEP, WAKE_UP, GO_HOME, GO_TO_MINE, WORK
    }
}
