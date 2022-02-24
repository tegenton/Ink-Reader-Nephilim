package tegenton.card.parser.node.phrase;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class PhraseNode extends Node {
    public PhraseNode(Node children) {
        super(children);
    }

    public PhraseNode(List<Word> input) throws ParseError {
        super(input);
        if (getTokens().get(2) == CardType.CREATURE
                || nextToken() == ObjectNoun.IT) {
            addChild(new ObjectPhraseNode(getTokens()));
        } else {
            addChild(new PlayerPhraseNode(getTokens()));
        }
    }
}
