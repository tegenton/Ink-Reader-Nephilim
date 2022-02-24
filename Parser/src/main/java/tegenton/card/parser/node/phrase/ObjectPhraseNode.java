package tegenton.card.parser.node.phrase;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.phrase.headword.ObjectNode;

import java.util.List;

public class ObjectPhraseNode extends Node {
    public ObjectPhraseNode(List<Word> input) throws ParseError {
        super(input);
        addChild(new ObjectNode(getTokens()));
        expect(Symbol.SPACE);
    }
}
