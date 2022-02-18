package tegenton.card.parser.node.phrase;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.phrase.headword.PlayerNode;

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
