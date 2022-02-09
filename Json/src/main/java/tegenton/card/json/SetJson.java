package tegenton.card.json;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

enum SetType {
    core
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetJson {
    @JsonProperty(required = true)
    private int baseSetSize;
    private String block;
    @JsonProperty(required = true)
    private String code;
    private String codeV3;
    private boolean isForeignOnly;
    @JsonProperty(required = true)
    private boolean isFoilOnly;
    private boolean isNonFoilOnly;
    @JsonProperty(required = true)
    private boolean isOnlineOnly;
    private boolean isPaperOnly;
    private boolean isPartialPreview;
    @JsonProperty(required = true)
    private String keyruneCode;
    private int mcmId;
    private int mcmIdExtras;
    private String mcmName;
    private String mtgoCode;
    @JsonProperty(required = true)
    private String name;
    private String parentCode;
    @JsonProperty(required = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private int tcgplayerGroupId;
    @JsonProperty(required = true)
    private int totalSetSize;
    private TranslationJson translations;
    @JsonProperty(required = true)
    private SetType type;

    public int getBaseSetSize() {
        return baseSetSize;
    }

    public String getBlock() {
        return block;
    }

    public String getCode() {
        return code;
    }

    public String getCodeV3() {
        return codeV3;
    }

    public boolean getIsForeignOnly() {
        return isForeignOnly;
    }

    public boolean getIsFoilOnly() {
        return isFoilOnly;
    }

    public boolean getIsNonFoilOnly() {
        return isNonFoilOnly;
    }

    public boolean getIsOnlineOnly() {
        return isOnlineOnly;
    }

    public boolean getIsPaperOnly() {
        return isPaperOnly;
    }

    public boolean getIsPartialPreview() {
        return isPartialPreview;
    }

    public String getKeyruneCode() {
        return keyruneCode;
    }

    public int getMcmId() {
        return mcmId;
    }

    public int getMcmIdExtras() {
        return mcmIdExtras;
    }

    public String getMcmName() {
        return mcmName;
    }

    public String getMtgoCode() {
        return mtgoCode;
    }

    public String getName() {
        return name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getTcgplayerGroupId() {
        return tcgplayerGroupId;
    }

    public int getTotalSetSize() {
        return totalSetSize;
    }

    public SetType getType() {
        return type;
    }

    public TranslationJson getTranslations() {
        return translations;
    }
}
