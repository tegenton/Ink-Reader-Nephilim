package tegenton.card.lexer.tokenizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenizerTest {
    public static String input;
    public static List<Word> expected;

    @AfterEach
    void compare() {
        Tokenizer tokenizer = new Tokenizer();
        assertEquals(expected, tokenizer.tokenize(input));
    }

    @Test
    void a() {
        input = "A";
        expected = List.of(Determiner.A);
    }

    @Test
    void b() {
        input = "BE";
        expected = List.of(GameVerb.BE);
    }

    @Test
    void c() {
        input = "CARD";
        expected = List.of(ObjectNoun.CARD);
    }

    @Test
    void d() {
        input = "DRAW";
        expected = List.of(PlayerVerb.DRAW);
    }

    @Test
    void e() {
        input = "EACH";
        expected = List.of(Determiner.EACH);
    }

    @Test
    void f() {
        input = "FOR";
        expected = List.of(Preposition.FOR);
    }

    @Test
    void p() {
        input = "PLAY";
        expected = List.of(PlayerVerb.PLAY);
    }
}
