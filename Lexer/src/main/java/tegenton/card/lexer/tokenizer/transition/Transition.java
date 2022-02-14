package tegenton.card.lexer.tokenizer.transition;

import tegenton.card.lexicon.Word;

import java.util.function.Consumer;

public class Transition {
    private final char label;
    private String output;
    private Word product;

    /**
     * Create a basic transition on a single letter.
     *
     * @param a Character to transition on.
     */
    public Transition(final char a) {
        label = a;
    }

    /**
     * Create a transition with a product.
     *
     * @param a    Character to transition on.
     * @param word Product.
     */
    public Transition(final char a, final Word word) {
        label = a;
        product = word;
    }

    /**
     * Create a transition to a particular state.
     *
     * @param a     Character to transition on.
     * @param state Destination state.
     */
    public Transition(final char a, final String state) {
        label = a;
        output = state;
    }

    /**
     * Create a transition to a particular state with a product.
     *
     * @param a     Character to transition on.
     * @param word  Product.
     * @param state Destination state.
     */
    public Transition(final char a, final Word word, final String state) {
        label = a;
        product = word;
        output = state;
    }

    /**
     * Utilize transition.
     *
     * @param wordConsumer Consumer that accepts product output.
     * @param name         State transitioning from.
     * @return State transitioned to.
     */
    public String accept(final Consumer<Word> wordConsumer, final String name) {
        if (product != null) {
            wordConsumer.accept(product);
        }
        if (output != null) {
            return output;
        }
        return name + label;
    }

    /**
     * Check whether this transition accepts a particular character.
     *
     * @param c Character to check.
     * @return Is this transition on that character?
     */
    public boolean contains(final char c) {
        return label == c;
    }
}
