package tegenton.card.parse.dfa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.lexicon.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DFATest {
    public static Word word;

    @AfterEach
    void compare() {
        DFA dfa = new DFA();
        word.getWord().chars().forEach(dfa::consume);
        List<Word> actual = dfa.products();
        assertEquals(1, actual.size());
        assertEquals(word, actual.get(0));
    }

    @ParameterizedTest
    @EnumSource(Comparative.class)
    void comparatives(Word comparative) {
        word = comparative;
    }

    @ParameterizedTest
    @EnumSource(Conjunction.class)
    void conjunction(Word conjunction) {
        word = conjunction;
    }

    @ParameterizedTest
    @EnumSource(Determiner.class)
    void determiner(Word determiner) {
        word = determiner;
    }

    @ParameterizedTest
    @EnumSource(Preposition.class)
    void preposition(Word preposition) {
        word = preposition;
    }

    @ParameterizedTest
    @EnumSource(Symbol.class)
    void symbol(Word symbol) {
        word = symbol;
    }

}
