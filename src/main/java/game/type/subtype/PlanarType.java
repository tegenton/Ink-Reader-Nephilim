package game.type.subtype;

import java.util.HashSet;
import java.util.Set;

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

    static final Set<String> types = new HashSet<>();
    private final String name;

    PlanarType(String name) {
        this.name = name;
    }

    PlanarType() {
        this.name = this.name();
    }

    public static boolean contains(String s) {
        if (types.isEmpty()) {
            for (PlanarType type : PlanarType.values()) {
                types.add(type.getName());
            }
        }
        return types.contains(s);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
