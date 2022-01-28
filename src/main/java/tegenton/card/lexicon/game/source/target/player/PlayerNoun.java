package tegenton.card.lexicon.game.source.target.player;

import tegenton.card.lexicon.game.source.target.TargetWord;

public enum PlayerNoun implements TargetWord {
    OPPONENT, YOU;

    @Override
    public String getWord() {
        return this.name();
    }
}
