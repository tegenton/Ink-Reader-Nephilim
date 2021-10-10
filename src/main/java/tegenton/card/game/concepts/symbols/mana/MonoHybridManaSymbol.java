package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;

final class MonoHybridManaSymbol extends ColoredManaSymbol {
    private final int value;

    private MonoHybridManaSymbol(final int genericValue, final Color c) {
        super();
        this.value = genericValue;
        this.setColor(c);
    }

    public static MonoHybridManaSymbol fromString(final String s) {
        final MonoHybridManaSymbol symbol;
        final String[] parts = s.split("/");
        if (parts.length == 2) {
            try {
                symbol = new MonoHybridManaSymbol(Integer.parseInt(parts[0]),
                        Color.fromString(parts[1]));
            } catch (final NumberFormatException | InvalidColorException e) {
                return null;
            }
            return symbol;
        }
        return null;
    }

    @Override
    public int getManaValue() {
        return value;
    }
}
