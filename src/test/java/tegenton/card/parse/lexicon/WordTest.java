package tegenton.card.parse.lexicon;

import org.junit.jupiter.api.Test;

import java.util.List;

public class WordTest extends WordTestTemplate {
    @Test
    void adjective() {
        words = Adjective.values();
        values = List.of("ADDITIONAL", "CHOSEN", "DIFFERENT", "EQUAL", "EXTRA", "FIRST", "NEW", "NEXT", "ROUNDED", "SAME");
    }

    @Test
    void adverb() {
        words = Adverb.values();
        values = List.of("BACK", "COMPLETELY", "EVENLY", "INSTEAD", "LIKEWISE", "NOT", "ONCE", "ONLY", "OVER", "STILL");
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
                "THOSE", "NO", "OTHER", "ANOTHER", "LEAST", "MANY", "ALL", "EACH",
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
        values = List.of("ED", "ER", "ING", "S");
    }

    @Test
    void noun() {
        words = Noun.values();
        values = List.of("AMOUNT", "CHOICE", "FEWEST", "FOOT", "HEIGHT", "INSTANCE", "LABEL",
                "NUMBER", "ORDER", "RANDOM", "REST", "TEXT", "TIME", "WAY",
                "WORD");
    }

    @Test
    void particle() {
        words = Particle.values();
        values = List.of("DOWN", "LEFT", "RIGHT", "UP");
    }

    @Test
    void preposition() {
        words = Preposition.values();
        values = List.of("ABOVE", "ADDITION", "AMONG", "BEYOND", "BY", "FOR", "FROM", "IN",
                "MINUS", "OF", "ON", "OUT", "TO", "UNDER", "WITH");
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
