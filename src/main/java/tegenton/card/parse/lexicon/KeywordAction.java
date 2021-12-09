package tegenton.card.parse.lexicon;

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

    @Override
    public String getWord() {
        return name;
    }
}
