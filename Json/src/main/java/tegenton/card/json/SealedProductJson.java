package tegenton.card.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SealedProductJson {
    private String name;
    private Date releaseDate;

    public String getName() {
        return name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return name;
    }
}
