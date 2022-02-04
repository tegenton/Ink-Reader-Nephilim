package tegenton.card.lexer.tokenizer.transition;

import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

public class Transition {
    private final char label;
    private String output;
    private Word product;

    public Transition(char a) {
        label = a;
    }

    public Transition(char a, String state) {
        label = a;
        output = state;
    }

    public Transition(char a, Word word, String state) {
        label = a;
        product = word;
        output = state;
    }

    public static List<Transition> listOf(char... labels) {
        List<Transition> transitions = new ArrayList<>();
        for (char c : labels) {
            transitions.add(TransitionFactory.getTransition(c));
        }
        return transitions;
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
