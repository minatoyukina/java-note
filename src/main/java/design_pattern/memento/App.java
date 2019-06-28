package design_pattern.memento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Stack<StarMemento> states = new Stack<>();
        Star star = new Star(StarType.SUN, 10_000_000, 500_000);
        LOGGER.info(star.toString());
        states.add(star.getMemento());
        star.timePasses();
        LOGGER.info(star.toString());
        states.add(star.getMemento());
        star.timePasses();
        LOGGER.info(star.toString());
        states.add(star.getMemento());
        star.timePasses();
        LOGGER.info(star.toString());
        states.add(star.getMemento());
        star.timePasses();
        LOGGER.info(star.toString());
        states.add(star.getMemento());
        star.timePasses();
        while (states.size() > 0) {
            star.setMemento(states.pop());
            LOGGER.info(star.toString());
        }
    }
}
