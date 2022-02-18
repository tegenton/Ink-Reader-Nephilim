package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.TypeWord;
import tegenton.card.parser.Node;

import java.util.List;

public class TypeNode extends Node {
    public TypeNode(TypeWord type) {
        super(type);
    }

    public TypeNode(List<Word> tokens) {
        super(tokens);
        consume(TypeWord.class);
    }
}
