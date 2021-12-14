package tegenton.card.parse.dfa.state.morpheme;

import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TEENMorpheme extends Morpheme {
    private final EnglishNumber number;

    public TEENMorpheme(EnglishNumber number) {
        super("TEEN".toCharArray());
        this.number = number;
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        if (!this.completed()) {
            return Optional.empty();
        }
        return switch (c) {
            case '\0', ' ' -> Optional.of(switch (number) {
                case THREE -> EnglishNumber.THIRTEEN;
                case FOUR -> EnglishNumber.FOURTEEN;
                case FIVE -> EnglishNumber.FIFTEEN;
                case SIX -> EnglishNumber.SIXTEEN;
                case SEVEN -> EnglishNumber.SEVENTEEN;
                case EIGHT -> EnglishNumber.EIGHTEEN;
                case NINE -> EnglishNumber.NINETEEN;
                default -> throw new IllegalStateException("Cannot apply morpheme TEEN to " + number);
            });
            default -> Optional.empty();
        };
    }
}
