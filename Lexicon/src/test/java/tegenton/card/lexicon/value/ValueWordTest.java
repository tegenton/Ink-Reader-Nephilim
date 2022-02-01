package tegenton.card.lexicon.value;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ValueWordTest {
    public static ValueWord[] words;
    public static List<String> values;

    void compare() {
        assertEquals(values.size(), words.length);
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].toString());
            assertEquals(i, words[i].getValue());
        }
    }

    @Test
    void englishNumber() {
        words = EnglishNumber.values();
        values = List.of("ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
                "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN",
                "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN",
                "NINETEEN", "TWENTY");
        compare();
    }

    @Test
    void digitNumber() {
        words = DigitNumber.values();
        values = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");
        compare();
    }

    @Test
    void variable() {
        words = Variable.values();
        values = List.of("X", "Y");
        assertEquals(values.size(), words.length);
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].toString());
        }
    }

    @Test
    void englishAndDigitsNotEqual() {
        ValueWord digit = new DigitNumber(1);
        ValueWord english = EnglishNumber.ONE;
        assertNotEquals(digit, english);
    }
}
