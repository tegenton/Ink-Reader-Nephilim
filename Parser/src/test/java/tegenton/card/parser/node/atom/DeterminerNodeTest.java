package tegenton.card.parser.node.atom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeterminerNodeTest {
    public static List<Word> tokens;
    public static DeterminerNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    void compare() {
        assertEquals(expected, new DeterminerNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void article() {
        List<Word> articles =
                List.of(Determiner.A, Determiner.AN, Determiner.THE);
        for (Word article : articles) {
            tokens = new ArrayList<>();
            tokens.add(article);
            expected = new DeterminerNode(article);
            compare();
        }
    }

    @Test
    void demonstrative() {
        List<Word> articles =
                List.of(Determiner.TARGET, Determiner.THIS, Determiner.THESE,
                        Determiner.THAT, Determiner.THOSE);
        for (Word article : articles) {
            tokens = new ArrayList<>();
            tokens.add(article);
            expected = new DeterminerNode(article);
            compare();
        }
    }

    @Test
    void negative() {
        List<Word> articles = List.of(Adverb.NOT);
        for (Word article : articles) {
            tokens = new ArrayList<>();
            tokens.add(article);
            expected = new DeterminerNode(article);
            compare();
        }
    }

    @Test
    void alternative() {
        List<Word> articles = List.of(Determiner.OTHER, Determiner.ANOTHER);
        for (Word article : articles) {
            tokens = new ArrayList<>();
            tokens.add(article);
            expected = new DeterminerNode(article);
            compare();
        }
    }

    @Test
    void universal() {
        List<Word> articles = List.of(Determiner.ALL);
        for (Word article : articles) {
            tokens = new ArrayList<>();
            tokens.add(article);
            expected = new DeterminerNode(article);
            compare();
        }
    }

    @Test
    void distributive() {
        List<Word> articles = List.of(Determiner.EACH);
        for (Word article : articles) {
            tokens = new ArrayList<>();
            tokens.add(article);
            expected = new DeterminerNode(article);
            compare();
        }
    }

    @Test
    void existential() {
        List<Word> articles = List.of(Determiner.ANY);
        for (Word article : articles) {
            tokens = new ArrayList<>();
            tokens.add(article);
            expected = new DeterminerNode(article);
            compare();
        }
    }
}
