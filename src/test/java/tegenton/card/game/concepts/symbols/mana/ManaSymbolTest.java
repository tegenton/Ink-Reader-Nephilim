package tegenton.card.game.concepts.symbols.mana;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ManaSymbolTest {
    /*
107.4. The mana tegenton.card.game.concept.symbols are {W}, {U}, {B}, {R}, {G}, and {C}; the numerical tegenton.card.game.concept.symbols {0}, {1},
    {2}, {3}, {4}, and so on; the variable symbol {X}; the hybrid tegenton.card.game.concept.symbols {W/U}, {W/B}, {U/B},
    {U/R}, {B/R}, {B/G}, {R/G}, {R/W}, {G/W}, and {G/U}; the monocolored hybrid tegenton.card.game.concept.symbols
    {2/W}, {2/U}, {2/B}, {2/R}, and {2/G}; the Phyrexian mana tegenton.card.game.concept.symbols {W/P}, {U/P}, {B/P},
    {R/P}, and {G/P}; and the snow symbol {S}.
*/
    public static ManaSymbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"{W}", "{U}", "{B}", "{R}", "{G}"})
    void primary(String s) {
        symbol = (ManaSymbol) ManaSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertEquals(PrimaryManaSymbol.class, symbol.getClass());
        assertEquals(1, symbol.getManaValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"{0}", "{1}", "{2}", "{3}", "{4}", "{5}", "{6}", "{7}", "{8}", "{9}"})
    void numeric(String s) {
        symbol = (ManaSymbol) ManaSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertEquals(NumericManaSymbol.class, symbol.getClass());
    }

    @Test
    void variable() {
        symbol = (ManaSymbol) ManaSymbol.fromString("{X}").orElse(null);
        assertNotNull(symbol);
        assertEquals(VariableManaSymbol.class, symbol.getClass());
        assertEquals(0, symbol.getManaValue());
    }

    @Test
    void hybrid() {
        symbol = (ManaSymbol) ManaSymbol.fromString("{U/W}").orElse(null);
        assertNotNull(symbol);
        assertEquals(HybridManaSymbol.class, symbol.getClass());
        assertEquals(1, symbol.getManaValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"{2/W}", "{2/U}", "{2/B}", "{2/R}", "{2/G}"})
    void monocolorHybrid(String s) {
        symbol = (ManaSymbol) ManaSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertEquals(MonoHybridManaSymbol.class, symbol.getClass());
        assertEquals(2, symbol.getManaValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"{W/P}", "{U/P}", "{B/P}", "{R/P}", "{G/P}"})
    void phyrexian(String s) {
        symbol = (ManaSymbol) ManaSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertEquals(PhyrexianManaSymbol.class, symbol.getClass());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void snow() {
        symbol = (ManaSymbol) ManaSymbol.fromString("{S}").orElse(null);
        assertNotNull(symbol);
        assertEquals(SnowManaSymbol.class, symbol.getClass());
        assertEquals(1, symbol.getManaValue());
    }
}
