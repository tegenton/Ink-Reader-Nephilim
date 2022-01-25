package tegenton.card.lexicon.game;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.WordTestTemplate;

import java.util.List;

public class SymbolWordTest extends WordTestTemplate {
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

    @Test
    void tap() {
        words = Tap.values();
        values = List.of("T");
    }
}
