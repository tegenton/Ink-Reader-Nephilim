package tegenton.card.game.concepts.symbols;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EnergySymbolTest {
    public static Symbol symbol;

    @Test
    void energy() {
        symbol = EnergySymbol.fromString("{E}").orElse(null);
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = EnergySymbol.fromString("E").orElse(null);
        assertNull(symbol);
    }

}
