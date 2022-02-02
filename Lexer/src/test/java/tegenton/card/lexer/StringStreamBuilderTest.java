package tegenton.card.lexer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class StringStreamBuilderTest {
    public static String text;
    public static Stream<String> expected;

    @AfterEach
    void compare() {
        StringStreamBuilder actual = new StringStreamBuilder(text);
        assertIterableEquals(expected.toList(), actual.build().toList());
    }

    @Test
    void empty() {
        text = "";
        expected = Stream.of();
    }

    @Test
    void singleWord() {
        text = "Target";
        expected = Stream.of("Target");
    }

    @Test
    void ancestralRecall() {
        text = "Target player draws three cards.";
        expected = Stream.of("Target ", "player ", "draws ", "three ",
                "cards.");
    }
}
