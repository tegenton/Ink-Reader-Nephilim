package tegenton.card.json;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetJson {
    private int baseSetSize;
    private String block;

    public int getBaseSetSize() {
        return baseSetSize;
    }

    public String getBlock() {
        return block;
    }
}
