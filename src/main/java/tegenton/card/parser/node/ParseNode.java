package tegenton.card.parser.node;

import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public abstract class ParseNode {
    private final List<ParseNode> children = new ArrayList<>();
    private final Stack<Word> tokens = new Stack<>();
    private Word value;

    public ParseNode(Word value) {
        this.value = value;
    }

    public ParseNode(List<Word> tokens) {
        this.tokens.addAll(tokens);
    }

    public ParseNode(ParseNode[] children) {
        this.children.addAll(List.of(children));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParseNode parseNode = (ParseNode) o;
        return Objects.equals(value, parseNode.value) && Objects.deepEquals(children, parseNode.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    protected void setValue(Word remove) {
        this.value = remove;
    }

    protected void addChild(ParseNode child) {
        this.children.add(child);
    }

    protected Word peek() {
        return tokens.peek();
    }

    protected Word peek(int i) {
        if (tokens.size() >= i) {
            return tokens.get(i);
        } else {
            throw new IllegalStateException("Missing token");
        }
    }

    protected Word pop() {
        return tokens.pop();
    }

    protected Word expect(Word word) {
        if (peek() == word) {
            return pop();
        } else {
            throw new IllegalStateException("Token '" + tokens.get(0) + "' does not match expected '" + word + "'");
        }
    }

    protected Stack<Word> getTokens() {
        return tokens;
    }
}
