package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.symbols.Symbol;

import java.util.Optional;

class VariableManaSymbol extends ManaSymbol {
    private int x = 0;

    private VariableManaSymbol() {
        super();
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.equalsIgnoreCase("X")) {
            return Optional.of(new VariableManaSymbol());
        }
        return Optional.empty();
    }

    @Override
    public int getManaValue() {
        return x;
    }
}
