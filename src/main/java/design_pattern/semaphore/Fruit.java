package design_pattern.semaphore;

public class Fruit {
    enum FruitType {
        ORANGE, APPLE, LEMON
    }

    private FruitType type;

    Fruit(FruitType type) {
        this.type = type;
    }

    FruitType getType() {
        return type;
    }

    @Override
    public String toString() {
        switch (type) {
            case ORANGE:
                return "Orange";
            case APPLE:
                return "Apple";
            case LEMON:
                return "Lemon";
            default:
                return "";
        }
    }
}
