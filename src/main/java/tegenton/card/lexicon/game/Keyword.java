package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

public enum Keyword implements Word {
    BANDING, DEFENDER, ENCHANT, FEAR, FLYING, HASTE, INDESTRUCTIBLE,
    PROTECTION, REACH, STRIKE, TRAMPLE, VIGILANCE, WALK;

    @Override
    public String getWord() {
        return name();
    }
}
