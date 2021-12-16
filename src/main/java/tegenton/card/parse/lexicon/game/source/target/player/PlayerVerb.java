package tegenton.card.parse.lexicon.game.source.target.player;

import tegenton.card.parse.lexicon.Word;

public enum PlayerVerb implements Word {
    ACTIVATE, ADD, ATTACH, CAST, CHANGE, CHOOSE, CONTROL, COULD, COUNTER,
    CREATE, DESTROY, DISCARD, DIVIDE, DRAW, EXCHANGE, FLIP, IGNORE, LOOK, LOSE, MAY,
    OWN, PAY, PLAY, PREVENT, PUT, REGENERATE, REMOVE, RETURN, SACRIFICE, SEARCH,
    SHUFFLE, SKIP, SPEND, TAKE;

    @Override
    public String getWord() {
        return this.name();
    }
}
