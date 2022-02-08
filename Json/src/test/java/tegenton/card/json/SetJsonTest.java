package tegenton.card.json;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetJsonTest {
    public static final SetJson lea = new SetJson(
            SetJsonTest.class.getClassLoader().getResourceAsStream("LEA.json"));

    @Test
    void cardCount() {
        assertEquals(295, lea.cardCount());
    }
}
