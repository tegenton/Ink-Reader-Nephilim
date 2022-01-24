package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.dfa.substring.Substring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public abstract class Morpheme extends Substring {
    private final Word product;

    protected Morpheme(final char[] text, final Word word) {
        super(text);
        this.product = word;
    }

    protected Word getProduct() {
        return product;
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        if (this.completed()) {
            return Optional.of(product);
        }
        return Optional.empty();
    }
}
