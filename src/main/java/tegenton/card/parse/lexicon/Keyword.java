package tegenton.card.parse.lexicon;

public enum Keyword implements Word {
    BAND,
    DEFENDER,
    ENCHANT,
    FEAR,
    FIRST,
    FLY,
    HASTE,
    INDESTRUCTIBLE,
    PROTECTION,
    REACH,
    STRIKE,
    TRAMPLE,
    VIGILANCE,
    WALK;

    @Override
    public String getWord() {
        return name();
    }
}
