package game.type;

import game.type.subtype.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public enum Type {
    artifact(ArtifactType.class),
    conspiracy,
    creature(CreatureType.class),
    enchantment(EnchantmentType.class),
    instant(SpellType.class),
    land(LandType.class),
    phenomenon,
    plane(PlanarType.class),
    planeswalker(PlaneswalkerType.class),
    scheme,
    sorcery(SpellType.class),
    tribal(CreatureType.class),
    vanguard;

    private final Class<? extends Subtype> subtypes;

    Type() {
        this.subtypes = null;
    }

    Type(Class<? extends Subtype> subtypes) {
        this.subtypes = subtypes;
    }

    public Class<? extends Subtype> getSubtype() {
        return subtypes;
    }

    public boolean contains(String subtype) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (subtypes == null) {
            return false;
        }
        Method m = subtypes.getDeclaredMethod("contains", String.class);
        return (boolean) m.invoke(null, subtype);
    }

    public Subtype getSubtype(String subtype) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = subtypes.getDeclaredMethod("valueOf", String.class);
        return (Subtype) m.invoke(null, subtype);
    }
}
