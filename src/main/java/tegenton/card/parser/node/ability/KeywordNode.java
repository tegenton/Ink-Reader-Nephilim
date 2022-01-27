package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.type.Type;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.object.ColorNode;
import tegenton.card.parser.node.type.TypeNode;

import java.util.List;

public class KeywordNode extends ParseNode {
    public KeywordNode(Word value) {
        super(value);
    }

    public KeywordNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof Keyword keyword) {
            setValue(pop());
            if (keyword == Keyword.PROTECTION) {
                expect(Symbol.SPACE);
                expect(Preposition.FROM);
                expect(Symbol.SPACE);
                addChild(new ColorNode(getTokens()));
            } else if (keyword == Keyword.ENCHANT) {
                expect(Symbol.SPACE);
                addChild(new TypeNode(getTokens()));
            }
        } else if (peek() == Adjective.FIRST) {
            setValue(pop());
            expect(Symbol.SPACE);
            expect(Keyword.STRIKE);
        } else if (peek() instanceof Type) {
            addChild(new TypeNode(getTokens()));
            setValue(expect(Keyword.WALK));
        }
    }

    public KeywordNode(Keyword protection, ParseNode... colorNode) {
        super(colorNode);
        setValue(protection);
    }
}
