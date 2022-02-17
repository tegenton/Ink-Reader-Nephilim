package tegenton.card.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorNodeTest {
    public static List<Word> tokens;
    private ColorNode expected;

    @AfterEach
    void compare() {
        assertEquals(expected, new ColorNode(tokens));
    }

    @Test
    void white() {
        tokens = List.of(ColorWord.WHITE);
        expected = new ColorNode(ColorWord.WHITE);
    }

    @Test
    void blue() {
        tokens = List.of(ColorWord.BLUE);
        expected = new ColorNode(ColorWord.BLUE);
    }

    @Test
    void black() {
        tokens = List.of(ColorWord.BLACK);
        expected = new ColorNode(ColorWord.BLACK);
    }

    @Test
    void red() {
        tokens = List.of(ColorWord.RED);
        expected = new ColorNode(ColorWord.RED);
    }

    @Test
    void green() {
        tokens = List.of(ColorWord.GREEN);
        expected = new ColorNode(ColorWord.GREEN);
    }

    @Test
    void colorless() {
        tokens = List.of(GameNoun.COLOR, Comparative.LESS);
        expected = new ColorNode(GameNoun.COLOR, Comparative.LESS);
    }

    @Test
    void nonwhite() {
        tokens = List.of(Adverb.NOT, ColorWord.WHITE);
        expected = new ColorNode(Adverb.NOT, ColorWord.WHITE);
    }

    @Test
    void nonblue() {
        tokens = List.of(Adverb.NOT, ColorWord.BLUE);
        expected = new ColorNode(Adverb.NOT, ColorWord.BLUE);
    }

    @Test
    void nonblack() {
        tokens = List.of(Adverb.NOT, ColorWord.BLACK);
        expected = new ColorNode(Adverb.NOT, ColorWord.BLACK);
    }

    @Test
    void nonred() {
        tokens = List.of(Adverb.NOT, ColorWord.RED);
        expected = new ColorNode(Adverb.NOT, ColorWord.RED);
    }

    @Test
    void nongreen() {
        tokens = List.of(Adverb.NOT, ColorWord.GREEN);
        expected = new ColorNode(Adverb.NOT, ColorWord.GREEN);
    }
}
