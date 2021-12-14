package tegenton.card.parse.dfa.substring;

import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class StateSequence extends Substring {
    private final Word product;

    public StateSequence(String text, Word product) {
        super(text.toCharArray());
        this.product = product;
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        if (completed()) {
            return Optional.of(product);
        }
        return Optional.empty();
    }
}
