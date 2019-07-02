package design_pattern.state;

public class Mammoth {
    private State state;

    Mammoth() {
        state = new PeacefulState(this);
    }

    void timePasses() {
        if (state.getClass().equals(PeacefulState.class)) {
            changeStateTo(new AngryState(this));
        } else {
            changeStateTo(new PeacefulState(this));
        }
    }

    private void changeStateTo(State newState) {
        this.state = newState;
        this.state.OnEnterState();
    }

    @Override
    public String toString() {
        return "The mammoth";
    }

    void observe() {
        this.state.observe();
    }
}
