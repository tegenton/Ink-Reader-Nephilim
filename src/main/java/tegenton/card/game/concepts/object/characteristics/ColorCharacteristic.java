package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.concepts.Color;
import java.util.ArrayList;
import java.util.List;

final class ColorCharacteristic extends Characteristic {
    private final List<Color> colors = new ArrayList<>();

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
    public List<Color> value() {
        return colors;
    }
}
