package design_pattern.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class Weather {
    private static final Logger LOGGER = LoggerFactory.getLogger(Weather.class);
    private WeatherType currentWeather;
    private List<WeatherObserver> observers;

    Weather() {
        observers = new ArrayList<>();
        currentWeather = WeatherType.SUNNY;
    }

    void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    void timePasses() {
        WeatherType[] values = WeatherType.values();
        currentWeather = values[(currentWeather.ordinal() + 1) % values.length];
        LOGGER.info("The weather changed to {}.", currentWeather);
        notifyObservers();
    }

    private void notifyObservers() {
        observers.forEach(s -> s.update(currentWeather));
    }
}
