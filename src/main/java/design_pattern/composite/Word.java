package design_pattern.composite;

import java.util.List;

public class Word extends LetterComposite {
    @Override
    protected void printThisBefore() {
        System.out.print(" ");
    }

    @Override
    protected void printThisAfter() {

    }

    Word(List<Letter> letters) {
        letters.forEach(this::add);
    }
}
