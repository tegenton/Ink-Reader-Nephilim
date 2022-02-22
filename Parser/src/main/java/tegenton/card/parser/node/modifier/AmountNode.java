package tegenton.card.parser.node.modifier;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.Node;

import java.util.List;

public class AmountNode extends Node {
    public AmountNode(Word... amount) {
        super(amount);
    }

    public AmountNode(List<Word> tokens) {
        super(tokens);
        if (nextToken() instanceof EnglishNumber) {
            consume(EnglishNumber.THREE);
        } else {
            consume(Determiner.A);
            expect(Symbol.SPACE);
            consume(Noun.NUMBER);
            expect(Symbol.SPACE);
            consume(Preposition.OF);
        }
    }
}
