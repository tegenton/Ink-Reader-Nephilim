package tegenton.card.json.model;

import java.util.Date;
import java.util.Objects;

public class Ruling {
    private Date date;
    private String text;

    public Ruling() {
    }

    public Ruling(Date date, String text) {
        this.date = date;
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return date.toString() + ": " + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ruling ruling = (Ruling) o;
        return Objects.equals(date, ruling.date) && Objects.equals(text,
                ruling.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, text);
    }
}
