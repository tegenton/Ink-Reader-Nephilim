package tegenton.card.parse.lexicon;

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

    @Override
    public String getWord() {
        return names.get(0);
    }
}
