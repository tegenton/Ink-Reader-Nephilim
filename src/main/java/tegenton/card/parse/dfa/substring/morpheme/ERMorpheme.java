package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.lexicon.Word;

public class ERMorpheme extends Morpheme {
    /**
     * ER typically means "one who does" a verb, such as play-er.
     *
     * @param word Word to return upon successful traversal of the morpheme.
     */
    public ERMorpheme(final Word word) {
        super("ER".toCharArray(), word);
    }
}
