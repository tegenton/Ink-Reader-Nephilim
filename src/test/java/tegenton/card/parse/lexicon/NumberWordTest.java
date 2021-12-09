package tegenton.card.parse.lexicon;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class NumberWordTest {

    @Test
    void englishNumber() {
        List<String> strings = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty");
        EnglishNumber number;
        for (int i = 0; i < strings.size(); i++) {
            number = EnglishNumber.valueOf(strings.get(i));
            assertEquals(number.getVal(), i);
        }
    }

    @Test
    void number() {
        List<String> strings = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");
        Number number;
        for (int i = 0; i < strings.size(); i++) {
            number = Number.valueOf(strings.get(i));
            assertEquals(number.getVal(), i);
        }
    }
}
