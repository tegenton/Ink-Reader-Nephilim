package tegenton.card.lexer.tokenizer.transition;

import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Word;

public class Transition {
    private final char label;
    private String output;
    private Word product;

    public Transition(final char a) {
        label = a;
    }

    public Transition(final char a, final Word word) {
        label = a;
        product = word;
    }

    public Transition(final char a, final String state) {
        label = a;
        output = state;
    }

    public Transition(final char a, final Word word, final String state) {
        label = a;
        product = word;
        output = state;
    }

    public String accept(final Tokenizer tokenizer, final String name) {
        if (product != null) {
            tokenizer.addToken(product);
        }
        if (output != null) {
            return output;
        }
        return name + label;
    }

    public boolean contains(final char c) {
        return label == c;
    }
}
