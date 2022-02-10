package tegenton.card.json.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tegenton.card.json.JsonLoader;
import tegenton.card.lexicon.game.ManaSymbol;

import java.io.IOException;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetCardJsonTest {
    public static SetCardJson animateWall;

    @BeforeAll
    static void loadJson() throws IOException {
        JsonLoader loader = new JsonLoader();
        SetJson lea = loader.loadSet("LEA");
        animateWall = lea.getCards().get(0);
    }

    @Test
    void getArtist() {
        assertEquals("Dan Frazier", animateWall.getArtist());
    }

    @Test
    void getAsciiName() {
        assertNull(animateWall.getAsciiName());
    }

    @Test
    void getAvailability() {
        EnumSet<Printing> expected = EnumSet.of(Printing.paper);
        assertEquals(expected, animateWall.getAvailability());
    }

    @Test
    void getBorderColor() {
        assertEquals(BorderColor.black, animateWall.getBorderColor());
    }

    @Test
    void getCardParts() {
        assertNull(animateWall.getCardParts());
    }

    @Test
    void getColorIdentity() {
        EnumSet<ManaSymbol> expected = EnumSet.of(ManaSymbol.W);
        assertEquals(expected, animateWall.getColorIdentity());
    }

    @Test
    void getColorIndicator() {
        assertNull(animateWall.getColorIndicator());
    }

    @Test
    void getColors() {
        EnumSet<ManaSymbol> expected = EnumSet.of(ManaSymbol.W);
        assertEquals(expected, animateWall.getColors());
    }

    @Test
    void getEdhrecRank() {
        assertEquals(15383, animateWall.getEdhrecRank());
    }

    @Test
    void getFaceFlavorName() {
        assertNull(animateWall.getFaceFlavorName());
    }

    @Test
    void getFaceManaValue() {
        assertNull(animateWall.getFaceManaValue());
    }

    @Test
    void getFaceName() {
        assertNull(animateWall.getFaceName());
    }

    @Test
    void getFinishes() {
        EnumSet<Finish> expected = EnumSet.of(Finish.nonfoil);
        assertEquals(expected, animateWall.getFinishes());
    }

    @Test
    void getFlavorName() {
        assertNull(animateWall.getFlavorName());
    }

    @Test
    void getFlavorText() {
        assertNull(animateWall.getFlavorText());
    }

    @Test
    void getForeignData() {
        fail("todo: foreign data");
    }

    @Test
    void getFrameEffects() {
        assertNull(animateWall.getFrameEffects());
    }

    @Test
    void getFrameVersion() {
        assertEquals("1993", animateWall.getFrameVersion());
    }

    @Test
    void getHand() {
        assertNull(animateWall.getHand());
    }

    @Test
    void getHasAlternativeDeckLimit() {
        assertNull(animateWall.getHasAlternativeDeckLimit());
    }

    @Test
    void getHasContentWarning() {
        assertNull(animateWall.getHasContentWarning());
    }

    @Test
    void getIdentifiers() {
        IdentifiersJson expected = new IdentifiersJson("1029");
        assertEquals(expected, animateWall.getIdentifiers());
    }

    @Test
    void getIsAlternative() {
        assertNull(animateWall.getIsAlternative());
    }

    @Test
    void getIsFullArt() {
        assertNull(animateWall.getIsFullArt());
    }

    @Test
    void getIsFunny() {
        assertNull(animateWall.getIsFunny());
    }

    @Test
    void getIsOnlineOnly() {
        assertNull(animateWall.getIsOnlineOnly());
    }

    @Test
    void getIsOversized() {
        assertNull(animateWall.getIsOversized());
    }

    @Test
    void getIsPromo() {
        assertNull(animateWall.getIsPromo());
    }

    @Test
    void getIsRebalanced() {
        assertNull(animateWall.getIsRebalanced());
    }

    @Test
    void getIsReprint() {
        assertNull(animateWall.getIsReprint());
    }

    @Test
    void getIsReserved() {
        assertNull(animateWall.getIsReserved());
    }

    @Test
    void getIsStarter() {
        assertNull(animateWall.getIsStarter());
    }

    @Test
    void getIsStorySpotlight() {
        assertNull(animateWall.getIsStorySpotlight());
    }

    @Test
    void getIsTextless() {
        assertNull(animateWall.getIsTextless());
    }

    @Test
    void getIsTimeshifted() {
        assertNull(animateWall.getIsTimeshifted());
    }

    @Test
    void getKeywords() {
        assertEquals(List.of("Enchant"), animateWall.getKeywords());
    }

    @Test
    void getLayout() {
        assertEquals(Layout.normal, animateWall.getLayout());
    }

    @Test
    void getLeadershipSkills() {
        fail("todo: leadership skills");
    }

    @Test
    void getLegalities() {
        fail("todo: legalities");
    }
}
