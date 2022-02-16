package tegenton.card.lexicon.game.type;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterWordTest {

    @Test
    void counters() {
        final CounterType[] words = CounterType.values();
        final List<String> values = List.of("CORPSE", "MIRE", "VITALITY");
        assertEquals(values.size(), words.length);
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].toString());
        }
    }

}
