package tegenton.card.parser.node.ability.target;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.ability.target.player.PlayerNode;
import tegenton.card.parser.node.ability.target.player.PlayerVerbPhraseNode;

import java.util.List;

public class TargetedAbilityNode extends ParseNode {
    public TargetedAbilityNode(ParseNode... children) {
        super(children);
    }

    public TargetedAbilityNode(List<Word> tokens) {
        super(tokens);
        expect(Determiner.TARGET);
        expect(Symbol.SPACE);
        if (peek() instanceof PlayerVerb) {
            addChild(new PlayerNode(getTokens()));
            expect(Symbol.SPACE);
            addChild(new PlayerVerbPhraseNode(getTokens()));
        }
    }
}
