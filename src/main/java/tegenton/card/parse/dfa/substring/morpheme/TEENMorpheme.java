package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.value.EnglishNumber;

import java.util.Optional;

public class TEENMorpheme extends Morpheme {

    public TEENMorpheme(final EnglishNumber number) {
        super("TEEN".toCharArray(), number);
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        if (!this.completed()) {
            return Optional.empty();
        }
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> addTen();
            default -> null;
        });
    }

    private Word addTen() {
        return switch ((EnglishNumber) getProduct()) {
            case THREE -> EnglishNumber.THIRTEEN;
            case FOUR -> EnglishNumber.FOURTEEN;
            case FIVE -> EnglishNumber.FIFTEEN;
            case SIX -> EnglishNumber.SIXTEEN;
            case SEVEN -> EnglishNumber.SEVENTEEN;
            case EIGHT -> EnglishNumber.EIGHTEEN;
            case NINE -> EnglishNumber.NINETEEN;
            default -> throw new IllegalStateException(
                    "Cannot apply morpheme TEEN to " + getProduct());
        };
    }
}
