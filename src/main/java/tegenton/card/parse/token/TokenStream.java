package tegenton.card.parse.token;

import java.util.List;

/**
 * Wrapper class for Tokens. Allows parser to pop tokens off the stack without
 * actually consuming them.
 */
public class TokenStream {
    private final List<Token> tokens;
    private int index = 0;

    /**
     * Create a new steam of tokens.
     *
     * @param s String to tokenize.
     */
    public TokenStream(final String s) {
        tokens = Token.tokenize(s);
    }

    /**
     * @return Are there more tokens left?
     */
    public boolean hasNext() {
        return index < tokens.size();
    }

    /**
     * "Pop" a token off the stack.
     *
     * @return The current token.
     */
    public Token getNext() {
        return tokens.get(index++);
    }

    /**
     * Returns the same thing as getNext(), does not change the contents of the
     * "stack".
     *
     * @return The current token.
     */
    public Token checkNext() {
        return tokens.get(index);
    }

}
