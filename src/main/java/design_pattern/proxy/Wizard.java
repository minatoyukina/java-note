package design_pattern.proxy;

public class Wizard {
    private final String name;

    Wizard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
