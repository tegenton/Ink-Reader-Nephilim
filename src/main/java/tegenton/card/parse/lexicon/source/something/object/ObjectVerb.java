package tegenton.card.parse.lexicon.source.something.object;

import tegenton.card.parse.lexicon.Word;

public enum ObjectVerb implements Word {
    ATTACK,
    BECOME,
    BLOCK,
    COST,
    DIE,
    ENTER,
    GET,
    HAVE,
    IS,
    LEAVE,
    TAP;

    @Override
    public String getWord() {
        return this.name();
    }
}
