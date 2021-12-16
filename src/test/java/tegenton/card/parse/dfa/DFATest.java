package tegenton.card.parse.dfa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.lexicon.*;
import tegenton.card.parse.lexicon.game.Zone;
import tegenton.card.parse.lexicon.value.EnglishNumber;
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
    @EnumSource(EnglishNumber.class)
    void englishNumber(Word number) {
        word = number;
    }

    @ParameterizedTest
    @EnumSource(Keyword.class)
    void keyword(Word keyword) {
        word = keyword;
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

    @ParameterizedTest
    @EnumSource(TriggerWord.class)
    void trigger(Word trigger) {
        word = trigger;
    }

    @ParameterizedTest
    @EnumSource(Zone.class)
    void zone(Word zone) {
        word = zone;
    }
}
