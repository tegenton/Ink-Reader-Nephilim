package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.ConjunctionNode;
import tegenton.card.parser.node.ParentNode;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.ability.target.player.PlayerVerbPhraseNode;

import java.util.List;

public class VerbPhraseNode extends ParentNode {
    public VerbPhraseNode(ParseNode... parseNodes) {
        super(parseNodes);
    }

    public VerbPhraseNode(List<Word> tokens) {
        super(tokens);
        addChild(new PlayerVerbPhraseNode(getTokens()));
        expect(Symbol.COMMA);
        expect(Symbol.SPACE);
        setConjunction(new ConjunctionNode(getTokens()));
        expect(Symbol.SPACE);
        addChild(new PlayerVerbPhraseNode(getTokens()));
    }
}
