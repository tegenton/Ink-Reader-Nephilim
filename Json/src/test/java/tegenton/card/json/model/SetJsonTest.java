package tegenton.card.json.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tegenton.card.json.JsonLoader;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetJsonTest {
    public static SetJson lea;

    @BeforeAll
    static void loadJson() throws IOException {
        JsonLoader loader = new JsonLoader();
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
        assertEquals(1, lea.getBooster().getDefault().getBoostersTotalWeight());
    }

    @Test
    void getCards() {
        assertEquals(295, lea.getCards().size());
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
        List<SealedProductJson> expected = List.of(
                new SealedProductJson("22bb173e-dfe7-5589-8616-c820fce5ebb4"),
                new SealedProductJson("1dbdd2d3-1455-5a0d-b775-f33fc1fcd7e2"),
                new SealedProductJson("621c6612-daf6-57a6-b2d7-acc126583b4e"));
        assertEquals(expected, lea.getSealedProduct());
    }

    @Test
    void getTcgplayerGroupId() {
        assertEquals(7, lea.getTcgplayerGroupId());
    }

    @Test
    void getTokens() {
        assertEquals(List.of(), lea.getTokens());
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
