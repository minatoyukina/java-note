package design_pattern.observer.generic;

import design_pattern.observer.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GWeather extends Observable<GWeather, Race, WeatherType> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GWeather.class);
    private WeatherType currentWeather;

    public GWeather() {
        currentWeather = WeatherType.SUNNY;
    }

    public void timePasses() {
        WeatherType[] values = WeatherType.values();
        currentWeather = values[(currentWeather.ordinal() + 1) % values.length];
        LOGGER.info("The weather changed to {}.", currentWeather);
        notifyObservers(currentWeather);
    }

}
