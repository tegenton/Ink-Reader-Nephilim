package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Function;

/**
 * The mana symbols are
 * {W}, {U}, {B}, {R}, {G}, and {C};
 * the numerical symbols {0}, {1}, {2}, {3}, {4}, and so on;
 * the variable symbol {X};
 * the hybrid symbols {W/U}, {W/B}, {U/B}, {U/R}, {B/R},
 * {B/G}, {R/G}, {R/W}, {G/W}, and {G/U};
 * the monocolored hybrid symbols {2/W}, {2/U}, {2/B}, {2/R}, and {2/G};
 * the Phyrexian mana symbols {W/P}, {U/P}, {B/P}, {R/P}, and {G/P};
 * and the snow symbol {S}.
 */
public abstract class ManaSymbol extends Symbol {
    private static Filter<ManaSymbol> filter;

    private static void setupFilter() {
        final List<Function<String, ManaSymbol>> manaSymbols;
        manaSymbols = List.of(PrimaryManaSymbol::fromString,
                NumericManaSymbol::fromString,
                VariableManaSymbol::fromString,
                HybridManaSymbol::fromString,
                MonoHybridManaSymbol::fromString,
                PhyrexianManaSymbol::fromString,
                SnowManaSymbol::fromString);
        filter = new Filter<>(manaSymbols);
    }

    /**
     * Determine if s represents a mana symbol.
     *
     * @param s a string which might represent a mana symbol, such as {W}
     * @return the ManaSymbol object represented by s, or null if s does not
     * represent a mana symbol
     */
    public static ManaSymbol fromString(final String s) {
        if (filter == null) {
            setupFilter();
        }
        if (s.startsWith("{") && s.endsWith("}")) {
            return filter.filter(removeBrackets(s));
        }
        return null;
    }

    /**
     * Returns the mana value of this symbol, which is usually 1.
     *
     * @return mana value of this symbol
     */
    public int getManaValue() {
        return 1;
    }

    /**
     * An EnumSet of colors that this symbol is. Generic and colorless symbols
     * return an empty set.
     *
     * @return the set of colors this symbol is
     */
    public EnumSet<Color> getType() {
        return EnumSet.noneOf(Color.class);
    }
}
