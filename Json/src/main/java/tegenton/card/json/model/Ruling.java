package tegenton.card.json.model;

import java.util.Date;
import java.util.Objects;

public class Ruling {
    private Date date;
    private String text;

    Ruling() {
    }

    Ruling(final Date time, final String ruling) {
        this.date = time;
        this.text = ruling;
    }

    /**
     * The release date in ISO 8601 format for the rule.
     *
     * @return The release date in ISO 8601 format for the rule.
     */
    public Date getDate() {
        return date;
    }

    /**
     * The text ruling of the card.
     *
     * @return The text ruling of the card.
     */
    public String getText() {
        return text;
    }

    /**
     * Ruling as a readable string.
     *
     * @return Ruling as a readable string.
     */
    @Override
    public String toString() {
        return date.toString() + ": " + text;
    }

    /**
     * Compare two instances of Ruling.
     *
     * @param o Object to compare
     * @return Are the two rulings identical?
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Ruling ruling = (Ruling) o;
        return Objects.equals(date, ruling.date) && Objects.equals(text,
                ruling.text);
    }

    /**
     * Hash of date and ruling.
     *
     * @return Hash of date and ruling.
     */
    @Override
    public int hashCode() {
        return Objects.hash(date, text);
    }
}
