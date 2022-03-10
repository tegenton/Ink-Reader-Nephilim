package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.Node;

public class InputItem {
    private Node node;
    private Word word;

    public InputItem(Word word) {
        this.word = word;
    }

    public InputItem(Node node) {
        this.node = node;
    }

    public Word getWord() {
        return word;
    }

    public boolean hasWord() {
        return word != null;
    }

    public Node getNode() {
        return node;
    }

    public boolean hasNode() {
        return node != null;
    }
}
