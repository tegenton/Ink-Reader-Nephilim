package tegenton.card.json.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

enum SetType {
    core
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetJson {
    @JsonProperty(required = true)
    private int baseSetSize;
    private String block;
    private BoosterJson booster;
    @JsonProperty(required = true)
    private List<SetCardJson> cards;
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
    private Date releaseDate;
    private List<SealedProductJson> sealedProduct;
    private int tcgplayerGroupId;
    @JsonProperty(required = true)
    private List<TokenCardJson> tokens;
    @JsonProperty(required = true)
    private int totalSetSize;
    @JsonProperty(required = true)
    private TranslationJson translations;
    @JsonProperty(required = true)
    private SetType type;

    /**
     * The number of cards in the set. This will default to totalSetSize if not
     * available. Wizards of the Coast sometimes prints extra cards beyond the
     * set size into promos or supplemental products.
     *
     * @return The number of cards in the set
     */
    public int getBaseSetSize() {
        return baseSetSize;
    }

    /**
     * The number of cards in the set.
     *
     * @return The number of cards in the set.
     */
    public String getBlock() {
        return block;
    }

    /**
     * A breakdown of possibilities and weights of cards in a booster pack. See
     * the Booster abstract model.
     *
     * @return A breakdown of possibilities and weights of cards in a booster
     * pack.
     */
    public BoosterJson getBooster() {
        return booster;
    }

    /**
     * The list of cards in the set. See the Card (Set) Data Model.
     *
     * @return The list of cards in the set.
     */
    public List<SetCardJson> getCards() {
        return cards;
    }

    /**
     * The set code for the set.
     *
     * @return The set code for the set.
     */
    public String getCode() {
        return code;
    }

    /**
     * The alternate set code Wizards of the Coast uses for a select few duel
     * deck sets.
     *
     * @return The alternate set code Wizards of the Coast uses for a select few
     * duel deck sets.
     */
    public String getCodeV3() {
        return codeV3;
    }

    /**
     * If the set is available only outside the United States of America.
     *
     * @return If the set is available only outside the United States of
     * America.
     */
    public boolean getIsForeignOnly() {
        return isForeignOnly;
    }

    /**
     * If the set is only available in foil.
     *
     * @return If the set is only available in foil.
     */
    public boolean getIsFoilOnly() {
        return isFoilOnly;
    }

    /**
     * If the set is only available in non-foil.
     *
     * @return If the set is only available in non-foil.
     */
    public boolean getIsNonFoilOnly() {
        return isNonFoilOnly;
    }

    /**
     * If the set is only available in online game variations.
     *
     * @return If the set is only available in online game variations.
     */
    public boolean getIsOnlineOnly() {
        return isOnlineOnly;
    }

    /**
     * If the set is available only in paper.
     *
     * @return If the set is available only in paper.
     */
    public boolean getIsPaperOnly() {
        return isPaperOnly;
    }

    /**
     * If the set is still in preview (spoiled). Preview sets do not have
     * complete data.
     *
     * @return If the set is still in preview.
     */
    public boolean getIsPartialPreview() {
        return isPartialPreview;
    }

    /**
     * The matching Keyrune code for set image icons.
     *
     * @return The matching Keyrune code for set image icons.
     */
    public String getKeyruneCode() {
        return keyruneCode;
    }

    /**
     * The Magic Card Market set identifier.
     *
     * @return The Magic Card Market set identifier.
     */
    public int getMcmId() {
        return mcmId;
    }

    /**
     * The split Magic Card Market set identifier if a set is printed in two
     * sets. This identifier represents the second set's identifier.
     *
     * @return The split Magic Card Market set identifier if a set is printed in
     * two sets.
     */
    public int getMcmIdExtras() {
        return mcmIdExtras;
    }

    /**
     * The Magic Card Market set name.
     *
     * @return The Magic Card Market set name.
     */
    public String getMcmName() {
        return mcmName;
    }

    /**
     * The set code for the set as it appears on Magic: The Gathering Online.
     *
     * @return The set code for the set as it appears on Magic: The Gathering
     * Online.
     */
    public String getMtgoCode() {
        return mtgoCode;
    }

    /**
     * The name of the set.
     *
     * @return The name of the set.
     */
    public String getName() {
        return name;
    }

    /**
     * The parent set code for set variations like promotions, guild kits, etc.
     *
     * @return The parent set code for set variations like promotions, guild
     * kits, etc.
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * The release date in ISO 8601 format for the set.
     *
     * @return The release date in ISO 8601 format for the set.
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * The sealed product information for the set. See the Sealed Product Data
     * Model.
     *
     * @return The sealed product information for the set.
     */
    public List<SealedProductJson> getSealedProduct() {
        return sealedProduct;
    }

    /**
     * The group identifier of the set on TCGplayer.
     *
     * @return The group identifier of the set on TCGplayer.
     */
    public int getTcgplayerGroupId() {
        return tcgplayerGroupId;
    }

    /**
     * The tokens available to the set. See the Card (Token) Data Model.
     *
     * @return The tokens available to the set.
     */
    public List<TokenCardJson> getTokens() {
        return tokens;
    }

    /**
     * The total number of cards in the set, including promos and related
     * supplemental products.
     *
     * @return The total number of cards in the set, including promos and
     * related supplemental products.
     */
    public int getTotalSetSize() {
        return totalSetSize;
    }

    /**
     * The translated set name by language. See the Translations Data Model.
     *
     * @return The translated set name by language.
     */
    public TranslationJson getTranslations() {
        return translations;
    }

    /**
     * The expansion type of the set.
     *
     * @return The expansion type of the set.
     */
    public SetType getType() {
        return type;
    }
}
