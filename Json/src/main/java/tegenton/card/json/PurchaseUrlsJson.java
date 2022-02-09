package tegenton.card.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseUrlsJson {

    private String tcgplayer;

    public PurchaseUrlsJson() {
    }

    public PurchaseUrlsJson(String tcg) {
        tcgplayer = tcg;
    }

    public String getTcgplayer() {
        return tcgplayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseUrlsJson that = (PurchaseUrlsJson) o;
        return Objects.equals(tcgplayer, that.tcgplayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tcgplayer);
    }
}
