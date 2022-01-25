package tegenton.card.lexer.dfa.substring;

import tegenton.card.lexicon.Word;

import java.util.Optional;

public class SuffixSubstring extends Substring {
    private final Word product;

    /**
     * A substring that can only result in a word.
     *
     * @param text Series of characters to transition on.
     * @param word Word that the series of states described by text should
     *             produce.
     */
    public SuffixSubstring(final String text, final Word word) {
        super(text.toCharArray());
        this.product = word;
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
