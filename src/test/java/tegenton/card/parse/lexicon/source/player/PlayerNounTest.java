package tegenton.card.parse.lexicon.source.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.parse.Lexer;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class PlayerNounTest {
    public static List<Word> expected;
    public static String input;

    @AfterEach
    void check() {
        Lexer lexer = new Lexer();
        List<Word> actual = lexer.lex(input);
        assertIterableEquals(expected, actual);
    }

    @Test
    void controller() {
        expected = List.of(PlayerVerb.CONTROL, Morpheme.ER);
        input = "controller";
    }

    @Test
    void owner() {
        expected = List.of(PlayerVerb.OWN, Morpheme.ER);
        input = "owner";
    }

    @Test
    void opponent() {
        expected = List.of(PlayerNoun.OPPONENT);
        input = "opponent";
    }

    @Test
    void player() {
        expected = List.of(PlayerVerb.PLAY, Morpheme.ER);
        input = "player";
    }

    @Test
    void they() {
        expected = List.of(PlayerNoun.THEY);
        input = "they";
    }

    @Test
    void you() {
        expected = List.of(PlayerNoun.YOU);
        input = "you";
    }
}
