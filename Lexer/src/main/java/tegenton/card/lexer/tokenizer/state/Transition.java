package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Word;

public class Transition {
    private final char label;
    private String output;
    private Word product;

    public Transition(char a) {
        label = a;
    }

    public Transition(char a, Word word) {
        label = a;
        product = word;
    }

    public Transition(char a, Word word, String state) {
        label = a;
        product = word;
        output = state;
    }

    public String accept(Tokenizer tokenizer, String name) {
        if (product != null) {
            tokenizer.addToken(product);
        }
        if (output != null) {
            return output;
        }
        return name + label;
    }

    public boolean contains(char c) {
        return label == c;
    }
}
