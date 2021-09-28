package tegenton.card.game.concepts.symbols;

import java.util.Optional;

class VariableSymbol extends Symbol {
    private VariableSymbol() {
        super();
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.equalsIgnoreCase("X")) {
            return Optional.of(new VariableSymbol());
        }
        return Optional.empty();
    }
}
