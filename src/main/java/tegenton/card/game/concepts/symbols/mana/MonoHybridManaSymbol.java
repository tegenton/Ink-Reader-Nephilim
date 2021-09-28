package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;
import tegenton.card.game.concepts.symbols.Symbol;

import java.util.Optional;

class MonoHybridManaSymbol extends ColoredManaSymbol {
    private final int value;

    private MonoHybridManaSymbol(int value, Color c) {
        super();
        this.value = value;
        color = c;
    }

    public static Optional<Symbol> fromString(String s) {
        MonoHybridManaSymbol symbol;
        String[] parts = s.split("/");
        if (parts.length == 2) {
            try {
                symbol = new MonoHybridManaSymbol(Integer.parseInt(parts[0]), Color.fromString(parts[1]));
            } catch (NumberFormatException | InvalidColorException e) {
                return Optional.empty();
            }
            return Optional.of(symbol);
        }
        return Optional.empty();
    }

    @Override
    public int getManaValue() {
        return value;
    }
}
