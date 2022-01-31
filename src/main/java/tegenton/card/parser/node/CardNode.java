package tegenton.card.parser.node;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.node.ability.OneShotAbilityNode;
import tegenton.card.parser.node.ability.StaticAbilityNode;
import tegenton.card.parser.node.ability.SubjectNode;
import tegenton.card.parser.node.ability.target.player.PlayerVerbPhraseNode;

import java.util.List;

public class CardNode extends ParseNode {
    public CardNode(List<Word> tokens) {
        super(tokens);
        if (getTokens().isEmpty()) {
            return;
        }
        if (peek() == Determiner.TARGET) {
            addChild(new SubjectNode(getTokens()));
            expect(Symbol.SPACE);
            addChild(new PlayerVerbPhraseNode(getTokens()));
            expect(Symbol.PERIOD);
        } else if (peek() instanceof Keyword) {
            addChild(new KeywordsNode(getTokens()));
            if (!getTokens().isEmpty() && peek() == Symbol.NEWLINE) {
                pop();
                addChild(new StaticAbilityNode(getTokens()));
                expect(Symbol.PERIOD);
            }
        } else {
            addChild(new OneShotAbilityNode(getTokens()));
            expect(Symbol.PERIOD);
        }
    }

    public CardNode(ParseNode... children) {
        super(children);
    }
}
