package tegenton.card.lexer.tokenizer;

import tegenton.card.lexer.tokenizer.state.State;
import tegenton.card.lexer.tokenizer.state.StateFactory;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final List<Word> tokens = new ArrayList<>();
    private State state = State.empty();

    /**
     * Tokenize a string.
     *
     * @param input String to tokenize.
     * @return List of Words found in input.
     */
    public List<Word> tokenize(final String input) {
        input.chars().forEach(
                (c) -> state.accept(this::setState, this::addToken, (char) c));
        state.accept(this::setState, this::addToken, '\0');
        return tokens;
    }

    /**
     * Allows the addition of productions by the State instances.
     *
     * @param token Word to add to products.
     */
    private void addToken(final Word token) {
        tokens.add(token);
    }

    /**
     * Allows the change of state by State instances.
     *
     * @param name New state.
     */
    private void setState(final String name) {
        state = StateFactory.getState(name);
    }
}
