package design_pattern.thread_pool;

public class PotatoPeelingTask extends Task {
    private static final int TIME_PRE_POTATO = 200;

    PotatoPeelingTask(int numPotatoes) {
        super(numPotatoes * TIME_PRE_POTATO);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }
}
