package tegenton.card.parse.token.lexicon;

public enum KeywordAction implements Word {
    activate,
    attach,
    cast,
    counter,
    create,
    destroy,
    discard,
    doubl("double"),
    exchange,
    exile,
    fight,
    mill,
    play,
    regenerate,
    reveal,
    sacrifice,
    scry,
    search,
    tap,
    untap,
    fateseal,
    clash,
    planeswalk,
    setInMotion("set in motion"),
    abandon,
    proliferate,
    transform,
    detain,
    populate,
    monstrosity,
    vote,
    bolster,
    manifest,
    support,
    investigate,
    meld,
    goad,
    exert,
    explore,
    assemble,
    surveil,
    adapt,
    amass,
    learn,
    venture("venture into the dungeon");

    private final String name;

    KeywordAction(final String s) {
        name = s;
    }

    KeywordAction() {
        name = name();
    }

    /**
     * Returns the action represented by s.
     *
     * @param s string that may contain an action, such as "draw"
     * @return action contained in s, if s represents one, otherwise null
     */
    public static KeywordAction fromString(final String s) {
        for (final KeywordAction type : KeywordAction.values()) {
            if (type.getWord().equalsIgnoreCase(s)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String getWord() {
        return name;
    }
}
