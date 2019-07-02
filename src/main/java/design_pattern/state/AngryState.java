package design_pattern.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AngryState implements State {
    private static final Logger LOGGER = LoggerFactory.getLogger(AngryState.class);
    private Mammoth mammoth;

    AngryState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    public void OnEnterState() {
        LOGGER.info("{} gets angry!", mammoth);
    }

    public void observe() {
        LOGGER.info("{} is furious!", mammoth);
    }
}
