package tegenton.card.parser.node;

import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

public class SubordinateClauseNode extends ParseNode {
    public SubordinateClauseNode(Word conjunction, ParseNode... children) {
        super(children);
        setValue(conjunction);
    }

    public SubordinateClauseNode(List<Word> tokens) {
        super(tokens);
        expect(SubordinateConjunction.AS);
        expect(Symbol.SPACE);
        setValue(expect(SubordinateConjunction.THOUGH));
        expect(Symbol.SPACE);
        addChild(new ConditionNode(getTokens()));
    }
}
