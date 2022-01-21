package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.dfa.substring.Substring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public abstract class Morpheme extends Substring {
    private final Word word;

    protected Morpheme(final char[] text, final Word word) {
        super(text);
        this.word = word;
    }

    protected Word getWord() {
        return word;
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        if (this.completed()) {
            return Optional.of(word);
        }
        return Optional.empty();
    }
}
