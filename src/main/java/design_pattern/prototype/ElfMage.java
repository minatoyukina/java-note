package design_pattern.prototype;

public class ElfMage extends Mage {
    @Override
    public Mage clone() {
        return new ElfMage();
    }

}
