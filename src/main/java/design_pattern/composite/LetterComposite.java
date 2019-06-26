package design_pattern.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class LetterComposite {
    private List<LetterComposite> children = new ArrayList<>();

    public void add(LetterComposite composite) {
        children.add(composite);
    }

    protected abstract void printThisBefore();

    protected abstract void printThisAfter();

    public void print() {
        printThisBefore();
        children.forEach(LetterComposite::print);
        printThisAfter();
    }
}
