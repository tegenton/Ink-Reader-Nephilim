package tegenton.card.parse.token;

import java.util.List;

public class TokenStream {
    private final List<Token> tokens;
    private int index = 0;

    public TokenStream(String s) {
        tokens = Token.tokenize(s);
    }

    public boolean hasNext() {
        return index < tokens.size();
    }

    public Token getNext() {
        return tokens.get(index++);
    }
}
