package tegenton.card.parser.node.phrase.headword;

import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.atom.AtomicObjectNode;
import tegenton.card.parser.node.modifier.AmountNode;

import java.util.List;

public class PostModifierNode extends Node {
    public PostModifierNode(List<Word> tokens) {
        super(tokens);
        consume(TargetNoun.THEY);
        expect(Symbol.SPACE);
        consume(PlayerVerb.CONTROL);
        expect(Symbol.SPACE);
        consume(Adjective.EQUAL);
        expect(Symbol.SPACE);
        consume(Preposition.TO);
        expect(Symbol.SPACE);
        addChild(new AmountNode(getTokens()));
        expect(Symbol.SPACE);
        addChild(new AtomicObjectNode(getTokens()));
        expect(Symbol.SPACE);
        consume(PlayerVerb.CONTROL);
        consume(Morpheme.ED);
        expect(Symbol.SPACE);
        consume(Preposition.BY);
        expect(Symbol.SPACE);
        consume(Determiner.THE);
        expect(Symbol.SPACE);
        consume(PlayerVerb.PLAY);
        consume(Morpheme.ER);
        expect(Symbol.SPACE);
        consume(TargetNoun.WHO);
        expect(Symbol.SPACE);
        consume(PlayerVerb.CONTROL);
        expect(Symbol.SPACE);
        consume(Determiner.THE);
        expect(Symbol.SPACE);
        consume(Noun.FEWEST);
        expect(Symbol.COMMA);
        expect(Symbol.SPACE);
        consume(Conjunction.THEN);
        expect(Symbol.SPACE);
        consume(PlayerVerb.SACRIFICE);
        expect(Symbol.SPACE);
        consume(Determiner.THE);
        expect(Symbol.SPACE);
        consume(Noun.REST);
    }
}
