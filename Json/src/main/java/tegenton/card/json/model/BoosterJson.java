package tegenton.card.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

class Sheet {
    private Boolean balanceColors;
    private Map<UUID, Integer> cards;
    private Boolean foil;
    private Integer totalWeight;

    public Boolean getBalanceColors() {
        return balanceColors;
    }

    public Map<UUID, Integer> getCards() {
        return cards;
    }

    public Boolean getFoil() {
        return foil;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Sheet sheet = (Sheet) o;
        return Objects.equals(balanceColors, sheet.balanceColors)
                && Objects.equals(cards, sheet.cards) && Objects.equals(foil,
                sheet.foil) && Objects.equals(totalWeight, sheet.totalWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceColors, cards, foil, totalWeight);
    }

    @Override
    public String toString() {
        return "Sheet{" + "balanceColors=" + balanceColors + ", cards=" + cards
                + ", foil=" + foil + ", totalWeight=" + totalWeight + '}';
    }
}

class BoosterConfig {
    private Map<String, Integer> contents;
    private int weight;

    BoosterConfig() {
    }

    BoosterConfig(final Map<String, Integer> map, final int i) {
        this.contents = map;
        this.weight = i;
    }

    public Map<String, Integer> getContents() {
        return contents;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BoosterConfig that = (BoosterConfig) o;
        return weight == that.weight && Objects.equals(contents, that.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contents, weight);
    }

    @Override
    public String toString() {
        return "BoosterConfig{" + "contents=" + contents + ", weight=" + weight
                + '}';
    }
}

class BoosterTypeConfig {
    private List<BoosterConfig> boosters;
    private Integer boostersTotalWeight;
    private Map<String, Sheet> sheets;

    public List<BoosterConfig> getBoosters() {
        return boosters;
    }

    public Integer getBoostersTotalWeight() {
        return boostersTotalWeight;
    }

    public Map<String, Sheet> getSheets() {
        return sheets;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BoosterTypeConfig that = (BoosterTypeConfig) o;
        return Objects.equals(boosters, that.boosters) && Objects.equals(
                boostersTotalWeight, that.boostersTotalWeight)
                && Objects.equals(sheets, that.sheets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boosters, boostersTotalWeight, sheets);
    }
}

public class BoosterJson {
    @JsonProperty("default")
    private BoosterTypeConfig draft;

    /**
     * Possible configurations in a traditional booster pack.
     *
     * @return Possible configurations in a traditional booster pack.
     */
    public BoosterTypeConfig getDefault() {
        return draft;
    }

    /**
     * Compare two instance of BoosterJson.
     *
     * @param o Object to compare.
     * @return Are the two instances identical?
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BoosterJson that = (BoosterJson) o;
        return Objects.equals(draft, that.draft);
    }

    /**
     * Hash of boosters.
     *
     * @return Hash of boosters.
     */
    @Override
    public int hashCode() {
        return Objects.hash(draft);
    }
}
