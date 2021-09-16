package game.concepts.symbols.planechase;

import game.concepts.symbols.Symbol;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class PlanechaseSymbol extends Symbol {
    private static final List<Function<String, Optional<Symbol>>> planechaseSymbols;

    static {
        planechaseSymbols = List.of(PlaneswalkSymbol::fromString, ChaosSymbol::fromString);
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.startsWith("{") && s.endsWith("}")) {
            s = removeBrackets(s);
            Optional<Symbol> result;
            for (Function<String, Optional<Symbol>> test : planechaseSymbols) {
                result = test.apply(s);
                if (result.isPresent()) {
                    return result;
                }
            }
        }
        return Optional.empty();
    }
}