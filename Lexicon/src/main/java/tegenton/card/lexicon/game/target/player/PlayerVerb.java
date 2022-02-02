package tegenton.card.lexicon.game.target.player;

import tegenton.card.lexicon.Word;

/**
 * Actions players can take.
 */
public enum PlayerVerb implements Word {
    ACTIVATE,
    ADD,
    ATTACH,
    BEGIN,
    CAST,
    CHANGE,
    CHOOSE,
    CONTROL,
    COULD,
    COUNTER,
    CREATE,
    DECLARE,
    DESTROY,
    DISCARD,
    DIVIDE,
    DRAW,
    EXCHANGE,
    FLIP,
    IGNORE,
    LOOK,
    MAY,
    OWN,
    PAY,
    PLAY,
    PREVENT,
    PUT,
    REGENERATE,
    REMOVE,
    REPLACE,
    RETURN,
    SACRIFICE,
    SEARCH,
    SHUFFLE,
    SKIP,
    SPEND,
    TAKE;

    @Override
    public String toString() {
        return this.name();
    }
}
