package design_pattern.prototype;

public class ElfBeast extends Beast {
    @Override
    public Beast clone() {
        return new ElfBeast();
    }

}
