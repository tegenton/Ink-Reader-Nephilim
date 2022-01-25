package tegenton.card.lexer.dfa;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

public class DFA {
    private final List<Word> products = new ArrayList<>();
    private tegenton.card.lexer.dfa.state.State state = State.state();

    /**
     * Feed the DFA a character.
     *
     * @param c The next character
     */
    public void consume(final char c) {
        state.produce(c).ifPresent(products::add);
        state = state.transition(c);
    }

    /**
     * When transitioning, the DFA may be given Words.
     *
     * @return List of products received on transitions.
     */
    public List<Word> products() {
        state.produce('\0').ifPresent(products::add);
        return products;
    }
}
