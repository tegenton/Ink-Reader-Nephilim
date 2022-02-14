package tegenton.card.json.model;

import java.util.Objects;

/**
 * The Identifiers Data Model describes a list of identifiers associated to a
 * card.
 */
public class IdentifiersJson {
    private String cardKingdomId;
    private String mcmId;
    private String mtgjsonV4Id;
    private String mtgoId;
    private String multiverseId;
    private String scryfallId;
    private String scryfallIllustrationId;
    private String scryfallOracleId;
    private String tcgplayerProductId;

    /**
     * Default constructor for Jackson unmarshalling.
     */
    public IdentifiersJson() {

    }

    IdentifiersJson(final String s) {
        tcgplayerProductId = s;
    }

    IdentifiersJson(String ckID, String mcmID, String v4ID, String mvID,
                    String scryID, String scryIllID, String scryOrID,
                    String tcgpID) {
        cardKingdomId = ckID;
        mcmId = mcmID;
        mtgjsonV4Id = v4ID;
        multiverseId = mvID;
        scryfallId = scryID;
        scryfallIllustrationId = scryIllID;
        scryfallOracleId = scryOrID;
        tcgplayerProductId = tcgpID;
    }

    public String getCardKingdomId() {
        return cardKingdomId;
    }

    public String getMcmId() {
        return mcmId;
    }

    public String getMtgjsonV4Id() {
        return mtgjsonV4Id;
    }

    public String getMtgoId() {
        return mtgoId;
    }

    public String getMultiverseId() {
        return multiverseId;
    }

    public String getScryfallId() {
        return scryfallId;
    }

    public String getScryfallIllustrationId() {
        return scryfallIllustrationId;
    }

    public String getScryfallOracleId() {
        return scryfallOracleId;
    }

    /**
     * The TCGplayer card identifier.
     *
     * @return The TCGplayer card identifier.
     */
    public String getTcgplayerProductId() {
        return tcgplayerProductId;
    }

    /**
     * Compare two IdentifiersJson objects.
     *
     * @param o An object.
     * @return Equality of the product IDs.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentifiersJson that = (IdentifiersJson) o;
        return Objects.equals(cardKingdomId,
                that.cardKingdomId) && Objects.equals(mcmId,
                that.mcmId) && Objects.equals(mtgjsonV4Id,
                that.mtgjsonV4Id) && Objects.equals(mtgoId,
                that.mtgoId) && Objects.equals(multiverseId,
                that.multiverseId) && Objects.equals(scryfallId,
                that.scryfallId) && Objects.equals(scryfallIllustrationId,
                that.scryfallIllustrationId) && Objects.equals(scryfallOracleId,
                that.scryfallOracleId) && Objects.equals(tcgplayerProductId,
                that.tcgplayerProductId);
    }

    /**
     * Hash collection of identifiers.
     *
     * @return Hash of all IDs.
     */
    @Override
    public int hashCode() {
        return Objects.hash(cardKingdomId, mcmId, mtgjsonV4Id, mtgoId,
                multiverseId, scryfallId, scryfallIllustrationId,
                scryfallOracleId, tcgplayerProductId);
    }
}
