package effective_java.visitor;

public class Commander extends Unit {
    Commander(Unit... children) {
        super(children);
    }

    @Override
    void accept(UnitVisitor visitor) {
        visitor.visitCommander(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "commander";
    }
}
