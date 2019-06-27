package design_pattern.prototype;

public class ElfWarlord extends Warlord {
    @Override
    public Warlord clone() {
        return new ElfWarlord();
    }

}
