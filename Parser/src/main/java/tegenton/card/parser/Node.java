package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.leaf.Leaf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Node {
    private final List<Leaf> value = new ArrayList<>();
    private List<Word> tokens;

    protected Node(final List<Word> input) {
        tokens = input;
    }

    protected Node(final Word... words) {
        Arrays.stream(words).map(Leaf::of).forEach(value::add);
    }

    public Node(final Node... nodes) {
        Arrays.stream(nodes).map(Leaf::of).forEach(value::add);
    }

    protected void expect(final Word expected) {
        if (tokens.size() > 0) {
            if (nextToken() == expected) {
                tokens.remove(0);
                return;
            }
        }
        throw new IllegalStateException(
                "Expected token '" + expected + "' does not match found token '"
                        + nextToken() + "'");
    }

    protected void consume(final Word expected) {
        expect(expected);
        value.add(Leaf.of(expected));
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
        try {
            return tokens.get(0);
        } catch (final IndexOutOfBoundsException e) {
            return null;
        }
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

    protected void consume(final Word... accepted) {
        if (Arrays.asList(accepted).contains(nextToken())) {
            consume(nextToken());
        } else {
            throw new IllegalStateException(
                    "Token '" + nextToken() + "' not found in '"
                            + Arrays.toString(accepted) + "'");
        }
    }

    protected List<Word> getTokens() {
        return tokens;
    }

    protected void addChild(final Node node) {
        value.add(Leaf.of(node));
    }
}
