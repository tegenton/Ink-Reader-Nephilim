package tegenton.card.parser.node.target.object;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.source.target.object.ObjectAttribute;
import tegenton.card.parser.node.ParseNode;

import java.util.List;

public class CharacteristicNode extends ParseNode {
    public CharacteristicNode(Word attribute) {
        super(attribute);
    }

    public CharacteristicNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof ObjectAttribute attribute) {
            switch (attribute) {
                case POWER, TOUGHNESS, LOYALTY -> setValue(pop());
            }
        } else {
            expect(GameNoun.MANA);
            expect(Symbol.SPACE);
            setValue(expect(ObjectAttribute.VALUE));
        }
    }
}
