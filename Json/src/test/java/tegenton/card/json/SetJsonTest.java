package tegenton.card.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetJsonTest {
    public static SetJson lea;

    @BeforeAll
    static void loadJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonLoader loader = new JsonLoader(mapper);
        lea = loader.loadSet("LEA");
    }

    @Test
    void getBaseSetSize() {
        assertEquals(295, lea.getBaseSetSize());
    }

    @Test
    void getBlock() {
        assertEquals("Core Set", lea.getBlock());
    }

    @Test
    void getBooster() {
        fail("TODO: booster");
    }

    @Test
    void getCards() {
        fail("TODO: cards");
    }

    @Test
    void getCode() {
        assertEquals("LEA", lea.getCode());
    }

    @Test
    void getCodeV3() {
        assertNull(lea.getCodeV3());
    }

    @Test
    void isForeignOnly() {
        assertFalse(lea.getIsForeignOnly());
    }

    @Test
    void isFoilOnly() {
        assertFalse(lea.getIsFoilOnly());
    }

    @Test
    void isNonFoilOnly() {
        assertTrue(lea.getIsNonFoilOnly());
    }

    @Test
    void isOnlineOnly() {
        assertFalse(lea.getIsOnlineOnly());
    }

    @Test
    void isPaperOnly() {
        assertFalse(lea.getIsPaperOnly());
    }

    @Test
    void isPartialPreview() {
        assertFalse(lea.getIsPartialPreview());
    }

    @Test
    void getKeyruneCode() {
        assertEquals("LEA", lea.getKeyruneCode());
    }

    @Test
    void getMcmId() {
        assertEquals(0, lea.getMcmId());
    }

    @Test
    void getMcmIdExtras() {
        assertEquals(0, lea.getMcmIdExtras());
    }

    @Test
    void getMcmName() {
        assertNull(lea.getMcmName());
    }

    @Test
    void getMtgoCode() {
        assertNull(lea.getMtgoCode());
    }

    @Test
    void getName() {
        assertEquals("Limited Edition Alpha", lea.getName());
    }

    @Test
    void getParentCode() {
        assertNull(lea.getParentCode());
    }

    @Test
    void getReleaseDate() {
        assertEquals(new Date(744508800000L), lea.getReleaseDate());
    }

    @Test
    void getSealedProduct() {
        assertEquals(List.of(new SealedProductJson(), new SealedProductJson(),
                new SealedProductJson()), lea.getSealedProduct());
    }

    @Test
    void getTcgplayerGroupId() {
        assertEquals(7, lea.getTcgplayerGroupId());
    }

    @Test
    void getTokens() {
        fail("TODO: tokens");
    }

    @Test
    void getTotalSetSize() {
        assertEquals(295, lea.getTotalSetSize());
    }

    @Test
    void getTranslations() {
        assertEquals(new TranslationJson(), lea.getTranslations());
    }

    @Test
    void getType() {
        assertEquals(SetType.core, lea.getType());
    }
}
