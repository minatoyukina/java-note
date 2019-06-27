package design_pattern.prototype;

public class OrcWarlord extends Warlord {
    @Override
    public Warlord clone() {
        return new OrcWarlord();
    }

}
