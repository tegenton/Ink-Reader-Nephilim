package tegenton.card.game.type.subtype;

import java.util.Optional;

public enum PlaneswalkerType implements Subtype {
    ajani,
    aminatou,
    angrath,
    arlinn,
    ashiok,
    basri,
    bolas,
    calix,
    chandra,
    dack,
    dakkon,
    daretti,
    davriel,
    dihada,
    domri,
    dovin,
    elspeth,
    estrid,
    freyalise,
    garruk,
    gideon,
    grist,
    huatli,
    jace,
    jaya,
    jeska,
    karn,
    kasmina,
    kaya,
    kiora,
    koth,
    liliana,
    lukka,
    nahiri,
    narset,
    niko,
    nissa,
    nixilis,
    oko,
    ral,
    rowan,
    saheeli,
    samut,
    sarkhan,
    serra,
    sorin,
    szat,
    tamiyo,
    teferi,
    teyo,
    tezzeret,
    tibalt,
    tyvar,
    ugin,
    venser,
    vivien,
    vraska,
    will,
    windgrace,
    wrenn,
    xenagos,
    yanggu,
    yanling;

    /**
     * Returns an optional containing the planeswalker type represented by s.
     *
     * @param s string that may contain a planeswalker type
     * @return planeswalker type contained in s, if s represents one,
     * otherwise empty
     */
    public static Optional<Subtype> fromString(final String s) {
        for (final PlaneswalkerType type : PlaneswalkerType.values()) {
            if (type.getName().equalsIgnoreCase(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getName() {
        return this.name().substring(0, 1).toUpperCase()
                + this.name().substring(1);
    }
}
