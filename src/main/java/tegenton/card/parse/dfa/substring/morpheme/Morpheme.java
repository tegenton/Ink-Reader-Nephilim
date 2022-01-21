package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.dfa.substring.Substring;
import tegenton.card.parse.lexicon.Word;

public abstract class Morpheme extends Substring {
    protected final Word word;

    protected Morpheme(final char[] text, final Word word) {
        super(text);
        this.word = word;
    }
}
