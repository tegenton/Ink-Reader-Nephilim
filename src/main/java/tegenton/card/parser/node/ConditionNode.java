package tegenton.card.parser.node;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.SourceVerb;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;
import tegenton.card.parser.node.ability.KeywordNode;
import tegenton.card.parser.node.ability.target.object.ObjectNode;

import java.util.List;

public class ConditionNode extends ParseNode {
    public ConditionNode(Word have, ParseNode... children) {
        super(children);
        setValue(have);
    }

    public ConditionNode(List<Word> tokens) {
        super(tokens);
        addChild(new ObjectNode(getTokens()));
        expect(Symbol.SPACE);
        expect(SourceVerb.DO);
        setValue(expect(Adverb.NOT));
        expect(Symbol.SPACE);
        expect(ObjectVerb.HAVE);
        expect(Symbol.SPACE);
        addChild(new KeywordNode(getTokens()));
    }

}
