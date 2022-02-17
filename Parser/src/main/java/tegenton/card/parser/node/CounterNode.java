package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.CounterType;
import tegenton.card.parser.node.atom.StatModNode;

import java.util.List;

public class CounterNode extends Node {
    public CounterNode(final CounterType counterType) {
        super(counterType);
    }

    public CounterNode(final StatModNode statModNode) {
        super(statModNode);
    }

    public CounterNode(final List<Word> input) {
        super(input);
        if (nextToken() instanceof CounterType counterType) {
            consume(counterType);
        } else {
            addChild(new StatModNode(getTokens()));
        }
        expect(Symbol.SPACE);
        expect(PlayerVerb.COUNTER);
    }
}
