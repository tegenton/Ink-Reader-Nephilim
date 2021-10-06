package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.concepts.Color;

import java.util.EnumSet;
import java.util.Optional;

class ColorCharacteristic extends Characteristic<EnumSet<Color>> {
    private final EnumSet<Color> colors = EnumSet.noneOf(Color.class);

    private ColorCharacteristic(Color color) {
        super();
        if (color != null) {
            colors.add(color);
        }
    }

    public static Optional<Characteristic<?>> fromString(String s) {
        s = s.toLowerCase();
        try {
            return Optional.of(new ColorCharacteristic(Color.valueOf(s)));
        } catch (IllegalArgumentException e) {
            if (s.equalsIgnoreCase("colorless")) {
                return Optional.of(new ColorCharacteristic(null));
            }
            return Optional.empty();
        }
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.color;
    }

    @Override
    public EnumSet<Color> value() {
        return colors;
    }
}
