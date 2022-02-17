package tegenton.card.parser.node.atom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorNodeTest {
    public static List<Word> tokens;
    private ColorNode expected;


    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new ColorNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void white() {
        tokens.add(ColorWord.WHITE);
        expected = new ColorNode(ColorWord.WHITE);
    }

    @Test
    void blue() {
        tokens.add(ColorWord.BLUE);
        expected = new ColorNode(ColorWord.BLUE);
    }

    @Test
    void black() {
        tokens.add(ColorWord.BLACK);
        expected = new ColorNode(ColorWord.BLACK);
    }

    @Test
    void red() {
        tokens.add(ColorWord.RED);
        expected = new ColorNode(ColorWord.RED);
    }

    @Test
    void green() {
        tokens.add(ColorWord.GREEN);
        expected = new ColorNode(ColorWord.GREEN);
    }

    @Test
    void colorless() {
        tokens.addAll(List.of(GameNoun.COLOR, Comparative.LESS));
        expected = new ColorNode(GameNoun.COLOR, Comparative.LESS);
    }

    @Test
    void nonwhite() {
        tokens.addAll(List.of(Adverb.NOT, ColorWord.WHITE));
        expected = new ColorNode(Adverb.NOT, ColorWord.WHITE);
    }

    @Test
    void nonblue() {
        tokens.addAll(List.of(Adverb.NOT, ColorWord.BLUE));
        expected = new ColorNode(Adverb.NOT, ColorWord.BLUE);
    }

    @Test
    void nonblack() {
        tokens.addAll(List.of(Adverb.NOT, ColorWord.BLACK));
        expected = new ColorNode(Adverb.NOT, ColorWord.BLACK);
    }

    @Test
    void nonred() {
        tokens.addAll(List.of(Adverb.NOT, ColorWord.RED));
        expected = new ColorNode(Adverb.NOT, ColorWord.RED);
    }

    @Test
    void nongreen() {
        tokens.addAll(List.of(Adverb.NOT, ColorWord.GREEN));
        expected = new ColorNode(Adverb.NOT, ColorWord.GREEN);
    }
}
