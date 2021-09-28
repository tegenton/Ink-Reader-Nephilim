package tegenton.card.game.concepts.symbols.tap;

import tegenton.card.game.concepts.symbols.Symbol;

import java.util.Optional;

class UntapSymbol extends TapSymbol {
    private UntapSymbol() {
        super();
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.equalsIgnoreCase("Q")) {
            return Optional.of(new UntapSymbol());
        }
        return Optional.empty();
    }
}
