package tegenton.card.parse.lexicon.game.type;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTestTemplate;

import java.util.List;

class TypeWordTest extends WordTestTemplate {
    @Test
    void superType() {
        words = SuperType.values();
        values = List.of("BASIC");
    }

    @Test
    void cardType() {
        words = CardType.values();
        values = List.of("ARTIFACT", "CREATURE", "ENCHANTMENT", "INSTANT",
                "LAND", "PLANESWALKER", "SORCERY");
    }
}
