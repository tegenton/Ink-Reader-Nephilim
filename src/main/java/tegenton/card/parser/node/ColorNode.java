package tegenton.card.parser.node;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;

import java.util.List;

public class ColorNode extends ParseNode {
    public ColorNode(Word value) {
        super(value);
    }

    public ColorNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof ColorWord) {
            setValue(pop());
        } else if (peek() == GameNoun.COLOR) {
            pop();
            setValue(expect(Comparative.LESS));
        } else {
            setValue(expect(Adverb.NOT));
            addChild(new ColorNode(getTokens()));
        }
    }

    public ColorNode(Adverb not, ColorNode colorNode) {
        super(not);
        addChild(colorNode);
    }
}
