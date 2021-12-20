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
        values = List.of("CHOSEN", "DIFFERENT", "EQUAL", "EXTRA", "FIRST", "NEW", "NEXT", "SAME");
    }

    @Test
    void adverb() {
        words = Adverb.values();
        values = List.of("BACK", "COMPLETELY", "EVENLY", "INSTEAD", "LIKEWISE", "ONLY", "OVER", "STILL");
    }

    @Test
    void conjunction() {
        words = Conjunction.values();
        values = List.of("AND", "OR", "THEN", "UNLESS");
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
                "THOSE", "NO", "OTHER", "ANOTHER", "MANY", "ALL", "EACH",
                "ANY", "SOME");
    }

    @Test
    void genitive() {
        words = Genitive.values();
        values = List.of("HALF");
    }

    @Test
    void morpheme() {
        words = Morpheme.values();
        values = List.of("ER", "ING", "S");
    }

    @Test
    void noun() {
        words = Noun.values();
        values = List.of("AMOUNT", "FOOT", "HEIGHT", "INSTANCE", "LABEL",
                "NUMBER", "ORDER", "RANDOM", "REST", "TEXT", "TIME", "WAY",
                "WORD");
    }

    @Test
    void particle() {
        words = Particle.values();
        values = List.of("DOWN", "UP");
    }

    @Test
    void preposition() {
        words = Preposition.values();
        values = List.of("ABOVE", "AMONG", "BEYOND", "BY", "FOR", "FROM", "IN",
                "MINUS", "OF", "ON", "TO", "UNDER", "WITH");
    }

    @Test
    void pronoun() {
        words = Pronoun.values();
        values = List.of("SO");
    }

    @Test
    void subordinateConjunction() {
        words = SubordinateConjunction.values();
        values = List.of("AS", "BUT", "EXCEPT", "IF", "LONG", "THOUGH", "WHERE");
    }
}
