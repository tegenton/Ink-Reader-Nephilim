package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.SuperType;
import tegenton.card.parser.item.InputItem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TypeNodeTest extends NodeTest {
    @Test
    void supertype() {
        Deque<InputItem> input =
                new ArrayDeque<>(List.of(new InputItem(SuperType.BASIC)));
        testNode(new TypeNode(SuperType.BASIC), input);
    }

    @Test
    void cardtype() {
        for (CardType type : CardType.values()) {
            Deque<InputItem> input =
                    new ArrayDeque<>(List.of(new InputItem(type)));
            testNode(new TypeNode(type), input);
        }
    }
}
