package tegenton.card.parse.lexicon.source.target.object;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;

public class ObjectLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(ObjectAttribute.class)
    void attribute(ObjectAttribute attribute) {
        word = attribute;
    }

    @ParameterizedTest
    @EnumSource(ObjectNoun.class)
    void noun(ObjectNoun noun) {
        word = noun;
    }

    @ParameterizedTest
    @EnumSource(ObjectVerb.class)
    void verb(ObjectVerb verb) {
        word = verb;
    }
}
