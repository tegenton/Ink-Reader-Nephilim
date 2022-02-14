package tegenton.card.json.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tegenton.card.json.JsonLoader;

import java.io.IOException;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SetCardJsonTest {
    public static SetCardJson animateWall;

    @BeforeAll
    static void loadJson() throws IOException {
        final JsonLoader loader = new JsonLoader();
        final SetJson lea = loader.loadSet("LEA");
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
        final EnumSet<Printing> expected = EnumSet.of(Printing.paper);
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
        final EnumSet<Color> expected = EnumSet.of(Color.W);
        assertEquals(expected, animateWall.getColorIdentity());
    }

    @Test
    void getColorIndicator() {
        assertNull(animateWall.getColorIndicator());
    }

    @Test
    void getColors() {
        final EnumSet<Color> expected = EnumSet.of(Color.W);
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
        final EnumSet<Finish> expected = EnumSet.of(Finish.nonfoil);
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
        assertEquals(List.of(), animateWall.getForeignData());
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
        assertNull(animateWall.hasContentWarning());
    }

    @Test
    void getIdentifiers() {
        final IdentifiersJson expected = new IdentifiersJson("1029").setIdentifiers(
                "64004", "5418", "5b4a162f-c574-5f7e-a883-375aa3ba6642", "232",
                "d5c83259-9b90-47c2-b48e-c7d78519e792",
                "6757e04d-7bfc-4bdc-9dcb-02059a2d4e60",
                "c7a6a165-b709-46e0-ae42-6f69a17c0621");
        assertEquals(expected, animateWall.getIdentifiers());
    }

    @Test
    void getIsAlternative() {
        assertNull(animateWall.isAlternative());
    }

    @Test
    void getIsFullArt() {
        assertNull(animateWall.isFullArt());
    }

    @Test
    void getIsFunny() {
        assertNull(animateWall.isFunny());
    }

    @Test
    void getIsOnlineOnly() {
        assertNull(animateWall.isOnlineOnly());
    }

    @Test
    void getIsOversized() {
        assertNull(animateWall.isOversized());
    }

    @Test
    void getIsPromo() {
        assertNull(animateWall.isPromo());
    }

    @Test
    void getIsRebalanced() {
        assertNull(animateWall.isRebalanced());
    }

    @Test
    void getIsReprint() {
        assertNull(animateWall.isReprint());
    }

    @Test
    void getIsReserved() {
        assertNull(animateWall.isReserved());
    }

    @Test
    void getIsStarter() {
        assertNull(animateWall.isStarter());
    }

    @Test
    void getIsStorySpotlight() {
        assertNull(animateWall.isStorySpotlight());
    }

    @Test
    void getIsTextless() {
        assertNull(animateWall.isTextless());
    }

    @Test
    void getIsTimeshifted() {
        assertNull(animateWall.isTimeshifted());
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
        assertNull(animateWall.getLeadershipSkills());
    }

    @Test
    void getLegalities() {
        final LegalitiesJson expected = new LegalitiesJson().setCommander(
                        Legality.Legal).setDuel(Legality.Legal)
                .setLegacy(Legality.Legal).setOldschool(Legality.Legal)
                .setPenny(Legality.Legal).setPremodern(Legality.Legal)
                .setVintage(Legality.Legal);
        assertEquals(expected, animateWall.getLegalities());
    }

    @Test
    void getLife() {
        assertNull(animateWall.getLife());
    }

    @Test
    void getLoyalty() {
        assertNull(animateWall.getLoyalty());
    }

    @Test
    void getManaCost() {
        assertEquals("{W}", animateWall.getManaCost());
    }

    @Test
    void getManaValue() {
        assertEquals(1, animateWall.getManaValue());
    }

    @Test
    void getName() {
        assertEquals("Animate Wall", animateWall.getName());
    }

    @Test
    void getNumber() {
        assertEquals(1, animateWall.getNumber());
    }

    @Test
    void getOriginalPrintings() {
        assertNull(animateWall.getOriginalPrintings());
    }

    @Test
    void getOriginalReleaseDate() {
        assertNull(animateWall.getOriginalReleaseDate());
    }

    @Test
    void getOriginalText() {
        assertEquals(
                "Target wall can now attack. Target wall's power and toughness are unchanged, even if its power is 0.",
                animateWall.getOriginalText());
    }

    @Test
    void getOriginalType() {
        assertEquals("Enchant Wall", animateWall.getOriginalType());
    }

    @Test
    void getOtherFaceIds() {
        assertNull(animateWall.getOtherFaceIds());
    }

    @Test
    void getPower() {
        assertNull(animateWall.getPower());
    }

    @Test
    void getPrintings() {
        assertEquals(13, animateWall.getPrintings().size());
    }

    @Test
    void getPromoTypes() {
        assertNull(animateWall.getPromoTypes());
    }

    @Test
    void getPurchaseUrls() {
        final PurchaseUrlsJson expected = new PurchaseUrlsJson(
                "https://mtgjson.com/links/5bab9be709288464",
                "https://mtgjson.com/links/54e4d282a7e51259");
        assertEquals(expected, animateWall.getPurchaseUrls());
    }

    @Test
    void getRarity() {
        assertEquals(Rarity.rare, animateWall.getRarity());
    }

    @Test
    void getRebalancedPrintings() {
        assertNull(animateWall.getRebalancedPrintings());
    }

    @Test
    void getRulings() {
        final List<Ruling> expected = List.of(new Ruling(new Date(1189900800000L),
                "This is a change from the most recent wording. As was the case in the past, Animate Wall can now enchant only a Wall."));
        assertEquals(expected, animateWall.getRulings());
    }

    @Test
    void getSecurityStamp() {
        assertNull(animateWall.getSecurityStamp());
    }

    @Test
    void getSetcode() {
        assertEquals("LEA", animateWall.getSetCode());
    }

    @Test
    void getSide() {
        assertNull(animateWall.getSide());
    }

    @Test
    void getSignature() {
        assertNull(animateWall.getSignature());
    }

    @Test
    void getSubtypes() {
        assertEquals(List.of("Aura"), animateWall.getSubtypes());
    }

    @Test
    void getSupertypes() {
        assertEquals(List.of(), animateWall.getSupertypes());
    }

    @Test
    void getText() {
        assertEquals("""
                        Enchant Wall
                        Enchanted Wall can attack as though it didn't have defender.""",
                animateWall.getText());
    }

    @Test
    void getToughness() {
        assertNull(animateWall.getToughness());
    }

    @Test
    void getType() {
        assertEquals("Enchantment \u2014 Aura", animateWall.getType());
    }

    @Test
    void getTypes() {
        assertEquals(List.of("Enchantment"), animateWall.getTypes());
    }

    @Test
    void getUuid() {
        assertEquals(UUID.fromString("2b304dc1-8d7d-50a7-a310-2d0e5427935f"),
                animateWall.getUuid());
    }

    @Test
    void getVariations() {
        assertNull(animateWall.getVariations());
    }

    @Test
    void getWatermark() {
        assertNull(animateWall.getWatermark());
    }
}
