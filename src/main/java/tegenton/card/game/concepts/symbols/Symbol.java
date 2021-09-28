package tegenton.card.game.concepts.symbols;

import tegenton.card.game.concepts.symbols.chapter.ChapterSymbol;
import tegenton.card.game.concepts.symbols.level.LevelSymbol;
import tegenton.card.game.concepts.symbols.loyalty.LoyaltySymbol;
import tegenton.card.game.concepts.symbols.mana.ManaSymbol;
import tegenton.card.game.concepts.symbols.planechase.PlanechaseSymbol;
import tegenton.card.game.concepts.symbols.tap.TapSymbol;
import tegenton.card.generic.Filter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class Symbol {
    private static Filter<Symbol> filter;

    private static void setupFilter() {
        List<Function<String, Optional<Symbol>>> symbols;
        symbols = List.of(VariableSymbol::fromString, ManaSymbol::fromString, TapSymbol::fromString, LoyaltySymbol::fromString, LevelSymbol::fromString, PlanechaseSymbol::fromString, EnergySymbol::fromString, ChapterSymbol::fromString);
        filter = new Filter<>(symbols);
    }

    public static Optional<Symbol> fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }

    protected static String removeBrackets(String s) {
        if (s.startsWith("{") && s.endsWith("}")) {
            s = s.substring(1, s.length() - 1);
        }
        return s;
    }
}
