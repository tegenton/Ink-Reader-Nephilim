package tegenton.card.parse.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;

public class WordLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(Adjective.class)
    void adjective(Word adjective) {
        word = adjective;
    }

    @ParameterizedTest
    @EnumSource(Adverb.class)
    void adverb(Word adverb) {
        word = adverb;
    }

    @ParameterizedTest
    @EnumSource(Conjunction.class)
    void conjunction(Word conjunction) {
        word = conjunction;
    }

    @ParameterizedTest
    @EnumSource(Comparative.class)
    void comparative(Word comparative) {
        word = comparative;
    }

    @ParameterizedTest
    @EnumSource(Determiner.class)
    void determiner(Word determiner) {
        word = determiner;
    }

    @ParameterizedTest
    @EnumSource(Genitive.class)
    void genitive(Word genitive) {
        word = genitive;
    }

    @ParameterizedTest
    @EnumSource(Noun.class)
    void noun(Word noun) {
        word = noun;
    }

    @ParameterizedTest
    @EnumSource(Particle.class)
    void particle(Word particle) {
        word = particle;
    }

    @ParameterizedTest
    @EnumSource(Preposition.class)
    void preposition(Word preposition) {
        word = preposition;
    }

    @ParameterizedTest
    @EnumSource(Pronoun.class)
    void pronoun(Word pronoun) {
        word = pronoun;
    }

    @ParameterizedTest
    @EnumSource(SubordinateConjunction.class)
    void subordinateConjunction(Word subordinateConjunction) {
        word = subordinateConjunction;
    }
}
