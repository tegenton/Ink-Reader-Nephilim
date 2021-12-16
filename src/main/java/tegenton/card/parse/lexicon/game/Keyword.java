package tegenton.card.parse.lexicon.game;

import tegenton.card.parse.lexicon.Word;

public enum Keyword implements Word {
    BANDING, DEFENDER, ENCHANT, FEAR, FIRST, FLYING, HASTE, INDESTRUCTIBLE,
    PROTECTION, REACH, STRIKE, TRAMPLE, VIGILANCE, WALK;

    @Override
    public String getWord() {
        return name();
    }
}
