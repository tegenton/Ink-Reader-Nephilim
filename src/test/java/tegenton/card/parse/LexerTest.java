package tegenton.card.parse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Symbol;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.parse.lexicon.value.EnglishNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class LexerTest {
    public static Lexer lex;

    @BeforeEach
    void setup() {
        lex = new Lexer();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "one", "flying", "draw", "1", ".", "any",
            "when"})
    void singleWord(String text) {
        List<Word> tokens = Stream.of(text).collect(lex).toList();
        StringBuilder s = new StringBuilder();
        for (Word token : tokens) {
            s.append(token.getWord());
        }
        assertEquals(text.toLowerCase(), s.toString().toLowerCase());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a one flying draw 1 . any when "})
    void multiWord(String text) {
        List<Word> tokens =
                Arrays.stream(text.split(" ")).map(s -> s + " ").collect(lex)
                        .toList();
        StringBuilder actual = new StringBuilder();
        for (Word token : tokens) {
            actual.append(token.getWord());
        }
        assertEquals(text, actual.toString().toLowerCase());
    }

    @Test
    void ancestrallRecall() {
        List<Word> expected =
                List.of(Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY,
                        Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW,
                        Symbol.SPACE, EnglishNumber.THREE, Symbol.SPACE,
                        ObjectNoun.CARD, Morpheme.S, Symbol.PERIOD);
        List<Word> actual = lex.lex("Target player draws three cards.");
        assertIterableEquals(expected, actual);
    }
}
