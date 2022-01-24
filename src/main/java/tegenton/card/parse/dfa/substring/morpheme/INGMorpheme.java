package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.lexicon.Word;

public class INGMorpheme extends Morpheme {
    /**
     * ING typically creates a gerund.
     */
    public INGMorpheme() {
        super("ING".toCharArray(), tegenton.card.parse.lexicon.Morpheme.ING);
    }

    /**
     * @param word Word to return upon successful traversal of the morpheme.
     */
    public INGMorpheme(final Word word) {
        super("ING".toCharArray(), word);
    }
}
