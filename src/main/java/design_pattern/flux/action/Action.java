package design_pattern.flux.action;

public abstract class Action {
    private ActionType type;

    Action(ActionType type) {
        this.type = type;
    }

    public ActionType getType() {
        return type;
    }
}
