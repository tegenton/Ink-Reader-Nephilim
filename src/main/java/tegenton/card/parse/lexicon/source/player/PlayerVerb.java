package tegenton.card.parse.lexicon.source.player;

import tegenton.card.parse.lexicon.Word;

public enum PlayerVerb implements Word {
    ACTIVATE,
    ADD,
    ATTACH,
    CAST,
    CHANGE,
    CHOOSE,
    CONTROL,
    COULD,
    COUNTER,
    CREATE,
    DESTROY,
    DISCARD,
    DIVIDE,
    DRAW,
    EXCHANGE,
    IGNORE,
    LOOK,
    LOSE,
    MAY,
    OWN,
    PAY,
    PLAY,
    PREVENT,
    PUT,
    REGENERATE,
    REMOVE,
    RETURN,
    SACRIFICE,
    SEARCH,
    SHUFFLE,
    SKIPS,
    SPEND,
    TAKE;

    @Override
    public String getWord() {
        return this.name();
    }
}