package tegenton.card.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SealedProductJson {
    @JsonProperty(required = true)
    private IdentifiersJson identifiers;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private PurchaseUrlsJson purchaseUrls;
    @JsonProperty(required = true)
    private Date releaseDate;
    @JsonProperty(required = true)
    private UUID uuid;

    public SealedProductJson() {
    }

    public SealedProductJson(String id) {
        this.uuid = UUID.fromString(id);
    }

    public String getName() {
        return name;
    }

    public PurchaseUrlsJson getPurchaseUrls() {
        return purchaseUrls;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SealedProductJson that = (SealedProductJson) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return name;
    }

    public IdentifiersJson getIdentifiers() {
        return identifiers;
    }
}
