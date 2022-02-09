package tegenton.card.json.model;

import java.util.Objects;

/**
 * The Translations Data Model describes the translated data per language as a
 * key.
 */
public class TranslationJson {
    /**
     * Compare two TranslationJson instances.
     *
     * @param o An object.
     * @return Equality of translation data.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    /**
     * Hash.
     *
     * @return Hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
