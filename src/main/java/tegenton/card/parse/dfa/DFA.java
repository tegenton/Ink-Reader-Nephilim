package tegenton.card.parse.dfa;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

public class DFA {
    private final List<Word> products = new ArrayList<>();
    private State state = State.state();

    public void consume(final int i) {
        consume((char) i);
    }

    public void consume(final char c) {
        state.produce(c).ifPresent(products::add);
        state = state.transition(c);
    }

    public List<Word> products() {
        state.produce('\0').ifPresent(products::add);
        return products;
    }
}
