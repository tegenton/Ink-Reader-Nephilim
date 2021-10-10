package tegenton.card.game.concepts.symbols;

import tegenton.card.game.concepts.symbols.chapter.ChapterSymbol;
import tegenton.card.game.concepts.symbols.level.LevelSymbol;
import tegenton.card.game.concepts.symbols.loyalty.LoyaltySymbol;
import tegenton.card.game.concepts.symbols.mana.ManaSymbol;
import tegenton.card.game.concepts.symbols.planechase.PlanechaseSymbol;
import tegenton.card.game.concepts.symbols.tap.TapSymbol;
import tegenton.card.generic.Filter;
import java.util.List;
import java.util.function.Function;

/**
 * A symbol is a mana symbol, a tap or untap symbol, a loyalty symbol, a level
 * symbol, a planechase symbol, an energy symbol, or a chapter symbol.
 */
public abstract class Symbol {
    private static Filter<Symbol> filter;

    private static void setupFilter() {
        final List<Function<String, Symbol>> symbols;
        symbols = List.of(VariableSymbol::fromString,
                ManaSymbol::fromString,
                TapSymbol::fromString,
                LoyaltySymbol::fromString,
                LevelSymbol::fromString,
                PlanechaseSymbol::fromString,
                EnergySymbol::fromString,
                ChapterSymbol::fromString);
        filter = new Filter<>(symbols);
    }

    /**
     * Returns the symbol represented by s.
     *
     * @param s string that may contain a symbol
     * @return symbol contained in s, if s represents one, otherwise null
     */
    public static Symbol fromString(final String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }

    protected static String removeBrackets(final String s) {
        if (s.startsWith("{") && s.endsWith("}")) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
}
