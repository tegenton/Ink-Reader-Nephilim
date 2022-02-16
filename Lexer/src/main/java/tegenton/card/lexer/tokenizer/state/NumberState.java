package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.DigitNumber;

import java.util.Map;
import java.util.function.Consumer;

public final class NumberState extends State {
    private int number = 0;

    NumberState() {
        super("Number");
    }

    @Override
    public void accept(final Consumer<String> setState,
                       final Consumer<Word> addToken, final char c) {
        if (Character.isDigit(c)) {
            number += c - '0';
        } else {
            addToken.accept(new DigitNumber(number));
            setState.accept(Character.toString(c));
        }
    }

    @Override
    protected Map<String, Map<Character, Transition>> transitions() {
        return null;
    }
}
