package tegenton.card.parse.lexicon.object;

import tegenton.card.parse.lexicon.Word;

/**
 * The (grammatical) object of a sentence.
 */
public enum ObjectNoun implements Word {
    CARD,
    COPY,
    PERMANENT,
    SPELL,
    IT;

    @Override
    public String getWord() {
        return this.name();
    }
}
