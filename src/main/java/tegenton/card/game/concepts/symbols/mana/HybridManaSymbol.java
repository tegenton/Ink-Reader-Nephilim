package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;
import java.util.EnumSet;

final class HybridManaSymbol extends ColoredManaSymbol {
    private final Color colorA;
    private final Color colorB;

    private HybridManaSymbol(final Color a, final Color b) {
        super();
        colorA = a;
        colorB = b;
    }

    public static HybridManaSymbol fromString(final String s) {
        final HybridManaSymbol symbol;
        final String[] parts = s.split("/");
        if (parts.length == 2) {
            try {
                symbol = new HybridManaSymbol(Color.fromString(parts[0]),
                        Color.fromString(parts[1]));
            } catch (final InvalidColorException e) {
                return null;
            }
            return symbol;
        }
        return null;
    }

    @Override
    public EnumSet<Color> getType() {
        return EnumSet.of(colorA, colorB);
    }
}
