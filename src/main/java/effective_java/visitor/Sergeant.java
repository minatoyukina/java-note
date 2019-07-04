package effective_java.visitor;

public class Sergeant extends Unit {
    Sergeant(Unit... children) {
        super(children);
    }

    @Override
    void accept(UnitVisitor visitor) {
        visitor.visitSergeant(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "sergeant";
    }
}
