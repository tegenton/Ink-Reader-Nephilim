package tegenton.card.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

/**
 * The Identifiers Data Model describes a list of identifiers associated to a
 * card.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentifiersJson {
    private String tcgplayerProductId;

    /**
     * Default constructor for Jackson unmarshalling.
     */
    public IdentifiersJson() {

    }

    IdentifiersJson(final String s) {
        tcgplayerProductId = s;
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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdentifiersJson that = (IdentifiersJson) o;
        return Objects.equals(tcgplayerProductId, that.tcgplayerProductId);
    }

    /**
     * Hash of IDs.
     *
     * @return Hash of IDs.
     */
    @Override
    public int hashCode() {
        return Objects.hash(tcgplayerProductId);
    }
}
