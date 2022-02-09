package tegenton.card.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentifiersJson {
    private String tcgplayerProductId;

    public IdentifiersJson() {

    }

    public IdentifiersJson(String s) {
        tcgplayerProductId = s;
    }

    public String getTcgplayerProductId() {
        return tcgplayerProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentifiersJson that = (IdentifiersJson) o;
        return Objects.equals(tcgplayerProductId, that.tcgplayerProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tcgplayerProductId);
    }
}
