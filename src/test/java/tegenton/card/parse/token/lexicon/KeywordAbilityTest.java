package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class KeywordAbilityTest {
    public static KeywordAbility keywordAbility;

    @ParameterizedTest
    @ValueSource(strings = {"Deathtouch", "Defender", "Double Strike", "Enchant", "Equip", "First Strike", "Flash", "Flying", "Haste", "Hexproof", "Indestructible", "Lifelink", "Menace", "Protection", "Reach", "Trample", "Vigilance", "Ward"})
    void evergreen(String word) {
        keywordAbility = KeywordAbility.fromString(word);
        assertNotNull(keywordAbility);
        assertEquals(word, keywordAbility.getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Impoopulate", "Magecraft", "Landfall"})
    void invalid(String word) {
        keywordAbility = KeywordAbility.fromString(word);
        assertNull(keywordAbility);
    }
}
