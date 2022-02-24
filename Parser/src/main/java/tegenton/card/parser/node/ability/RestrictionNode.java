package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Chronology;
import tegenton.card.lexicon.game.turn.Phase;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class RestrictionNode extends Node {
    public RestrictionNode(List<Word> input) throws ParseError {
        super(input);
        consume(PlayerVerb.CAST);
        expect(Symbol.SPACE);
        consume(Determiner.THIS);
        expect(Symbol.SPACE);
        consume(ObjectNoun.SPELL);
        expect(Symbol.SPACE);
        consume(Adverb.ONLY);
        expect(Symbol.SPACE);
        consume(Chronology.DURING);
        expect(Symbol.SPACE);
        consume(Phase.COMBAT);
        expect(Symbol.SPACE);
        consume(Chronology.BEFORE);
        expect(Symbol.SPACE);
        consume(ObjectVerb.BLOCK);
        consume(Morpheme.ER);
        consume(Morpheme.S);
        expect(Symbol.SPACE);
        consume(ObjectVerb.IS);
        expect(Symbol.SPACE);
        consume(PlayerVerb.DECLARE);
        consume(Morpheme.ED);
        consume(Symbol.PERIOD);
        consume(Symbol.NEWLINE);
    }
}
