package tegenton.card.parser.node;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.node.ability.KeywordNode;
import tegenton.card.parser.node.ability.target.TargetedAbilityNode;

import java.util.List;

public class CardNode extends ParseNode {
    public CardNode(List<Word> tokens) {
        super(tokens);
        if (peek() == Determiner.TARGET) {
            addChild(new TargetedAbilityNode(getTokens()));
            expect(Symbol.PERIOD);
        } else if (peek() instanceof Keyword) {
            addChild(new KeywordNode(getTokens()));
            expect(Symbol.NEWLINE);
            addChild(new StaticAbilityNode(getTokens()));
            expect(Symbol.PERIOD);
        }
    }

    public CardNode(ParseNode... children) {
        super(children);
    }
}
