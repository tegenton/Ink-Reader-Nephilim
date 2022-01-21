package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.lexicon.Word;

public class ERMorpheme extends Morpheme {
    public ERMorpheme(final Word word) {
        super("ER".toCharArray(), word);
    }
}
