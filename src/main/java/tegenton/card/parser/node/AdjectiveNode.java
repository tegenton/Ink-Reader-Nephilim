package tegenton.card.parser.node;

import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.List;

public class AdjectiveNode extends ParseNode {
    public AdjectiveNode(Word adjective) {
        super(adjective);
    }

    public AdjectiveNode(List<Word> tokens) {
        super(tokens);
        if (peek() == ObjectVerb.BLOCK || peek() == Keyword.ENCHANT || peek() == PlayerVerb.SACRIFICE || peek() == ObjectVerb.TAP) {
            setValue(pop());
            expect(Morpheme.ED);
        }
    }
}
