package tegenton.card.parser.node.type;

import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.type.Type;
import tegenton.card.parser.node.ParseNode;

import java.util.List;

public class TypeNode extends ParseNode {
    public TypeNode(Type type) {
        super(type);
    }

    public TypeNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof Type) {
            setValue(pop());
        } else {
            setValue(expect(Adjective.CHOSEN));
            expect(Symbol.SPACE);
            expect(GameNoun.TYPE);
        }
    }
}
