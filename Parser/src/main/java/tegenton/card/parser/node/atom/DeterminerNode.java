package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.Node;

import java.util.List;

public class DeterminerNode extends Node {
    public DeterminerNode(final Word determiner) {
        super(determiner);
    }

    public DeterminerNode(final List<Word> tokens) {
        super(tokens);
        if (nextToken() == EnglishNumber.THREE) {
            consume(EnglishNumber.THREE);
        } else if (nextToken() == Keyword.ENCHANT) {
            consume(Keyword.ENCHANT);
            consume(Morpheme.ED);
        } else {
            consume(Determiner.class);
        }
    }
}
