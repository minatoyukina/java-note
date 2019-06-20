package design_pattern.facade;

import java.util.ArrayList;
import java.util.List;

class GoldmineFacade {
    private final List<MineWorker> workers;

    GoldmineFacade() {
        workers = new ArrayList<>();
        workers.add(new GoldDigger());
        workers.add(new CartOperator());
        workers.add(new TunnelDigger());
    }

    void startNewDay() {
        makeActions(workers, MineWorker.Action.WAKE_UP, MineWorker.Action.GO_TO_MINE);
    }

    void digOutGold() {
        makeActions(workers, MineWorker.Action.WORK);
    }

    void endDay() {
        makeActions(workers, MineWorker.Action.GO_HOME, MineWorker.Action.GO_TO_SLEEP);
    }

    private void makeActions(List<MineWorker> workers, MineWorker.Action... actions) {
        for (MineWorker worker : workers) {
            worker.action(actions);
        }
    }
}
