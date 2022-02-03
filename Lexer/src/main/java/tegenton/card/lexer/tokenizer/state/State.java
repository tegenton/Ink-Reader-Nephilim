package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.Tokenizer;

public interface State {
    static State empty() {
        return StateFactory.getState("");
    }

    void accept(Tokenizer tokenizer, char c);
}
