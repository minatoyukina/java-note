package design_pattern.prototype;

public abstract class Beast extends Prototype {
    @Override
    public abstract Beast clone() throws CloneNotSupportedException;
}
