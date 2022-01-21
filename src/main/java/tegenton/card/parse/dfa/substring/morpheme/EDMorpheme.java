package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

import static tegenton.card.parse.lexicon.Morpheme.ED;

public class EDMorpheme extends Morpheme {
    public EDMorpheme() {
        super("ED".toCharArray(), ED);
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        if (this.completed()) {
            return Optional.of(ED);
        }
        return Optional.empty();
    }
}
