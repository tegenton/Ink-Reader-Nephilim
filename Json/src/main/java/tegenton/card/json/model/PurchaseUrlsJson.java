package tegenton.card.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

/**
 * The Purchase Urls Data Model describes url paths to purchase a product from a
 * marketplace.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseUrlsJson {

    private String tcgplayer;

    /**
     * Default constructor for Jackson unmarshalling.
     */
    public PurchaseUrlsJson() {
    }

    PurchaseUrlsJson(final String tcg) {
        tcgplayer = tcg;
    }

    /**
     * The URL to purchase a product on TCGplayer.
     *
     * @return The URL to purchase a product on TCGplayer.
     */
    public String getTcgplayer() {
        return tcgplayer;
    }

    /**
     * Compare the urls of two PurchaseUrlsJson instances.
     *
     * @param o An object.
     * @return Equality of urls.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseUrlsJson that = (PurchaseUrlsJson) o;
        return Objects.equals(tcgplayer, that.tcgplayer);
    }

    /**
     * Hash of urls.
     *
     * @return Hash of urls.
     */
    @Override
    public int hashCode() {
        return Objects.hash(tcgplayer);
    }
}
