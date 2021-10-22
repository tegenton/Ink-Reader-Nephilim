package tegenton.card.parse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.game.type.subtype.Subtype;
import tegenton.card.parse.token.lexicon.EnglishNumber;
import tegenton.card.parse.token.lexicon.Subject;
import tegenton.card.parse.token.lexicon.Verb;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {
    public static String text;
    public static Lexer lex;

    @BeforeEach
    void setup() {
        lex = new Lexer();
    }

    @Test
    void draw() {
        text = "draw";
        lex.consume(text);
        assertEquals(Verb.draw, lex.next());
    }

    @Test
    void two() {
        text = "two";
        lex.consume(text);
        assertEquals(EnglishNumber.two, lex.next());
    }

    @Test
    void card() {
        text = "card";
        lex = new Lexer();
        lex.consume(text);
        assertEquals(Subject.card, lex.next());
    }
}
