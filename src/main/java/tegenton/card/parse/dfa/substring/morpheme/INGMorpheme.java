package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.lexicon.Word;

public class INGMorpheme extends Morpheme {
    public INGMorpheme() {
        super("ING".toCharArray(), tegenton.card.parse.lexicon.Morpheme.ING);
    }

    public INGMorpheme(final Word word) {
        super("ING".toCharArray(), word);
    }
}
