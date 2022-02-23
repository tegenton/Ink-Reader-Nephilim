package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.DigitNumber;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class StatModNode extends Node {
    public StatModNode(final Word... statMod) {
        super(statMod);
    }

    public StatModNode(final List<Word> input) throws ParseError {
        super(input);
        consume(Symbol.PLUS, Symbol.HYPHEN);
        consume(DigitNumber.class);
        expect(Symbol.SLASH);
        consume(Symbol.PLUS, Symbol.HYPHEN);
        consume(DigitNumber.class);
    }
}
