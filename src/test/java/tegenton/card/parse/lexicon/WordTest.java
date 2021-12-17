package tegenton.card.parse.lexicon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {
    public static Word[] words;
    public static List<String> values;

    @AfterEach
    void compare() {
        assertEquals(words.length, values.size());
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].getWord());
        }
    }

    @Test
    void adjective() {
        words = Adjective.values();
        values = List.of("CHOSEN", "DIFFERENT", "EQUAL", "FIRST", "NEXT");
    }

    @Test
    void adverb() {
        words = Adverb.values();
        values = List.of("LIKEWISE", "ONLY", "OVER");
    }

    @Test
    void conjunction() {
        words = Conjunction.values();
        values = List.of("AND", "OR", "THEN");
    }

    @Test
    void comparative() {
        words = Comparative.values();
        values = List.of("GREATER", "LESS", "MORE", "THAN");
    }

    @Test
    void determiner() {
        words = Determiner.values();
        values = List.of("A", "AN", "THE", "TARGET", "THIS", "THESE", "THAT",
                "THOSE", "NO", "OTHER", "ANOTHER", "ALL", "EACH",
                "ANY", "SOME");
    }

    @Test
    void morpheme() {
        words = Morpheme.values();
        values = List.of("ER", "ING", "S");
    }

    @Test
    void noun() {
        words = Noun.values();
        values = List.of("AMOUNT", "HEIGHT", "NUMBER", "RANDOM", "TEXT", "TIME", "WORD");
    }

    @Test
    void preposition() {
        words = Preposition.values();
        values = List.of("ABOVE", "BEYOND", "BY", "FOR", "FROM", "IN", "MINUS", "OF", "ON", "TO", "UNDER",
                "WITH");
    }

    @Test
    void subordinateConjunction() {
        words = SubordinateConjunction.values();
        values = List.of("AS", "BUT", "EXCEPT", "IF", "LONG", "WHERE");
    }
}
