package tegenton.card.parser;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;

import java.util.List;

public class ColorNode extends Node {
    public ColorNode(final List<Word> input) {
        super(input);
        if (tokens.get(0) == GameNoun.COLOR) {
            consume(GameNoun.COLOR);
            consume(Comparative.LESS);
        } else {
            if (tokens.get(0) == Adverb.NOT) {
                consume(Adverb.NOT);
            }
            consume(ColorWord.class);
        }
    }

    ColorNode(final Word... colors) {
        super(colors);
    }

    private void consume(final Class<ColorWord> colorWordClass) {
        if (tokens.get(0).getClass() == colorWordClass) {
            consume(tokens.get(0));
        }
    }
}
