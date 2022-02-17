package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.leaf.Leaf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Node {
    private final List<Leaf> value;
    private List<Word> tokens;

    protected Node(final List<Word> input) {
        tokens = input;
        value = new ArrayList<>();
    }

    protected Node(final Word... words) {
        value = Arrays.stream(words).map(Leaf::of).toList();
    }

    public Node(final StatModNode statModNode) {
        value = new ArrayList<>();
        value.add(Leaf.of(statModNode));
    }

    protected void expect(final Word expected) {
        if (tokens.size() > 0) {
            if (tokens.get(0) == expected) {
                tokens.remove(0);
                return;
            }
        }
        throw new IllegalStateException(
                "Expected token '" + expected + "' does not match found token '"
                        + tokens.get(0) + "'");
    }

    protected void consume(final Word expected) {
        if (tokens.size() > 0 && tokens.get(0) == expected) {
            value.add(Leaf.of(expected));
            tokens.remove(0);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Node that = (Node) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "value=" + value + '}';
    }

    protected Word nextToken() {
        return tokens.get(0);
    }

    protected boolean nextToken(final Word word) {
        return tokens.size() > 0 && tokens.get(0) == word;
    }

    protected void consume(final Class<? extends Word> wordClass) {
        if (nextToken().getClass() == wordClass) {
            consume(nextToken());
        } else {
            throw new IllegalStateException(
                    "Token '" + nextToken() + "' is not of type '"
                            + wordClass.getSimpleName() + "'");
        }
    }

    protected void consume(final Symbol... accepted) {
        if (Arrays.stream(accepted).anyMatch((s) -> s == nextToken())) {
            consume(nextToken());
        }
    }

    protected List<Word> getTokens() {
        return tokens;
    }

    protected void addChild(final StatModNode statModNode) {
        value.add(Leaf.of(statModNode));
    }
}
