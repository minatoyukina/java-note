package design_pattern.semaphore;

import java.util.ArrayList;
import java.util.List;

public class FruitBowl {
    private List<Fruit> fruits = new ArrayList<>();

    int countFruit() {
        return fruits.size();
    }

    public void put(Fruit f) {
        fruits.add(f);
    }

    Fruit take() {
        if (fruits.isEmpty())
            return null;
        else
            return fruits.remove(0);
    }

    @Override
    public String toString() {
        int apples = 0;
        int oranges = 0;
        int lemons = 0;
        for (Fruit fruit : fruits) {
            switch (fruit.getType()) {
                case APPLE:
                    apples++;
                    break;
                case ORANGE:
                    oranges++;
                    break;
                case LEMON:
                    lemons++;
                    break;
                default:
            }
        }
        return apples + " Apples, " + oranges + " Oranges, and " + lemons + " lemons";
    }
}
