package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.CreatureType;
import tegenton.card.lexicon.game.type.EnchantmentType;
import tegenton.card.lexicon.game.type.LandType;
import tegenton.card.lexicon.game.type.SuperType;
import tegenton.card.parser.item.InputItem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TypeNodeTest extends NodeTest {
    @Test
    void superType() {
        Deque<InputItem> input =
                new ArrayDeque<>(List.of(new InputItem(SuperType.BASIC)));
        testNode(new TypeNode(SuperType.BASIC), input);
    }

    @Test
    void cardType() {
        for (CardType type : CardType.values()) {
            Deque<InputItem> input =
                    new ArrayDeque<>(List.of(new InputItem(type)));
            testNode(new TypeNode(type), input);
        }
    }

    @Test
    void creatureType() {
        for (CreatureType type : CreatureType.values()) {
            Deque<InputItem> input =
                    new ArrayDeque<>(List.of(new InputItem(type)));
            testNode(new TypeNode(type), input);
        }
    }

    @Test
    void enchantmentType() {
        for (EnchantmentType type : EnchantmentType.values()) {
            Deque<InputItem> input =
                    new ArrayDeque<>(List.of(new InputItem(type)));
            testNode(new TypeNode(type), input);
        }
    }

    @Test
    void landType() {
        for (LandType type : LandType.values()) {
            Deque<InputItem> input =
                    new ArrayDeque<>(List.of(new InputItem(type)));
            testNode(new TypeNode(type), input);
        }
    }

    @Test
    void chosenType() {
        Deque<InputItem> input = new ArrayDeque<>(
                List.of(new InputItem(Adjective.CHOSEN),
                        new InputItem(Symbol.SPACE),
                        new InputItem(GameNoun.TYPE)));
        testNode(new TypeNode(Adjective.CHOSEN, GameNoun.TYPE), input);
    }
}
