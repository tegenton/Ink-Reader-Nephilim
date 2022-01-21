package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ERMorpheme extends Morpheme {
    public ERMorpheme(final Word word) {
        super("ER".toCharArray(), word);
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        if (this.completed()) {
            return Optional.of(word);
        }
        return Optional.empty();
    }
}
