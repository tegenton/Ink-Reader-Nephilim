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

enum SecurityStamp {}

@JsonIgnoreProperties(ignoreUnknown = true)
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
    private EnumSet<FrameEffect> frameEffects;
    @JsonProperty(required = true)
    private String frameVersion;
    private Integer hand;
    private Boolean hasAlternativeDeckLimit;
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
    private EnumSet<PromoType> promoTypes;
    @JsonProperty(required = true)
    private PurchaseUrlsJson purchaseUrls;
    @JsonProperty(required = true)
    private Rarity rarity;
    private List<UUID> rebalancedPrintings;
    private List<Ruling> rulings;
    private SecurityStamp securityStamp;
    private String signature;
    private String text;
    @JsonProperty(required = true)
    private UUID uuid;
    @JsonProperty(required = true)
    private List<UUID> variations;
    private String watermark;

    public String getArtist() {
        return artist;
    }

    public String getAsciiName() {
        return asciiName;
    }

    public EnumSet<Printing> getAvailability() {
        return availability;
    }

    public BorderColor getBorderColor() {
        return borderColor;
    }

    public List<String> getCardParts() {
        return cardParts;
    }

    public EnumSet<Color> getColorIdentity() {
        return colorIdentity;
    }

    public EnumSet<Color> getColorIndicator() {
        return colorIndicator;
    }

    public EnumSet<Color> getColors() {
        return colors;
    }

    public Integer getEdhrecRank() {
        return edhrecRank;
    }

    public String getFaceFlavorName() {
        return faceFlavorName;
    }

    public Integer getFaceManaValue() {
        return faceManaValue;
    }

    public String getFaceName() {
        return faceName;
    }

    public EnumSet<Finish> getFinishes() {
        return finishes;
    }

    public String getFlavorName() {
        return flavorName;
    }

    public String getFlavorText() {
        return flavorText;
    }

    // TODO: foreign data

    public EnumSet<FrameEffect> getFrameEffects() {
        return frameEffects;
    }

    public String getFrameVersion() {
        return frameVersion;
    }

    public Integer getHand() {
        return hand;
    }

    public Boolean getHasAlternativeDeckLimit() {
        return hasAlternativeDeckLimit;
    }

    public Boolean getHasContentWarning() {
        return hasContentWarning;
    }

    public IdentifiersJson getIdentifiers() {
        return identifiers;
    }

    public Boolean getIsAlternative() {
        return isAlternative;
    }

    public Boolean getIsFullArt() {
        return isFullArt;
    }

    public Boolean getIsFunny() {
        return isFunny;
    }

    public Boolean getIsOnlineOnly() {
        return isOnlineOnly;
    }

    public Boolean getIsOversized() {
        return isOversized;
    }

    public Boolean getIsPromo() {
        return isPromo;
    }

    public Boolean getIsRebalanced() {
        return isRebalanced;
    }

    public Boolean getIsReprint() {
        return isReprint;
    }

    public Boolean getIsReserved() {
        return isReserved;
    }

    public Boolean getIsStarter() {
        return isStarter;
    }

    public Boolean getIsStorySpotlight() {
        return isStorySpotlight;
    }

    public Boolean getIsTextless() {
        return isTextless;
    }

    public Boolean getIsTimeshifted() {
        return isTimeshifted;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public Layout getLayout() {
        return layout;
    }

    public LeadershipSkillsJson getLeadershipSkills() {
        return leadershipSkills;
    }

    public LegalitiesJson getLegalities() {
        return legalities;
    }

    public Integer getLife() {
        return life;
    }

    public Integer getLoyalty() {
        return loyalty;
    }

    // TODO: mana cost

    public Integer getManaValue() {
        return manaValue;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public List<UUID> getOriginalPrintings() {
        return originalPrintings;
    }

    public Date getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    public String getOriginalText() {
        return originalText;
    }

    public String getOriginalType() {
        return originalType;
    }


    public List<UUID> getOtherFaceIds() {
        return otherFaceIds;
    }

    // TODO: power
    // TODO: printings
    public EnumSet<PromoType> getPromoTypes() {
        return promoTypes;
    }

    public PurchaseUrlsJson getPurchaseUrls() {
        return purchaseUrls;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public List<UUID> getRebalancedPrintings() {
        return rebalancedPrintings;
    }

    public List<Ruling> getRulings() {
        return rulings;
    }

    public SecurityStamp getSecurityStamp() {
        return securityStamp;
    }

    // TODO: set code
    // TODO: side
    public String getSignature() {
        return signature;
    }
    // TODO: subtypes
    // TODO: supertypes

    public String getText() {
        return text;
    }

    // TODO: toughness
    // TODO: type
    // TODO: types

    public UUID getUuid() {
        return uuid;
    }

    public List<UUID> getVariations() {
        return variations;
    }

    public String getWatermark() {
        return watermark;
    }
}
