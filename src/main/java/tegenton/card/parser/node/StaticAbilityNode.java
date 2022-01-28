package tegenton.card.parser.node;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.source.SourceVerb;
import tegenton.card.lexicon.game.source.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;
import tegenton.card.parser.node.ability.target.object.ObjectNode;

import java.util.List;

public class StaticAbilityNode extends ParseNode {
    public StaticAbilityNode(ParseNode... children) {
        super(children);
    }

    public StaticAbilityNode(List<Word> tokens) {
        super(tokens);
        addChild(new ObjectNode(getTokens()));
        expect(Symbol.SPACE);
        expect(TargetAuxiliaryVerb.CAN);
        expect(Symbol.SPACE);
        expect(ObjectVerb.ATTACK);
        expect(Symbol.SPACE);
        expect(SubordinateConjunction.AS);
        expect(Symbol.SPACE);
        expect(SubordinateConjunction.THOUGH);
        expect(Symbol.SPACE);
        expect(ObjectNoun.IT);
        expect(Symbol.SPACE);
        expect(SourceVerb.DO);
        expect(Adverb.NOT);
        expect(Symbol.SPACE);
        expect(ObjectVerb.HAVE);
        expect(Symbol.SPACE);
        expect(Keyword.DEFENDER);
    }
}
