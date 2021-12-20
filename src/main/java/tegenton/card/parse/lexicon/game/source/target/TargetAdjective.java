package tegenton.card.parse.lexicon.game.source.target;

import tegenton.card.parse.lexicon.Word;

public enum TargetAdjective implements Word {
    ABLE;

    @Override
    public String getWord() {
        return this.name();
    }
}
