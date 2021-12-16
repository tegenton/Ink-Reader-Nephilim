package tegenton.card.parse.lexicon.value;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.WordTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueWordTest extends WordTest {
    public static final List<String> englishWords =
            List.of("ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
                    "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE",
                    "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN",
                    "EIGHTEEN", "NINETEEN", "TWENTY");

    public static final List<String> digits =
            List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");

    @Test
    void englishNumber() {
        words = EnglishNumber.values();
        values = englishWords;
        for (int i = 0; i < words.length; i++) {
            assertEquals(((ValueWord) words[i]).getVal(), i);
        }
    }

    @Test
    void number() {
        words = digits.stream().map(Number::valueOf).toArray(Word[]::new);
        values = digits;
        for (int i = 0; i < words.length; i++) {
            assertEquals(((ValueWord) words[i]).getVal(), i);
        }
    }
}
