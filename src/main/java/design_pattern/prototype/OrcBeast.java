package design_pattern.prototype;

public class OrcBeast extends Beast {
    @Override
    public Beast clone() {
        return new OrcBeast();
    }

}
