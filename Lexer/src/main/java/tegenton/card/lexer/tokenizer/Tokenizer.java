package tegenton.card.lexer.tokenizer;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;

public class Tokenizer {
    private Tokenizer() {

    }

    public static Word tokenize(String input) {
        return switch (input.charAt(0)) {
            case 'A' -> Determiner.A;
            case 'B' -> GameVerb.BE;
            default -> throw new IllegalStateException(
                    "Unexpected value: " + input.charAt(0));
        };
    }
}
