package game.concepts.symbols.tap;

import game.concepts.symbols.Symbol;

import java.util.Optional;

class TapTapSymbol extends TapSymbol {
    private TapTapSymbol() {
        super();
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.equalsIgnoreCase("T")) {
            return Optional.of(new TapTapSymbol());
        }
        return Optional.empty();
    }
}
