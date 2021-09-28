package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;
import tegenton.card.game.concepts.symbols.Symbol;

import java.util.EnumSet;
import java.util.Optional;

class HybridManaSymbol extends ColoredManaSymbol {
    private final Color colorA;
    private final Color colorB;

    private HybridManaSymbol(Color a, Color b) {
        super();
        colorA = a;
        colorB = b;
    }

    public static Optional<Symbol> fromString(String s) {
        HybridManaSymbol symbol;
        String[] parts = s.split("/");
        if (parts.length == 2) {
            try {
                symbol = new HybridManaSymbol(Color.fromString(parts[0]), Color.fromString(parts[1]));
            } catch (InvalidColorException e) {
                return Optional.empty();
            }
            return Optional.of(symbol);
        }
        return Optional.empty();
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
