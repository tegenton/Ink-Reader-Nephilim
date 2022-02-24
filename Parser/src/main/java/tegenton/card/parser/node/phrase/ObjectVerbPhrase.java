package tegenton.card.parser.node.phrase;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.target.TargetAdjective;
import tegenton.card.lexicon.game.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.phrase.headword.ObjectNode;

import java.util.List;

public class ObjectVerbPhrase extends Node {
    public ObjectVerbPhrase(List<Word> input) throws ParseError {
        super(input);
        if (nextToken() == TargetAuxiliaryVerb.CAN) {
            consume(TargetAuxiliaryVerb.CAN);
            expect(Symbol.SPACE);
            consume(ObjectVerb.BLOCK);
            expect(Symbol.SPACE);
            addChild(new ObjectNode(getTokens()));
            expect(Symbol.SPACE);
            consume(Determiner.THIS);
            expect(Symbol.SPACE);
            consume(GameNoun.TURN);
        } else {
            consume(ObjectVerb.BLOCK);
            expect(Symbol.SPACE);
            addChild(new ObjectNode(getTokens()));
            expect(Symbol.SPACE);
            consume(Determiner.THIS);
            expect(Symbol.SPACE);
            consume(GameNoun.TURN);
            expect(Symbol.SPACE);
            consume(SubordinateConjunction.IF);
            expect(Symbol.SPACE);
            consume(TargetAdjective.ABLE);
        }
    }
}
