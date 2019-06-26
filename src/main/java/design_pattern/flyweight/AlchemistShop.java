package design_pattern.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class AlchemistShop {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlchemistShop.class);
    private List<Potion> topShelf;
    private List<Potion> bottomShelf;

    AlchemistShop() {
        topShelf = new ArrayList<>();
        bottomShelf = new ArrayList<>();
        fillShelves();
    }

    private void fillShelves() {
        PotionFactory factory = new PotionFactory();
        topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
        topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
        topShelf.add(factory.createPotion(PotionType.STRENGTH));
        topShelf.add(factory.createPotion(PotionType.HEALING));
        topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
        topShelf.add(factory.createPotion(PotionType.STRENGTH));
        topShelf.add(factory.createPotion(PotionType.HEALING));
        topShelf.add(factory.createPotion(PotionType.HEALING));

        bottomShelf.add(factory.createPotion(PotionType.POISON));
        bottomShelf.add(factory.createPotion(PotionType.POISON));
        bottomShelf.add(factory.createPotion(PotionType.POISON));
        bottomShelf.add(factory.createPotion(PotionType.HOLY_WATER));
        bottomShelf.add(factory.createPotion(PotionType.HOLY_WATER));
    }

    void enumerate() {
        LOGGER.info("Enumerating top shelf potions\n");
        topShelf.forEach(Potion::drink);
        LOGGER.info("Enumerating bottom shelf potions\n");
        bottomShelf.forEach(Potion::drink);
    }
}
