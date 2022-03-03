package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;

import java.util.Objects;

public class InputItem {
    private final Word word;

    public InputItem(Word word) {
        this.word = word;
    }

    public Keyword getWord() {
        return (Keyword) word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputItem inputItem = (InputItem) o;
        return Objects.equals(word, inputItem.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    public boolean match(Word word) {
        return this.word == word;
    }
}
