package tegenton.card.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import tegenton.card.lexicon.game.ManaSymbol;

import java.util.EnumSet;
import java.util.List;

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
    private EnumSet<ManaSymbol> colorIdentity;
    private EnumSet<ManaSymbol> colorIndicator;
    @JsonProperty(required = true)
    private EnumSet<ManaSymbol> colors;
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
    private Layout layout;

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

    public EnumSet<ManaSymbol> getColorIdentity() {
        return colorIdentity;
    }

    public EnumSet<ManaSymbol> getColorIndicator() {
        return colorIndicator;
    }

    public EnumSet<ManaSymbol> getColors() {
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

    // TODO: leadership skills
}
