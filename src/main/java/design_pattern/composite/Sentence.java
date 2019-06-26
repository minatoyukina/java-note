package design_pattern.composite;

import java.util.List;

public class Sentence extends LetterComposite {
    Sentence(List<Word> words) {
        words.forEach(this::add);
    }

    @Override
    protected void printThisBefore() {

    }

    @Override
    protected void printThisAfter() {
        System.out.println(".");
    }
}
