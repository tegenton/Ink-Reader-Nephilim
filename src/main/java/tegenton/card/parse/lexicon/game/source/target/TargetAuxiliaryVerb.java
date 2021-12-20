package tegenton.card.parse.lexicon.game.source.target;

import tegenton.card.parse.lexicon.Word;

public enum TargetAuxiliaryVerb implements Word {
    CAN, WOULD;

    @Override
    public String getWord() {
        return this.name();
    }
}
