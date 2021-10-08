package tegenton.card.parse.token;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class KeywordAbilityTokenTest {
    public static KeywordAbilityToken keywordAbilityToken;

    @ParameterizedTest
    @ValueSource(strings = {"Deathtouch", "Defender", "Double Strike", "Enchant", "Equip", "First Strike", "Flash", "Flying", "Haste", "Hexproof", "Indestructible", "Lifelink", "Menace", "Protection", "Reach", "Trample", "Vigilance", "Ward"})
    void evergreen(String word) {
        keywordAbilityToken = KeywordAbilityToken.fromString(word);
        assertNotNull(keywordAbilityToken);
        assertEquals(word, keywordAbilityToken.getWord().getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Impoopulate", "Magecraft", "Landfall"})
    void invalid(String word) {
        keywordAbilityToken = KeywordAbilityToken.fromString(word);
        assertNull(keywordAbilityToken);
    }
}
