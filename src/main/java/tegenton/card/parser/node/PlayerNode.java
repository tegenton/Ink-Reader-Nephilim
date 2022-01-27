package tegenton.card.parser.node;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.List;

public class PlayerNode extends ParseNode {
    public PlayerNode(PlayerVerb play, DeterminerNode... determinerNode) {
        super(determinerNode);
        setValue(play);
    }

    public PlayerNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof Determiner) {
            addChild(new DeterminerNode(getTokens()));
            expect(Symbol.SPACE);
        }
        if (peek() instanceof PlayerVerb) {
            setValue(pop());
            expect(Morpheme.ER);
        }
    }
}
