package tegenton.card.lexer.dfa.substring.morpheme;

import tegenton.card.lexer.dfa.substring.Substring;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public abstract class Morpheme extends Substring {
    private final Word product;

    protected Morpheme(final char[] text, final Word word) {
        super(text);
        this.product = word;
    }

    /**
     * @return Word to return on successful traversal.
     */
    protected Word getProduct() {
        return product;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        if (this.completed()) {
            return Optional.of(product);
        }
        return Optional.empty();
    }
}
