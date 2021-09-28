package tegenton.card.game.concepts.symbols;

import tegenton.card.game.concepts.symbols.chapter.ChapterSymbol;
import tegenton.card.game.concepts.symbols.level.LevelSymbol;
import tegenton.card.game.concepts.symbols.loyalty.LoyaltySymbol;
import tegenton.card.game.concepts.symbols.mana.ManaSymbol;
import tegenton.card.game.concepts.symbols.planechase.PlanechaseSymbol;
import tegenton.card.game.concepts.symbols.tap.TapSymbol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolTest {
    public static Symbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"{W}", "X", "{T}", "[+1]", "LEVEL 1-2", "{PW}", "{E}", "I"})
    void isValid(String s) {
        symbol = Symbol.fromString(s).orElse(null);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"W", "Whenever", ""})
    void isInvalid(String s) {
        symbol = Symbol.fromString(s).orElse(null);
        assertNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"{W}", "{0}", "{X}", "{W/U}", "{2/W}", "{W/P}", "{S}"})
    void mana(String s) {
        symbol = Symbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertTrue(ManaSymbol.class.isAssignableFrom(symbol.getClass()));
    }

    @Test
    void variable() {
        symbol = Symbol.fromString("X").orElse(null);
        assertNotNull(symbol);
        assertTrue(VariableSymbol.class.isAssignableFrom(symbol.getClass()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"{T}", "{Q}"})
    void tap(String s) {
        symbol = Symbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertTrue(TapSymbol.class.isAssignableFrom(symbol.getClass()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"[+1]", "+1", "0", "-1", "-X"})
    void loyalty(String s) {
        symbol = Symbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertTrue(LoyaltySymbol.class.isAssignableFrom(symbol.getClass()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"LEVEL 1-2", "LEVEL 3+"})
    void level(String s) {
        symbol = Symbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertTrue(LevelSymbol.class.isAssignableFrom(symbol.getClass()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"{PW}", "{CHAOS}"})
    void planechase(String s) {
        symbol = Symbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertTrue(PlanechaseSymbol.class.isAssignableFrom(symbol.getClass()));
    }

    @Test
    void energy() {
        symbol = Symbol.fromString("{E}").orElse(null);
        assertNotNull(symbol);
        assertTrue(EnergySymbol.class.isAssignableFrom(symbol.getClass()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"I", "I,II"})
    void chapter(String s) {
        symbol = Symbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertTrue(ChapterSymbol.class.isAssignableFrom(symbol.getClass()));
    }
}
