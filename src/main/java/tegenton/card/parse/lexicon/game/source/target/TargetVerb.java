package tegenton.card.parse.lexicon.game.source.target;

import tegenton.card.parse.lexicon.Word;

public enum TargetVerb implements Word {
    ASSIGN, GAIN, LOSE;

    @Override
    public String getWord() {
        return this.name();
    }
}
