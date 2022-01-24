package tegenton.card.parse.dfa.substring.morpheme;

import static tegenton.card.parse.lexicon.Morpheme.ED;

public class EDMorpheme extends Morpheme {
    /**
     * ED typically indicates the past tense of a verb.
     */
    public EDMorpheme() {
        super("ED".toCharArray(), ED);
    }
}
