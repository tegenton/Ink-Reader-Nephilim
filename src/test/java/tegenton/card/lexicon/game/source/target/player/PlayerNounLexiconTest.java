package tegenton.card.lexicon.game.source.target.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.Lexer;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class PlayerNounLexiconTest {
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
    void you() {
        expected = List.of(PlayerNoun.YOU);
        input = "you";
    }
}
