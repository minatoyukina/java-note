package effective_java.visitor;

abstract class Unit {
    private Unit[] children;

    Unit(Unit... children) {
        this.children = children;
    }

    void accept(UnitVisitor visitor) {
        for (Unit child : children) {
            child.accept(visitor);
        }
    }
}
