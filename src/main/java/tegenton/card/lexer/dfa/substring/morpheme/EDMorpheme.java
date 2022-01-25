package tegenton.card.lexer.dfa.substring.morpheme;

import static tegenton.card.lexicon.Morpheme.ED;

public class EDMorpheme extends Morpheme {
    /**
     * ED typically indicates the past tense of a verb.
     */
    public EDMorpheme() {
        super("ED".toCharArray(), ED);
    }
}
