package tegenton.card.lexer.tokenizer;

import tegenton.card.lexer.tokenizer.state.State;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final List<Word> tokens = new ArrayList<>();
    private final State state = State.empty();

    public List<Word> tokenize(String input) {
        input.chars().forEach((c) -> state.accept(this, (char) c));
        return tokens;
    }

    public void addToken(Word token) {
        tokens.add(token);
    }
}
