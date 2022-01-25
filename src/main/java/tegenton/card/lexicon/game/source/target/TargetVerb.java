package tegenton.card.lexicon.game.source.target;

import tegenton.card.lexicon.Word;

public enum TargetVerb implements Word {
    ASSIGN, GAIN, LOSE;

    @Override
    public String getWord() {
        return this.name();
    }
}
