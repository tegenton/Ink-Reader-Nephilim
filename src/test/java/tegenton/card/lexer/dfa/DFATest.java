package tegenton.card.lexer.dfa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DFATest {
    public static Word word;

    @AfterEach
    void compare() {
        final DFA dfa = new DFA();
        word.getWord().chars().mapToObj((x) -> (char) x).forEach(dfa::consume);
        final List<Word> actual = dfa.products();
        assertEquals(1, actual.size());
        assertEquals(word, actual.get(0));
    }

    @ParameterizedTest
    @EnumSource(Comparative.class)
    void comparatives(final Word comparative) {
        word = comparative;
    }

    @ParameterizedTest
    @EnumSource(Conjunction.class)
    void conjunction(final Word conjunction) {
        word = conjunction;
    }

    @ParameterizedTest
    @EnumSource(Determiner.class)
    void determiner(final Word determiner) {
        word = determiner;
    }

    @ParameterizedTest
    @EnumSource(Preposition.class)
    void preposition(final Word preposition) {
        word = preposition;
    }

    @ParameterizedTest
    @EnumSource(Symbol.class)
    void symbol(final Word symbol) {
        word = symbol;
    }

}
