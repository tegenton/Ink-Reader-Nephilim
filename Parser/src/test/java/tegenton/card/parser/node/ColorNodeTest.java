package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.parser.InputItem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ColorNodeTest extends NodeTest {
    @Test
    void colors() {
        List<ColorWord> colorWords =
                List.of(ColorWord.WHITE, ColorWord.BLUE, ColorWord.BLACK,
                        ColorWord.RED, ColorWord.GREEN);
        for (ColorWord color : colorWords) {
            Deque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(color), new InputItem((Word) null)));
            testNode(new ColorNode(color), new ColorNode().productions(),
                    input);
        }
    }

    @Test
    void noncolor() {

        List<ColorWord> colorWords =
                List.of(ColorWord.WHITE, ColorWord.BLUE, ColorWord.BLACK,
                        ColorWord.RED, ColorWord.GREEN);
        for (ColorWord color : colorWords) {
            Deque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(Adverb.NOT), new InputItem(color),
                            new InputItem((Word) null)));
            testNode(new ColorNode(Adverb.NOT, color),
                    new ColorNode().productions(), input);
        }
    }

    @Test
    void colorless() {
        Deque<InputItem> input = new ArrayDeque<>(
                List.of(new InputItem(GameNoun.COLOR),
                        new InputItem(Comparative.LESS),
                        new InputItem((Word) null)));
        testNode(new ColorNode(GameNoun.COLOR, Comparative.LESS),
                new ColorNode().productions(), input);
    }
}
