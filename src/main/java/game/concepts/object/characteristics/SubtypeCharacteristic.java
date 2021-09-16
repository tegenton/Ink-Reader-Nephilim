package game.concepts.object.characteristics;

import game.type.subtype.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

class SubtypeCharacteristic extends Characteristic {
    private final List<Subtype> type = new ArrayList<>();

    private SubtypeCharacteristic(Subtype type) {
        super();
        this.type.add(type);
    }

    public static Optional<Characteristic> fromString(String s) {
        s = s.toLowerCase();
        if (ArtifactType.contains(s)) {
            return Optional.of(new SubtypeCharacteristic(ArtifactType.valueOf(s)));
        } else if (CreatureType.contains(s)) {
            return Optional.of(new SubtypeCharacteristic(CreatureType.valueOf(s)));
        } else if (EnchantmentType.contains(s)) {
            return Optional.of(new SubtypeCharacteristic(EnchantmentType.valueOf(s)));
        } else if (LandType.contains(s)) {
            return Optional.of(new SubtypeCharacteristic(LandType.valueOf(s)));
        } else if (PlanarType.contains(s)) {
            return Optional.of(new SubtypeCharacteristic(PlanarType.valueOf(s)));
        } else if (PlaneswalkerType.contains(s)) {
            return Optional.of(new SubtypeCharacteristic(PlaneswalkerType.valueOf(s)));
        } else if (SpellType.contains(s)) {
            return Optional.of(new SubtypeCharacteristic(SpellType.valueOf(s)));
        }
        return Optional.empty();
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.subtype;
    }

    @Override
    public void add(Characteristic characteristic) {
        if (characteristic.getClass() == SubtypeCharacteristic.class) {
            this.type.addAll(((SubtypeCharacteristic) characteristic).type);
        }
    }

    @Override
    public Object value() {
        return type;
    }

    @Override
    public void add(Object value) {
        if (List.class.isAssignableFrom(value.getClass())) {
            type.addAll((Collection<? extends Subtype>) value);
        }
    }
}
