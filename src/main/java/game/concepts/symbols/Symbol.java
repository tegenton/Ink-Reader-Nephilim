package game.concepts.symbols;

import game.concepts.symbols.chapter.ChapterSymbol;
import game.concepts.symbols.level.LevelSymbol;
import game.concepts.symbols.loyalty.LoyaltySymbol;
import game.concepts.symbols.mana.ManaSymbol;
import game.concepts.symbols.planechase.PlanechaseSymbol;
import game.concepts.symbols.tap.TapSymbol;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class Symbol {

    private static final List<Function<String, Optional<Symbol>>> symbols;

    static {
        symbols = List.of(VariableSymbol::fromString, ManaSymbol::fromString, TapSymbol::fromString, LoyaltySymbol::fromString, LevelSymbol::fromString, PlanechaseSymbol::fromString, EnergySymbol::fromString, ChapterSymbol::fromString);
    }

    public static Optional<Symbol> fromString(String s) {
        Symbol result;
        for (Function<String, Optional<Symbol>> test : symbols) {
            result = test.apply(s).orElse(null);
            if (result != null) {
                return Optional.of(result);
            }
        }
        return Optional.empty();
    }

    protected static String removeBrackets(String s) {
        if (s.startsWith("{") && s.endsWith("}")) {
            s = s.substring(1, s.length() - 1);
        }
        return s;
    }
}
