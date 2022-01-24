package tegenton.card.parse.lexicon.value;

import tegenton.card.parse.lexicon.Word;

public interface ValueWord extends Word {
    /**
     * @return The numeric value of this word.
     */
    int getVal();
}
