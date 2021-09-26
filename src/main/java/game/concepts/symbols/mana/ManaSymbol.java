package game.concepts.symbols.mana;

import game.concepts.Color;
import game.concepts.symbols.Symbol;
import generic.Filter;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class ManaSymbol extends Symbol {
    private static Filter<Symbol> filter;

    private static void setupFilter() {
        List<Function<String, Optional<Symbol>>> manaSymbols;
        manaSymbols = List.of(PrimaryManaSymbol::fromString, NumericManaSymbol::fromString, VariableManaSymbol::fromString, HybridManaSymbol::fromString, MonoHybridManaSymbol::fromString, PhyrexianManaSymbol::fromString, SnowManaSymbol::fromString);
        filter = new Filter<>(manaSymbols);
    }

    /*
    107.4. The mana symbols are {W}, {U}, {B}, {R}, {G}, and {C}; the numerical symbols {0}, {1},
        {2}, {3}, {4}, and so on; the variable symbol {X}; the hybrid symbols {W/U}, {W/B}, {U/B},
        {U/R}, {B/R}, {B/G}, {R/G}, {R/W}, {G/W}, and {G/U}; the monocolored hybrid symbols
        {2/W}, {2/U}, {2/B}, {2/R}, and {2/G}; the Phyrexian mana symbols {W/P}, {U/P}, {B/P},
        {R/P}, and {G/P}; and the snow symbol {S}.
    */
    public static Optional<Symbol> fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        if (s.startsWith("{") && s.endsWith("}")) {
            s = removeBrackets(s);
            return filter.filter(s);
        }
        return Optional.empty();
    }

    public abstract int getManaValue();

    public EnumSet<Color> getType() {
        return EnumSet.noneOf(Color.class);
    }
}
