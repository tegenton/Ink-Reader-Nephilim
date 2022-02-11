package tegenton.card.lexer.tokenizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Genitive;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.Tap;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Phase;
import tegenton.card.lexicon.value.Variable;

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
    void g() {
        input = "GET";
        expected = List.of(ObjectVerb.GET);
    }

    @Test
    void h() {
        input = "HALF";
        expected = List.of(Genitive.HALF);
    }

    @Test
    void l() {
        input = "LIFE";
        expected = List.of(GameNoun.LIFE);
    }

    @Test
    void m() {
        input = "MAIN";
        expected = List.of(Phase.MAIN);
    }

    @Test
    void n() {
        input = "NAME";
        expected = List.of(ObjectAttribute.NAME);
    }

    @Test
    void o() {
        input = "OF";
        expected = List.of(Preposition.OF);
    }

    @Test
    void p() {
        input = "PLAY";
        expected = List.of(PlayerVerb.PLAY);
    }

    @Test
    void r() {
        input = "R";
        expected = List.of(ManaSymbol.R);
    }

    @Test
    void s() {
        input = "S";
        expected = List.of(Morpheme.S);
    }

    @Test
    void t() {
        input = "T";
        expected = List.of(Tap.T);
    }

    @Test
    void u() {
        input = "U";
        expected = List.of(ManaSymbol.U);
    }

    @Test
    void v() {
        input = "VALUE";
        expected = List.of(ObjectAttribute.VALUE);
    }

    @Test
    void w() {
        input = "W";
        expected = List.of(ManaSymbol.W);
    }

    @Test
    void x() {
        input = "X";
        expected = List.of(Variable.X);
    }

    @Test
    void y() {
        input = "Y";
        expected = List.of(Variable.Y);
    }
}
