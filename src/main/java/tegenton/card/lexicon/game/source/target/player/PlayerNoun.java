package tegenton.card.lexicon.game.source.target.player;

import tegenton.card.lexicon.Word;

public enum PlayerNoun implements Word {
    OPPONENT, YOU;

    @Override
    public String getWord() {
        return this.name();
    }
}
