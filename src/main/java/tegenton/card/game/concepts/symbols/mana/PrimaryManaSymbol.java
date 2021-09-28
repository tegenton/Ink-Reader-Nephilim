package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;
import tegenton.card.game.concepts.symbols.Symbol;

import java.util.Optional;

class PrimaryManaSymbol extends ColoredManaSymbol {
    // {W}, {U}, {B}, {R}, {G}, and {C}
    private PrimaryManaSymbol(Color color) {
        this.color = color;
    }

    public static Optional<Symbol> fromString(String s) {
        PrimaryManaSymbol symbol;
        try {
            symbol = new PrimaryManaSymbol(Color.fromString(s));
        } catch (InvalidColorException e) {
            return Optional.empty();
        }
        return Optional.of(symbol);
    }

    @Override
    public int getManaValue() {
        return 1;
    }
}
