package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.type.LandType;
import tegenton.card.parser.item.InputItem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class KeywordNodeTest extends NodeTest {
    @Test
    void simple() {
        List<Keyword> keywordList =
                List.of(Keyword.BANDING, Keyword.DEFENDER, Keyword.FEAR,
                        Keyword.FLYING, Keyword.HASTE, Keyword.INDESTRUCTIBLE,
                        Keyword.REACH, Keyword.TRAMPLE, Keyword.VIGILANCE);
        for (Keyword keyword : keywordList) {
            ArrayDeque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(keyword),
                            new InputItem((Word) null)));
            testNode(new KeywordNode(new InputItem(keyword)), input);
        }
    }

    @Test
    void firstStrike() {
        Deque<InputItem> input = new ArrayDeque<>(
                List.of(new InputItem(Adjective.FIRST),
                        new InputItem(Symbol.SPACE),
                        new InputItem(Keyword.STRIKE),
                        new InputItem((Word) null)));
        testNode(new KeywordNode(new InputItem(Adjective.FIRST),
                new InputItem(Keyword.STRIKE)), input);
    }

    @Test
    void protection() {
        for (ColorWord color : ColorWord.values()) {
            Deque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(Keyword.PROTECTION),
                            new InputItem(Symbol.SPACE),
                            new InputItem(Preposition.FROM),
                            new InputItem(Symbol.SPACE), new InputItem(color)));
            testNode(new KeywordNode(new InputItem(Keyword.PROTECTION),
                    new InputItem(Preposition.FROM),
                    new InputItem(new ColorNode(color))), input);
        }
    }

    @Test
    void walk() {
        for (LandType type : LandType.values()) {
            Deque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(type), new InputItem(Keyword.WALK)));
            testNode(new KeywordNode(new InputItem(new TypeNode(type)),
                    new InputItem(Keyword.WALK)), input);
        }
    }
}
