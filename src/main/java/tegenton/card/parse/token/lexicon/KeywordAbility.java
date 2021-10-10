package tegenton.card.parse.token.lexicon;

public enum KeywordAbility implements Word {
    deathtouch,
    defender,
    doubleStrike("Double Strike"),
    enchant,
    equip,
    firstStrike("First Strike"),
    flash,
    flying,
    haste,
    hexproof,
    indestructible,
    intimidate,
    landwalk,
    lifelink,
    protection,
    reach,
    shroud,
    trample,
    vigilance,
    ward,
    banding,
    rampage,
    cumulativeUpkeep("Cumulative Upkeep"),
    flanking,
    phasing,
    buyback,
    shadow,
    cycling,
    echo,
    horsemanship,
    fading,
    kicker,
    multikicker,
    flashback,
    madness,
    fear,
    morph,
    megamorph,
    amplify,
    provoke,
    storm,
    affinity,
    entwine,
    modular,
    sunburst,
    bushido,
    soulshift,
    splice,
    offering,
    ninjutsu,
    commanderNinjutsu("Commander Ninjutsu"),
    epic,
    convoke,
    dredge,
    transmute,
    bloodthirst,
    haunt,
    replicate,
    forecast,
    graft,
    recover,
    ripple,
    splitSecond("Split Second"),
    suspend,
    vanishing,
    absorb,
    auraSwap("Aura Swap"),
    delve,
    fortify,
    frenzy,
    gravestorm,
    poisonous,
    transfigure,
    champion,
    changeling,
    evoke,
    hideaway,
    prowl,
    reinforce,
    conspire,
    persist,
    wither,
    retrace,
    devour,
    exalted,
    unearth,
    cascade,
    annihilator,
    levelUp("Level Up"),
    rebound,
    totemArmor("Totem Armor"),
    infect,
    battleCry("Battle Cry"),
    livingWeapon("Living Weapon"),
    undying,
    miracle,
    soulbond,
    overload,
    scavenge,
    unleash,
    cipher,
    evolve,
    extort,
    fuse,
    bestow,
    tribute,
    dethrone,
    hiddenAgenda("Hidden Agenda"),
    doubleAgenda("Double Agenda"),
    outlast,
    prowess,
    dash,
    exploit,
    menace,
    renown,
    awaken,
    devoid,
    ingest,
    myriad,
    surge,
    skulk,
    emerge,
    escalate,
    melee,
    crew,
    fabricate,
    partner,
    undaunted,
    improvise,
    aftermath,
    embalm,
    eternalize,
    afflict,
    ascend,
    assist,
    jumpStart("Jump-Start"),
    mentor,
    afterlife,
    riot,
    spectacle,
    escape,
    companion,
    mutate,
    encore,
    boast,
    foretell,
    demonstrate,
    daybound,
    nightbound,
    disturb,
    decayed;
    private final String name;

    KeywordAbility(final String s) {
        name = s;
    }

    KeywordAbility() {
        name = name().substring(0, 1).toUpperCase() + name().substring(1);
    }

    /**
     * Returns the ability represented by s.
     *
     * @param s string that may contain an ability, such as "lifelink"
     * @return ability contained in s, if s represents one, otherwise null
     */
    public static KeywordAbility fromString(final String s) {
        for (final KeywordAbility type : KeywordAbility.values()) {
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
