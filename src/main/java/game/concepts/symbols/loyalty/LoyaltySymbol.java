package game.concepts.symbols.loyalty;

import game.concepts.symbols.Symbol;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class LoyaltySymbol extends Symbol {
    private static final List<Function<String, Optional<Symbol>>> chapterSymbols;

    static {
        chapterSymbols = List.of(StaticLoyaltySymbol::fromString, VariableLoyaltySymbol::fromString);
    }

    public static Optional<Symbol> fromString(String s) {
        Optional<Symbol> result;
        for (Function<String, Optional<Symbol>> test : chapterSymbols) {
            result = test.apply(s);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }
}
