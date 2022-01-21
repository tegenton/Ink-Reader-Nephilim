package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class INGMorpheme extends Morpheme {
    public INGMorpheme() {
        super("ING".toCharArray(), tegenton.card.parse.lexicon.Morpheme.ING);
    }

    public INGMorpheme(final Word word) {
        super("ING".toCharArray(), word);
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        if (this.completed()) {
            return Optional.of(word);
        }
        return Optional.empty();
    }
}
