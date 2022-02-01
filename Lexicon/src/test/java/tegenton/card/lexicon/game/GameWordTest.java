package tegenton.card.lexicon.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameWordTest {
    public static Word[] words;
    public static List<String> values;

    @AfterEach
    void compare() {
        assertEquals(values.size(), words.length);
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].toString());
        }
    }

    @Test
    void colorWord() {
        words = ColorWord.values();
        values = List.of("WHITE", "BLUE", "BLACK", "RED", "GREEN");
    }

    @Test
    void keyword() {
        words = Keyword.values();
        values = List.of("BANDING", "DEFENDER", "ENCHANT", "FEAR", "FLYING",
                "HASTE", "INDESTRUCTIBLE", "PROTECTION", "REACH", "STRIKE",
                "TRAMPLE", "VIGILANCE", "WALK");
    }

    @Test
    void noun() {
        words = GameNoun.values();
        values = List.of("ABILITY", "COLOR", "DAMAGE", "EFFECT", "GAME", "LIFE",
                "MANA", "PILE", "STEP", "TURN", "TYPE");
    }

    @Test
    void triggerWord() {
        words = TriggerWord.values();
        values = List.of("WHEN", "WHENEVER", "AT");
    }

    @Test
    void verb() {
        words = GameVerb.values();
        values = List.of("BE", "CAUSE", "FINISH", "TOUCH");
    }

    @Test
    void zone() {
        words = Zone.values();
        values = List.of("ANTE", "BATTLEFIELD", "DECK", "EXILE", "GRAVEYARD",
                "HAND", "LIBRARY");
    }
}
