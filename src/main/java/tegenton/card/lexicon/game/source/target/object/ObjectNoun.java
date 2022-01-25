package tegenton.card.lexicon.game.source.target.object;

import tegenton.card.lexicon.Word;

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
