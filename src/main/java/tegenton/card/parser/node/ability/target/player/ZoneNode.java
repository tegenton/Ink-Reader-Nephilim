package tegenton.card.parser.node.ability.target.player;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.source.target.TargetModifier;
import tegenton.card.lexicon.game.source.target.TargetNoun;
import tegenton.card.parser.node.ParseNode;

import java.util.List;

public class ZoneNode extends ParseNode {
    public ZoneNode(List<Word> tokens) {
        super(tokens);
        expect(TargetNoun.THEY);
        expect(TargetModifier.POSSESSIVE);
        expect(Symbol.SPACE);
        setValue(expect(Zone.HAND));
    }

    public ZoneNode(Zone hand) {
        super(hand);
    }
}
