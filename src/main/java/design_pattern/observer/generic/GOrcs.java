package design_pattern.observer.generic;

import design_pattern.observer.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GOrcs implements Race {
    private static final Logger LOGGER = LoggerFactory.getLogger(GOrcs.class);

    @Override
    public void update(GWeather weather, WeatherType weatherType) {
        switch (weatherType) {
            case COLD:
                LOGGER.info("The orcs are freezing clold.");
                break;
            case RAINY:
                LOGGER.info("The orcs are dripping wet.");
                break;
            case SUNNY:
                LOGGER.info("The sun hurts the orcs' eyes badly");
                break;
            case WINDY:
                LOGGER.info("The orc smell almost vanishes in the wind.");
                break;
            default:
                break;
        }
    }
}
