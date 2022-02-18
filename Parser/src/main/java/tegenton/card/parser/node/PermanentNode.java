package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

public class PermanentNode extends Node {
    protected PermanentNode(List<Word> input) {
        super(input);
        addChild(new KeywordNode(getTokens()));
        expect(Symbol.NEWLINE);
        addChild(new StaticAbilityNode(getTokens()));
    }
}
