package tegenton.card.parse.lexicon.game.type;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;
import tegenton.card.parse.lexicon.game.type.CardType;
import tegenton.card.parse.lexicon.game.type.SuperType;

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
