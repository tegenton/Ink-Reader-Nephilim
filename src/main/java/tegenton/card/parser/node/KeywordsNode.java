package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.node.ability.KeywordNode;

import java.util.List;

public class KeywordsNode extends ParseNode {
    public KeywordsNode(KeywordNode... children) {
        super(children);
    }

    public KeywordsNode(List<Word> tokens) {
        super(tokens);
        while (!getTokens().isEmpty() && peek() instanceof Keyword) {
            addChild(new KeywordNode(getTokens()));
            if (!getTokens().isEmpty() && peek() == Symbol.SEMICOLON) {
                expect(Symbol.SEMICOLON);
                expect(Symbol.SPACE);
            }
        }
    }
}
