package tegenton.card.parse.lexicon.object;

import tegenton.card.parse.lexicon.Word;

public enum ObjectVerb implements Word {
    ATTACK,
    BLOCK,
    DIE,
    ENTER,
    LEAVE,
    TAP;

    @Override
    public String getWord() {
        return this.name();
    }
}
