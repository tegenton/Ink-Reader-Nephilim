package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.player.PlayerNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class AtomicPlayerNode extends Node {
    public AtomicPlayerNode(final Word... player) {
        super(player);
    }

    public AtomicPlayerNode(final List<Word> tokens) throws ParseError {
        super(tokens);
        if (nextToken() instanceof PlayerNoun playerNoun) {
            consume(playerNoun);
        } else if (nextToken() instanceof PlayerVerb) {
            consume(PlayerVerb.CONTROL, PlayerVerb.OWN, PlayerVerb.PLAY);
            consume(Morpheme.ER);
            if (nextToken() == Morpheme.S) {
                consume(Morpheme.S);
            }
        } else {
            consume(TargetNoun.THEY);
        }
    }
}
