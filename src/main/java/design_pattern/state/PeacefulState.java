package design_pattern.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeacefulState implements State {
    private static final Logger LOGGER = LoggerFactory.getLogger(PeacefulState.class);
    private Mammoth mammoth;

    PeacefulState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    public void OnEnterState() {
        LOGGER.info("{} calms down.", mammoth);
    }

    public void observe() {
        LOGGER.info("{} is calm and peaceful.", mammoth);
    }
}
