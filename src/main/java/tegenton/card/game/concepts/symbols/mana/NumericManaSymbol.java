package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.symbols.Symbol;

import java.util.Optional;

class NumericManaSymbol extends ManaSymbol {
    // {0}, {1}, {2}, and so on
    private final int value;

    private NumericManaSymbol(int value) {
        super();
        this.value = value;
    }

    public static Optional<Symbol> fromString(String s) {
        NumericManaSymbol symbol;
        try {
            symbol = new NumericManaSymbol(Integer.parseInt(s));
        } catch (NumberFormatException n) {
            return Optional.empty();
        }
        return Optional.of(symbol);
    }

    @Override
    public int getManaValue() {
        return value;
    }
}
