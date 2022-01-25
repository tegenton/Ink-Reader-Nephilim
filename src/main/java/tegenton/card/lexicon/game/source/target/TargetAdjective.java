package tegenton.card.lexicon.game.source.target;

import tegenton.card.lexicon.Word;

public enum TargetAdjective implements Word {
    ABLE;

    @Override
    public String getWord() {
        return this.name();
    }
}
