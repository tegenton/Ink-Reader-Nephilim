package tegenton.card.json;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetJsonTest {
    public static SetJson lea;

    @Test
    void cardCountByCode() {
        lea = new SetJson("LEA");
        assertEquals(295, lea.cardCount());
    }

    @Test
    void fakeSet() {
        assertThrows(RuntimeException.class, () -> lea = new SetJson("fake"));
    }
}
