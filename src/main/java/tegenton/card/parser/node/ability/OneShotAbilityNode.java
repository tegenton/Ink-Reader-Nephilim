package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.ability.target.player.PlayerVerbPhraseNode;

import java.util.List;

public class OneShotAbilityNode extends ParseNode {
    public OneShotAbilityNode(ParseNode... children) {
        super(children);
    }

    public OneShotAbilityNode(List<Word> input) {
        super(input);
        if (peek() instanceof Determiner) {
            addChild(new SubjectNode(getTokens()));
            expect(Symbol.SPACE);
            addChild(new VerbPhraseNode(getTokens()));
        } else {
            addChild(new PlayerVerbPhraseNode(getTokens()));
        }
    }
}
