package design_pattern.factory.abstract_factory;

public interface KingdomFactory {
    Castle createCastle();
    King createKing();
    Army createArmy();
}
