package tegenton.card.parse.lexicon.game.source.target.object;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

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
