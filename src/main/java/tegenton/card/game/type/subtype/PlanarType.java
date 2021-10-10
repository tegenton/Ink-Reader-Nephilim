package tegenton.card.game.type.subtype;

import java.util.Optional;

public enum PlanarType implements Subtype {
    alara,
    arkhos,
    azgol,
    belenon,
    bolassmeditationrealm("Bolas's Meditation Realm"),
    dominaria,
    equilor,
    ergamon,
    fabacin,
    innistrad,
    iquatana,
    ir,
    kaldheim,
    kamigawa,
    karsus,
    kephalai,
    kinshala,
    kolbahan,
    kyneth,
    lorwyn,
    luvion,
    mercadia,
    mirrodin,
    moag,
    mongseng,
    muraganda,
    newphyrexia("New Phyrexia"),
    phyrexia,
    pyrulea,
    rabiah,
    rath,
    ravnica,
    regatha,
    segovia,
    serrasrealm("Serra's Realm"),
    shadowmoor,
    shandalar,
    ulgrotha,
    valla,
    vryn,
    wildfire,
    xerex,
    zendikar;

    private final String name;

    PlanarType(final String planeName) {
        this.name = planeName;
    }

    PlanarType() {
        this.name = this.name().substring(0, 1).toUpperCase()
                + this.name().substring(1);
    }


    /**
     * Returns an optional containing the planar type represented by s.
     *
     * @param s string that may contain a planar type
     * @return planar type contained in s, if s represents one, otherwise empty
     */
    public static Optional<Subtype> fromString(final String s) {
        for (final PlanarType type : PlanarType.values()) {
            if (type.getName().equalsIgnoreCase(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
