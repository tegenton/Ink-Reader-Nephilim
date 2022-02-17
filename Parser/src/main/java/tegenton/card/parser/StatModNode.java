package tegenton.card.parser;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.DigitNumber;

import java.util.List;

public class StatModNode extends Node {
    public StatModNode(final Word... statMod) {
        super(statMod);
    }

    public StatModNode(final List<Word> input) {
        super(input);
        consume(Symbol.PLUS, Symbol.HYPHEN);
        consume(DigitNumber.class);
        pop(Symbol.SLASH);
        consume(Symbol.PLUS, Symbol.HYPHEN);
        consume(DigitNumber.class);
    }
}
