package tegenton.card.parse.token.lexicon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The (grammatical) object of a sentence.
 */
public enum Subject implements Word {
    card("card", "cards");

    private final List<String> names;

    Subject() {
        names = new ArrayList<>();
        names.add(name());
    }

    Subject(final String... listOfNames) {
        this.names = Arrays.asList(listOfNames);
    }

    /**
     * The subject that s represents.
     *
     * @param s string that may contain a subject
     * @return the represented subject or null
     */
    public static Subject fromString(final String s) {
        for (final Subject type : Subject.values()) {
            if (type.names.contains(s.toLowerCase())) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String getWord() {
        return names.get(0);
    }
}
