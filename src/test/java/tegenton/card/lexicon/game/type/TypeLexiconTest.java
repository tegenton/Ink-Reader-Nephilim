package tegenton.card.lexicon.game.type;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.lexicon.LexiconTest;

public class TypeLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(SuperType.class)
    void superType(SuperType superType) {
        word = superType;
    }

    @ParameterizedTest
    @EnumSource(CardType.class)
    void cardType(CardType cardType) {
        word = cardType;
    }
}
