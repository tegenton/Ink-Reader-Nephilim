package tegenton.card.parser.node;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorTest {
    public static List<Word> tokens;
    public static ColorNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        ColorNode actual = new ColorNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void white() {
        Collections.addAll(tokens, ColorWord.WHITE);
        expected = new ColorNode(ColorWord.WHITE);
    }

    @Test
    void blue() {
        Collections.addAll(tokens, ColorWord.BLUE);
        expected = new ColorNode(ColorWord.BLUE);
    }

    @Test
    void black() {
        Collections.addAll(tokens, ColorWord.BLACK);
        expected = new ColorNode(ColorWord.BLACK);
    }

    @Test
    void red() {
        Collections.addAll(tokens, ColorWord.RED);
        expected = new ColorNode(ColorWord.RED);
    }

    @Test
    void green() {
        Collections.addAll(tokens, ColorWord.GREEN);
        expected = new ColorNode(ColorWord.GREEN);
    }

    @Test
    void colorless() {
        Collections.addAll(tokens, GameNoun.COLOR, Comparative.LESS);
        expected = new ColorNode(Comparative.LESS);
    }

    @Test
    void notWhite() {
        Collections.addAll(tokens, Adverb.NOT, ColorWord.WHITE);
        expected = new ColorNode(Adverb.NOT, new ColorNode(ColorWord.WHITE));
    }

    @Test
    void notBlue() {
        Collections.addAll(tokens, Adverb.NOT, ColorWord.BLUE);
        expected = new ColorNode(Adverb.NOT, new ColorNode(ColorWord.BLUE));
    }

    @Test
    void notBlack() {
        Collections.addAll(tokens, Adverb.NOT, ColorWord.BLACK);
        expected = new ColorNode(Adverb.NOT, new ColorNode(ColorWord.BLACK));
    }

    @Test
    void notRed() {
        Collections.addAll(tokens, Adverb.NOT, ColorWord.RED);
        expected = new ColorNode(Adverb.NOT, new ColorNode(ColorWord.RED));
    }

    @Test
    void notGreen() {
        Collections.addAll(tokens, Adverb.NOT, ColorWord.GREEN);
        expected = new ColorNode(Adverb.NOT, new ColorNode(ColorWord.GREEN));
    }
}
