package design_pattern.prototype;

public interface HeroFactory {
    Mage createMage();

    Warlord createWarlord();

    Beast createBeast();
}
