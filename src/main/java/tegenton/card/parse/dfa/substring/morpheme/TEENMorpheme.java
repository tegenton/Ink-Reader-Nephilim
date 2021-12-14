package tegenton.card.parse.dfa.substring.morpheme;

import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TEENMorpheme extends Morpheme {

    public TEENMorpheme(EnglishNumber number) {
        super("TEEN".toCharArray(), number);
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        if (!this.completed()) {
            return Optional.empty();
        }
        return switch (c) {
            case '\0', ' ' -> Optional.of(switch ((EnglishNumber) word) {
                case THREE -> EnglishNumber.THIRTEEN;
                case FOUR -> EnglishNumber.FOURTEEN;
                case FIVE -> EnglishNumber.FIFTEEN;
                case SIX -> EnglishNumber.SIXTEEN;
                case SEVEN -> EnglishNumber.SEVENTEEN;
                case EIGHT -> EnglishNumber.EIGHTEEN;
                case NINE -> EnglishNumber.NINETEEN;
                default -> throw new IllegalStateException("Cannot apply morpheme TEEN to " + word);
            });
            default -> Optional.empty();
        };
    }
}
