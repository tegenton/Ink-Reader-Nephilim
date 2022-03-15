package tegenton.card.parser.item;

import tegenton.card.lexicon.Word;

import java.util.Objects;

public class InputClass extends InputItem {
    private final Class<? extends Word> wordClass;

    public InputClass(Class<? extends Word> wordType) {
        super((Word) null);
        wordClass = wordType;
    }

    @Override
    public boolean match(InputItem inputItem) {
        return inputItem.hasWord()
                && inputItem.getWord().getClass() == wordClass;
    }

    @Override
    public String toString() {
        return wordClass.getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        InputClass that = (InputClass) o;
        return Objects.equals(wordClass, that.wordClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wordClass);
    }
}
