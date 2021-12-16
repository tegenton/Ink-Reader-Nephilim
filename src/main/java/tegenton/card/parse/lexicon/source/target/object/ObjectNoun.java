package tegenton.card.parse.lexicon.source.target.object;

import tegenton.card.parse.lexicon.Word;

/**
 * The (grammatical) object of a sentence.
 */
public enum ObjectNoun implements Word {
    CARD, COPY, IT, PERMANENT, SPELL, TOKEN;

    @Override
    public String getWord() {
        return this.name();
    }
}
