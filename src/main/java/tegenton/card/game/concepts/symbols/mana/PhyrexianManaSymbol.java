package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;
import tegenton.card.game.concepts.symbols.Symbol;

import java.util.Optional;

class PhyrexianManaSymbol extends ColoredManaSymbol {
    private PhyrexianManaSymbol(Color color) {
        super();
        this.color = color;
    }

    public static Optional<Symbol> fromString(String s) {
        PhyrexianManaSymbol symbol;
        String[] parts = s.split("/");
        if (parts.length == 2 && parts[1].equalsIgnoreCase("P")) {
            try {
                symbol = new PhyrexianManaSymbol(Color.fromString(parts[0]));
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
}
