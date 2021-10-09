package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;

import java.util.EnumSet;

class HybridManaSymbol extends ColoredManaSymbol {
    private final Color colorA;
    private final Color colorB;

    private HybridManaSymbol(Color a, Color b) {
        super();
        colorA = a;
        colorB = b;
    }

    public static HybridManaSymbol fromString(String s) {
        HybridManaSymbol symbol;
        String[] parts = s.split("/");
        if (parts.length == 2) {
            try {
                symbol = new HybridManaSymbol(Color.fromString(parts[0]),
                        Color.fromString(parts[1]));
            } catch (InvalidColorException e) {
                return null;
            }
            return symbol;
        }
        return null;
    }

    @Override
    public int getManaValue() {
        return 1;
    }

    @Override
    public EnumSet<Color> getType() {
        return EnumSet.of(colorA, colorB);
    }
}
