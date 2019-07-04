package effective_java.visitor;

public class Soldier extends Unit {
    Soldier(Unit... children) {
        super(children);
    }

    @Override
    void accept(UnitVisitor visitor) {
        visitor.visitSoldier(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "soldier";
    }
}
