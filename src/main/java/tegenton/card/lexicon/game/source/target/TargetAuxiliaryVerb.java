package tegenton.card.lexicon.game.source.target;

import tegenton.card.lexicon.Word;

public enum TargetAuxiliaryVerb implements Word {
    CAN, WOULD;

    @Override
    public String getWord() {
        return this.name();
    }
}
