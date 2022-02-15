package tegenton.card.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

enum Printing {
    mtgo,
    paper
}

enum BorderColor {
    black
}

enum Finish {
    nonfoil
}

enum FrameEffect {

}

enum Layout {
    normal
}

enum PromoType {

}

enum Rarity {
    common,
    uncommon,
    rare
}

enum Color {
    W,
    U,
    B,
    R,
    G
}

enum SecurityStamp {
}

enum Side {
}

class ForeignDataJson {
}

@JsonIgnoreProperties({"convertedManaCost", "hasFoil", "hasNonFoil"})
public class SetCardJson {
    private String artist;
    private String asciiName;
    @JsonProperty(required = true)
    private EnumSet<Printing> availability;
    @JsonProperty(required = true)
    private BorderColor borderColor;
    private List<String> cardParts;
    @JsonProperty(required = true)
    private EnumSet<Color> colorIdentity;
    private EnumSet<Color> colorIndicator;
    @JsonProperty(required = true)
    private EnumSet<Color> colors;
    private Integer edhrecRank;
    private String faceFlavorName;
    private Integer faceManaValue;
    private String faceName;
    @JsonProperty(required = true)
    private EnumSet<Finish> finishes;
    private String flavorName;
    private String flavorText;
    @JsonProperty(required = true)
    private List<ForeignDataJson> foreignData;
    @JsonProperty(required = true)
    private EnumSet<FrameEffect> frameEffects;
    @JsonProperty(required = true)
    private String frameVersion;
    private Integer hand;
    private Boolean hasAlternativeDeckLimit;
    @JsonProperty("hasContentWarning")
    private Boolean hasContentWarning;
    @JsonProperty(required = true)
    private IdentifiersJson identifiers;
    private Boolean isAlternative;
    private Boolean isFullArt;
    private Boolean isFunny;
    private Boolean isOnlineOnly;
    private Boolean isOversized;
    private Boolean isPromo;
    private Boolean isRebalanced;
    private Boolean isReprint;
    @JsonProperty("isReserved")
    private Boolean isReserved;
    private Boolean isStarter;
    private Boolean isStorySpotlight;
    private Boolean isTextless;
    private Boolean isTimeshifted;
    private List<String> keywords;
    @JsonProperty(required = true)
    private Layout layout;
    private LeadershipSkillsJson leadershipSkills;
    @JsonProperty(required = true)
    private LegalitiesJson legalities;
    private Integer life;
    private Integer loyalty;
    private String manaCost;
    @JsonProperty(required = true)
    private Integer manaValue;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private Integer number;
    private List<UUID> originalPrintings;
    private Date originalReleaseDate;
    private String originalText;
    private String originalType;
    @JsonProperty(required = true)
    private List<UUID> otherFaceIds;
    private String power;
    private List<String> printings;
    private EnumSet<PromoType> promoTypes;
    @JsonProperty(required = true)
    private PurchaseUrlsJson purchaseUrls;
    @JsonProperty(required = true)
    private Rarity rarity;
    private List<UUID> rebalancedPrintings;
    private List<Ruling> rulings;
    private SecurityStamp securityStamp;
    @JsonProperty(required = true)
    private String setCode;
    private Side side;
    private String signature;
    private List<String> subtypes;
    private List<String> supertypes;
    private String text;
    private String toughness;
    @JsonProperty(required = true)
    private String type;
    @JsonProperty(required = true)
    private List<String> types;
    @JsonProperty(required = true)
    private UUID uuid;
    @JsonProperty(required = true)
    private List<UUID> variations;
    private String watermark;

    /**
     * The name of the artist that illustrated the card art.
     *
     * @return The name of the artist that illustrated the card art.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * The ASCII (Basic/128) code formatted card name with no special unicode
     * characters.
     *
     * @return The ASCII (Basic/128) code formatted card name with no special
     * unicode characters.
     */
    public String getAsciiName() {
        return asciiName;
    }

    /**
     * A list of the card's available printing types.
     *
     * @return A list of the card's available printing types.
     */
    public EnumSet<Printing> getAvailability() {
        return availability;
    }

    /**
     * The color of the card border.
     *
     * @return The color of the card border.
     */
    public BorderColor getBorderColor() {
        return borderColor;
    }

    /**
     * A list of card names associated to this card, such as "Meld" card face
     * names.
     *
     * @return A list of card names associated to this card, such as "Meld" card
     * face names.
     */
    public List<String> getCardParts() {
        return cardParts;
    }

    /**
     * A list of all the colors found in manaCost, colorIndicator, and text.
     *
     * @return A list of all the colors found in manaCost, colorIndicator, and
     * text.
     */
    public EnumSet<Color> getColorIdentity() {
        return colorIdentity;
    }

    /**
     * A list of all the colors in the color indicator (The symbol prefixed to a
     * card's types).
     *
     * @return A list of all the colors in the color indicator.
     */
    public EnumSet<Color> getColorIndicator() {
        return colorIndicator;
    }

    /**
     * A list of all the colors in manaCost and colorIndicator. Some cards may
     * not have values, such as cards with "Devoid" in its text.
     *
     * @return A list of all the colors in manaCost and colorIndicator.
     */
    public EnumSet<Color> getColors() {
        return colors;
    }

    /**
     * The card rank on EDHRec.
     *
     * @return The card rank on EDHRec.
     */
    public Integer getEdhrecRank() {
        return edhrecRank;
    }

    /**
     * The flavor name on the face of the card.
     *
     * @return The flavor name on the face of the card.
     */
    public String getFaceFlavorName() {
        return faceFlavorName;
    }

    /**
     * The mana value of the face for either half or part of the card.
     *
     * @return The mana value of the face for either half or part of the card.
     */
    public Integer getFaceManaValue() {
        return faceManaValue;
    }

    /**
     * The name on the face of the card.
     *
     * @return The name on the face of the card.
     */
    public String getFaceName() {
        return faceName;
    }

    /**
     * The finishes of the card.
     *
     * @return The finishes of the card.
     */
    public EnumSet<Finish> getFinishes() {
        return finishes;
    }

    /**
     * The promotional card name printed above the true card name on special
     * cards that has no game function.
     *
     * @return The promotional card name printed above the true card name on
     * special cards that has no game function.
     */
    public String getFlavorName() {
        return flavorName;
    }

    /**
     * The italicized text found below the rules text that has no game
     * function.
     *
     * @return The italicized text found below the rules text that has no game
     * function.
     */
    public String getFlavorText() {
        return flavorText;
    }

    /**
     * A list of data properties in other languages. See the Foreign Data Data
     * Model.
     *
     * @return A list of data properties in other languages.
     */
    public List<ForeignDataJson> getForeignData() {
        return foreignData;
    }

    /**
     * The visual frame effects.
     *
     * @return The visual frame effects.
     */
    public EnumSet<FrameEffect> getFrameEffects() {
        return frameEffects;
    }

    /**
     * The version of the card frame style.
     *
     * @return The version of the card frame style.
     */
    public String getFrameVersion() {
        return frameVersion;
    }

    /**
     * The starting maximum hand size total modifier. A + or - character
     * precedes an integer.
     *
     * @return The starting maximum hand size total modifier.
     */
    public Integer getHand() {
        return hand;
    }

    /**
     * If the card allows a value other than 4 copies in a deck.
     *
     * @return If the card allows a value other than 4 copies in a deck.
     */
    public Boolean getHasAlternativeDeckLimit() {
        return hasAlternativeDeckLimit;
    }

    /**
     * If the card marked by Wizards of the Coast for having sensitive content.
     * Cards with this property may have missing or degraded properties and
     * values. See this official article for more information.
     *
     * @return If the card marked by Wizards of the Coast for having sensitive
     * content.
     */
    public Boolean hasContentWarning() {
        return hasContentWarning;
    }

    /**
     * A list of identifiers associated to a card. See the Identifiers Data
     * Model.
     *
     * @return A list of identifiers associated to a card.
     */
    public IdentifiersJson getIdentifiers() {
        return identifiers;
    }

    /**
     * If the card is an alternate variation to an original printing.
     *
     * @return If the card is an alternate variation to an original printing.
     */
    public Boolean isAlternative() {
        return isAlternative;
    }

    /**
     * If the card has full artwork.
     *
     * @return If the card has full artwork.
     */
    public Boolean isFullArt() {
        return isFullArt;
    }

    /**
     * If the card is part of a funny set.
     *
     * @return If the card is part of a funny set.
     */
    public Boolean isFunny() {
        return isFunny;
    }

    /**
     * @return If the card is only available in online game variations.
     */
    public Boolean isOnlineOnly() {
        return isOnlineOnly;
    }

    /**
     * If the card is oversized.
     *
     * @return If the card is oversized.
     */
    public Boolean isOversized() {
        return isOversized;
    }

    /**
     * If the card is a promotional printing.
     *
     * @return If the card is a promotional printing.
     */
    public Boolean isPromo() {
        return isPromo;
    }

    /**
     * If the card is rebalanced for the Alchemy play format.
     *
     * @return If the card is rebalanced for the Alchemy play format.
     */
    public Boolean isRebalanced() {
        return isRebalanced;
    }

    /**
     * If the card has been reprinted.
     *
     * @return If the card has been reprinted.
     */
    public Boolean isReprint() {
        return isReprint;
    }

    /**
     * If the card is on the Magic: The Gathering Reserved List.
     *
     * @return If the card is on the Magic: The Gathering Reserved List.
     */
    public Boolean isReserved() {
        return isReserved;
    }

    /**
     * If the card is found in a starter deck such as Planeswalker/Brawl decks.
     *
     * @return If the card is found in a starter deck such as Planeswalker/Brawl
     * decks.
     */
    public Boolean isStarter() {
        return isStarter;
    }

    /**
     * If the card is a Story Spotlight card.
     *
     * @return If the card is a Story Spotlight card.
     */
    public Boolean isStorySpotlight() {
        return isStorySpotlight;
    }

    /**
     * If the card does not have a text box.
     *
     * @return If the card does not have a text box.
     */
    public Boolean isTextless() {
        return isTextless;
    }

    /**
     * If the card is "timeshifted", a feature of certain sets where a card will
     * have a different frameVersion.
     *
     * @return If the card is "timeshifted".
     */
    public Boolean isTimeshifted() {
        return isTimeshifted;
    }

    /**
     * A list of keywords found on the card.
     *
     * @return A list of keywords found on the card.
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * The type of card layout. For a token card, this will be "token".
     *
     * @return The type of card layout.
     */
    public Layout getLayout() {
        return layout;
    }

    /**
     * A list of formats the card is legal to be a commander in. See the
     * Leadership Skills Data Model.
     *
     * @return A list of formats the card is legal to be a commander in.
     */
    public LeadershipSkillsJson getLeadershipSkills() {
        return leadershipSkills;
    }

    /**
     * A list of play formats the card is legal in. See the Legalities Data
     * Model.
     *
     * @return A list of play formats the card is legal in.
     */
    public LegalitiesJson getLegalities() {
        return legalities;
    }

    /**
     * The starting life total modifier. A plus or minus character precedes an
     * integer. Used only on cards with "Vanguard" in its types.
     *
     * @return The starting life total modifier.
     */
    public Integer getLife() {
        return life;
    }

    /**
     * The starting loyalty value of the card. Used only on cards with
     * "Planeswalker" in its types.
     *
     * @return The starting loyalty value of the card.
     */
    public Integer getLoyalty() {
        return loyalty;
    }

    /**
     * The mana cost of the card wrapped in brackets for each value.
     *
     * @return The mana cost of the card wrapped in brackets for each value.
     */
    public String getManaCost() {
        return manaCost;
    }

    /**
     * The mana value of the card.
     *
     * @return The mana value of the card.
     */
    public Integer getManaValue() {
        return manaValue;
    }

    /**
     * The name of the card. Cards with multiple faces, like "Split" and "Meld"
     * cards are given a delimiter of //.
     *
     * @return The name of the card.
     */
    public String getName() {
        return name;
    }

    /**
     * The number of the card. Can be prefixed or suffixed with a * or other
     * characters for promotional sets.
     *
     * @return The number of the card.
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * A list of card UUID's to original printings of the card if this card is
     * somehow different from its original, such as rebalanced cards.
     *
     * @return A list of card UUID's to original printings of the card if this
     * card is somehow different from its original, such as rebalanced cards.
     */
    public List<UUID> getOriginalPrintings() {
        return originalPrintings;
    }

    /**
     * The original release date in ISO 8601 format for a promotional card
     * printed outside of a cycle window, such as Secret Lair Drop promotions.
     *
     * @return The original release date in ISO 8601 format for a promotional
     * card printed outside of a cycle window, such as Secret Lair Drop
     * promotions.
     */
    public Date getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    /**
     * The text on the card as originally printed.
     *
     * @return The text on the card as originally printed.
     */
    public String getOriginalText() {
        return originalText;
    }

    /**
     * The type of the card as originally printed. Includes any supertypes and
     * subtypes.
     *
     * @return The type of the card as originally printed.
     */
    public String getOriginalType() {
        return originalType;
    }


    /**
     * A list of card UUID's to this card's counterparts, such as transformed or
     * melded faces.
     *
     * @return A list of card UUID's to this card's counterparts, such as
     * transformed or melded faces.
     */
    public List<UUID> getOtherFaceIds() {
        return otherFaceIds;
    }

    /**
     * The power of the card.
     *
     * @return The power of the card.
     */
    public String getPower() {
        return power;
    }

    /**
     * A list of set printing codes the card was printed in, formatted in
     * uppercase.
     *
     * @return A list of set printing codes the card was printed in, formatted
     * in uppercase.
     */
    public List<String> getPrintings() {
        return printings;
    }

    /**
     * A list of promotional types for a card.
     *
     * @return A list of promotional types for a card.
     */
    public EnumSet<PromoType> getPromoTypes() {
        return promoTypes;
    }

    /**
     * Links that navigate to websites where the card can be purchased. See the
     * Purchase Urls Data Model.
     *
     * @return Links that navigate to websites where the card can be purchased.
     */
    public PurchaseUrlsJson getPurchaseUrls() {
        return purchaseUrls;
    }

    /**
     * The card printing rarity. Rarity bonus relates to cards that have an
     * alternate availability in booster packs, while special relates to
     * "Timeshifted" cards.
     *
     * @return The card printing rarity.
     */
    public Rarity getRarity() {
        return rarity;
    }

    /**
     * A list of card UUID's to printings that are rebalanced versions of this
     * card.
     *
     * @return A list of card UUID's to printings that are rebalanced versions
     * of this card.
     */
    public List<UUID> getRebalancedPrintings() {
        return rebalancedPrintings;
    }

    /**
     * The official rulings of the card. See the Rulings Data Model.
     *
     * @return The official rulings of the card.
     */
    public List<Ruling> getRulings() {
        return rulings;
    }

    /**
     * The security stamp printed on the card.
     *
     * @return The security stamp printed on the card.
     */
    public SecurityStamp getSecurityStamp() {
        return securityStamp;
    }

    /**
     * The set printing code that the card is from.
     *
     * @return The set printing code that the card is from.
     */
    public String getSetCode() {
        return setCode;
    }

    /**
     * The identifier of the card side. Used on cards with multiple faces on the
     * same card.
     *
     * @return The identifier of the card side.
     */
    public Side getSide() {
        return side;
    }

    /**
     * The name of the signature on the card.
     *
     * @return The name of the signature on the card.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * A list of card subtypes found after em-dash.
     *
     * @return A list of card subtypes found after em-dash.
     */
    public List<String> getSubtypes() {
        return subtypes;
    }

    /**
     * A list of card supertypes found before em-dash.
     *
     * @return A list of card supertypes found before em-dash.
     */
    public List<String> getSupertypes() {
        return supertypes;
    }

    /**
     * The rules text of the card.
     *
     * @return The rules text of the card.
     */
    public String getText() {
        return text;
    }

    /**
     * The toughness of the card.
     *
     * @return The toughness of the card.
     */
    public String getToughness() {
        return toughness;
    }

    /**
     * Type of the card as visible, including any supertypes and subtypes.
     *
     * @return Type of the card as visible, including any supertypes and
     * subtypes.
     */
    public String getType() {
        return type;
    }

    /**
     * A list of all card types of the card, including Un‑sets and gameplay
     * variants.
     *
     * @return A list of all card types of the card, including Un‑sets and
     * gameplay variants.
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * The universal unique identifier (v5) generated by MTGJSON. Each entry is
     * unique.
     *
     * @return The universal unique identifier (v5) generated by MTGJSON.
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * A list of card UUID's of this card with alternate printings in the same
     * set. Excludes Un‑sets.
     *
     * @return A list of card UUID's of this card with alternate printings in
     * the same set.
     */
    public List<UUID> getVariations() {
        return variations;
    }

    /**
     * The name of the watermark on the card.
     *
     * @return The name of the watermark on the card.
     */
    public String getWatermark() {
        return watermark;
    }

    public String getProcessedText() {
        return text != null ? getText().replaceAll(getName(), "~")
                .replaceAll("\\([^)]*\\)", "") : "";
    }
}
