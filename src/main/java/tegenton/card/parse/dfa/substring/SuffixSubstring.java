package tegenton.card.parse.dfa.substring;

import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class SuffixSubstring extends Substring {
    private final Word product;

    /**
     * A substring that can only result in a word.
     *
     * @param text    Series of characters to transition on.
     * @param product Word that the series of states described by text should
     *                produce.
     */
    public SuffixSubstring(final String text, final Word product) {
        super(text.toCharArray());
        this.product = product;
    }

    /**
     * Retrieve word once substring has been traversed.
     *
     * @param c Character that will be transitioned on.
     * @return Word if series has been fully traversed, otherwise empty.
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(completed() ? product : null);
    }
}
