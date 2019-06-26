package design_pattern.composite;

public class Letter extends LetterComposite {
    private char c;

    Letter(char c) {
        this.c = c;
    }

    @Override
    protected void printThisBefore() {
        System.out.print(c);
    }

    @Override
    protected void printThisAfter() {

    }
}
