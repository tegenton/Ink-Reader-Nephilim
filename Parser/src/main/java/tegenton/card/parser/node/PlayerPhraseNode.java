package tegenton.card.parser.node;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

public class PlayerPhraseNode extends Node {
    public PlayerPhraseNode(final Node... nodes) {
        super(nodes);
    }

    public PlayerPhraseNode(final List<Word> input) {
        super(input);
        if (nextToken() == Determiner.TARGET) {
            addChild(new PlayerNode(getTokens()));
            expect(Symbol.SPACE);
        }
        addChild(new PlayerVerbPhraseNode(getTokens()));
    }
}
