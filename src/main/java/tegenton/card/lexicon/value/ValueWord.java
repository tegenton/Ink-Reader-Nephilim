package tegenton.card.lexicon.value;

import tegenton.card.lexicon.Word;

public interface ValueWord extends Word {
    /**
     * @return The numeric value of this word.
     */
    int getVal();
}
