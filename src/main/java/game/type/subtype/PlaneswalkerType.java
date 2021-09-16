package game.type.subtype;

import java.util.HashSet;
import java.util.Set;

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
    static final Set<String> types = new HashSet<>();

    static public boolean contains(String s) {
        if (types.isEmpty()) {
            for (PlaneswalkerType type : PlaneswalkerType.values()) {
                types.add(type.getName());
            }
        }
        return types.contains(s);
    }

    @Override
    public String getName() {
        return this.name();
    }
}
