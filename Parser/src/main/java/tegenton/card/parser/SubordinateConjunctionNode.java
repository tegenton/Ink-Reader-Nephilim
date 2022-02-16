package tegenton.card.parser;

import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SubordinateConjunctionNode {
    private final List<SubordinateConjunction> value;

    SubordinateConjunctionNode(
            final SubordinateConjunction... subordinateConjunctions) {
        value = Arrays.asList(subordinateConjunctions);
    }

    public SubordinateConjunctionNode(final List<Word> input) {
        value = new ArrayList<>();
        final List<Word> tokens = new ArrayList<>(input);
        consume(tokens, SubordinateConjunction.AS);
        pop(tokens, Symbol.SPACE);
        consume(tokens, SubordinateConjunction.LONG);
        pop(tokens, Symbol.SPACE);
        consume(tokens, SubordinateConjunction.AS);
    }

    private void pop(final List<Word> tokens, final Symbol expected) {
        if (tokens.size() > 0) {
            if (tokens.get(0) == expected) {
                tokens.remove(0);
            }
        }
    }

    private void consume(final List<Word> tokens,
                         final SubordinateConjunction expected) {
        if (tokens.size() > 0) {
            if (tokens.get(0) == expected) {
                value.add(expected);
                tokens.remove(0);
            }
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
        final SubordinateConjunctionNode that = (SubordinateConjunctionNode) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "SubordinateConjunctionNode{" + "value=" + value + '}';
    }
}
