package tegenton.card.parse.lexicon;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueWordTest {
    public static List<String> words = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty");

    public static List<String> digits = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");

    @Test
    void englishNumber() {
        EnglishNumber number;
        for (int i = 0; i < words.size(); i++) {
            number = EnglishNumber.valueOf(words.get(i).toUpperCase());
            assertEquals(number.getVal(), i);
        }
    }

    @Test
    void number() {
        Number number;
        for (int i = 0; i < digits.size(); i++) {
            number = Number.valueOf(digits.get(i));
            assertEquals(number.getVal(), i);
        }
    }

    @Test
    void values() {
        assertEquals(digits.size(), words.size());
        ValueWord digit;
        ValueWord word;
        for (int i = 0; i < digits.size(); i++) {
            digit = Number.valueOf(digits.get(i));
            word = EnglishNumber.valueOf(words.get(i).toUpperCase());
            assertEquals(digit.getVal(), word.getVal());
        }
    }
}
