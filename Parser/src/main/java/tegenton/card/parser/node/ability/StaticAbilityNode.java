package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.object.source.SourceVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.atom.SubordinateConjunctionNode;
import tegenton.card.parser.node.atom.symbol.PunctuationNode;
import tegenton.card.parser.node.phrase.headword.ObjectNode;

import java.util.List;

public class StaticAbilityNode extends Node {
    public StaticAbilityNode(List<Word> tokens) {
        super(tokens);
        if (nextToken() == Determiner.THIS) {
            consume(Determiner.THIS);
            expect(Symbol.SPACE);
            consume(GameNoun.EFFECT);
        } else {
            addChild(new ObjectNode(getTokens()));
        }
        expect(Symbol.SPACE);
        if (nextToken() == SourceVerb.DO) {
            consume(SourceVerb.DO);
            consume(Adverb.NOT);
            expect(Symbol.SPACE);
            consume(PlayerVerb.REMOVE);
            expect(Symbol.SPACE);
            consume(Symbol.TILDE);
        } else if (nextToken() == ObjectVerb.HAVE) {
            expect(ObjectVerb.HAVE);
            expect(Symbol.SPACE);
            addChild(new KeywordNode(getTokens()));
        } else {
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
        }
        addChild(new PunctuationNode(getTokens()));
    }
}
