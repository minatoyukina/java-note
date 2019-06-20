package design_pattern.facade;

public class App {
    public static void main(String[] args) {
        GoldmineFacade facade = new GoldmineFacade();
        facade.startNewDay();
        facade.digOutGold();
        facade.endDay();
    }
}
