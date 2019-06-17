package design_pattern.thread_pool;

public class CoffeeMakingTask extends Task {
    private static final int TIME_PRE_CUP = 200;

    CoffeeMakingTask(int numCups) {
        super(numCups * TIME_PRE_CUP);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }
}
