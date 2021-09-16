package game.concepts.symbols.tap;

import game.concepts.symbols.Symbol;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class TapSymbol extends Symbol {
    private static final List<Function<String, Optional<Symbol>>> tapSymbols;

    static {
        tapSymbols = List.of(TapTapSymbol::fromString, UntapSymbol::fromString);
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.startsWith("{") && s.endsWith("}")) {
            s = removeBrackets(s);
            Optional<Symbol> result;
            for (Function<String, Optional<Symbol>> test : tapSymbols) {
                result = test.apply(s);
                if (result.isPresent()) {
                    return result;
                }
            }
        }
        return Optional.empty();
    }
}
