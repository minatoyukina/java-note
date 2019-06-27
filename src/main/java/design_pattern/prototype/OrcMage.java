package design_pattern.prototype;

public class OrcMage extends Mage {
    @Override
    public Mage clone() {
        return new OrcMage();
    }
}
