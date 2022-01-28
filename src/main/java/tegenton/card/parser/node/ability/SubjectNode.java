package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.ability.target.player.PlayerNode;

import java.util.List;

public class SubjectNode extends ParseNode {
    public SubjectNode(Determiner determiner, ParseNode... children) {
        super(children);
        setValue(determiner);
    }

    public SubjectNode(List<Word> tokens) {
        super(tokens);
        setValue(pop());
        expect(Symbol.SPACE);
        addChild(new PlayerNode(getTokens()));
    }
}
