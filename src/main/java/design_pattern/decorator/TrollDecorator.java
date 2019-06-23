package design_pattern.decorator;

public class TrollDecorator implements Troll {
    private Troll decorated;

    @Override
    public void attack() {
        decorated.attack();
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower();
    }

    @Override
    public void fleeBattle() {
        decorated.fleeBattle();
    }

    TrollDecorator(Troll decorated) {
        this.decorated = decorated;
    }
}
