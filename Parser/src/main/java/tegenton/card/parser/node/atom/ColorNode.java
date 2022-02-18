package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.parser.Node;

import java.util.List;

public class ColorNode extends Node {
    public ColorNode(final List<Word> input) {
        super(input);
        if (nextToken(GameNoun.COLOR)) {
            consume(GameNoun.COLOR);
            consume(Comparative.LESS);
        } else {
            if (nextToken(Adverb.NOT)) {
                consume(Adverb.NOT);
            }
            consume(ColorWord.class);
        }
    }

    ColorNode(final Word... colors) {
        super(colors);
    }
}
