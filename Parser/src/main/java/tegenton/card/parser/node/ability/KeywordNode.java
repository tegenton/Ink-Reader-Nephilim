package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.type.TypeWord;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.atom.ColorNode;
import tegenton.card.parser.node.phrase.headword.ObjectNode;

import java.util.List;

public class KeywordNode extends Node {
    KeywordNode(Word... keyword) {
        super(keyword);
    }

    KeywordNode(Keyword protection, Preposition from, ColorNode quality) {
        super(protection, from);
        addChild(quality);
    }

    KeywordNode(Keyword enchant, ObjectNode object) {
        super(enchant);
        addChild(object);
    }

    KeywordNode(ObjectNode objectNode, Keyword walk) {
        super(objectNode);
        addChild(walk);
    }

    public KeywordNode(List<Word> input) {
        super(input);
        if (nextToken() == Adjective.FIRST) {
            consume(Adjective.FIRST);
            expect(Symbol.SPACE);
            consume(Keyword.STRIKE);
        } else if (nextToken() == Keyword.ENCHANT) {
            consume(Keyword.ENCHANT);
            expect(Symbol.SPACE);
            addChild(new ObjectNode(getTokens()));
        } else if (nextToken() == Keyword.PROTECTION) {
            consume(Keyword.PROTECTION);
            expect(Symbol.SPACE);
            consume(Preposition.FROM);
            expect(Symbol.SPACE);
            addChild(new ColorNode(getTokens()));
        } else if (nextToken() instanceof TypeWord) {
            addChild(new ObjectNode(getTokens()));
            consume(Keyword.WALK);
        } else {
            consume(Keyword.class);
        }
    }
}
