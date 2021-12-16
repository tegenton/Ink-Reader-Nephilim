package tegenton.card.parse.lexicon.game;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;

import java.util.List;

public class ColorWordTest extends WordTest {
    @Test
    void colorWord() {
        words = ColorWord.values();
        values = List.of("WHITE", "BLUE", "BLACK", "RED", "GREEN");
    }

    @Test
    void color() {
        words = Color.values();
        values = List.of("W", "U", "B", "R", "G", "C");
    }
}
