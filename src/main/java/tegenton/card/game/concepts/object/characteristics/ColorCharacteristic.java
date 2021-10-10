package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.concepts.Color;
import java.util.EnumSet;

final class ColorCharacteristic extends Characteristic<EnumSet<Color>> {
    private final EnumSet<Color> colors = EnumSet.noneOf(Color.class);

    private ColorCharacteristic(final Color color) {
        super();
        if (color != null) {
            colors.add(color);
        }
    }

    public static ColorCharacteristic fromString(final String s) {
        try {
            return new ColorCharacteristic(Color.valueOf(s.toLowerCase()));
        } catch (final IllegalArgumentException e) {
            if (s.equalsIgnoreCase("colorless")) {
                return new ColorCharacteristic(null);
            }
            return null;
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
