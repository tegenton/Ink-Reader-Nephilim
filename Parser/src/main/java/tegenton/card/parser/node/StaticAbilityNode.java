package tegenton.card.parser.node;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.object.source.SourceVerb;
import tegenton.card.parser.PunctuationNode;
import tegenton.card.parser.node.atom.SubordinateConjunctionNode;

import java.util.List;

public class StaticAbilityNode extends Node {
    public StaticAbilityNode(List<Word> tokens) {
        super(tokens);
        addChild(new ObjectNode(getTokens()));
        expect(Symbol.SPACE);
        consume(TargetAuxiliaryVerb.CAN);
        expect(Symbol.SPACE);
        consume(ObjectVerb.ATTACK);
        expect(Symbol.SPACE);
        addChild(new SubordinateConjunctionNode(getTokens()));
        expect(Symbol.SPACE);
        consume(ObjectNoun.IT);
        expect(Symbol.SPACE);
        consume(SourceVerb.DO);
        consume(Morpheme.ED);
        consume(Adverb.NOT);
        expect(Symbol.SPACE);
        consume(ObjectVerb.HAVE);
        expect(Symbol.SPACE);
        consume(Keyword.DEFENDER);
        addChild(new PunctuationNode(getTokens()));
    }
}
