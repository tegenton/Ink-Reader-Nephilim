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

    PlanarType(String name) {
        this.name = name;
    }

    PlanarType() {
        this.name = this.name().substring(0, 1).toUpperCase() + this.name().substring(1);
    }

    public static Optional<Subtype> fromString(String s) {
        for (PlanarType type : PlanarType.values()) {
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
