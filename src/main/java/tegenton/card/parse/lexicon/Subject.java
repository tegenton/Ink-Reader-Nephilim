package tegenton.card.parse.lexicon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Subject implements Word {
    card("card", "cards");

    private final List<String> names;

    Subject() {
        names = new ArrayList<>();
        names.add(name());
    }

    Subject(String... names) {
        this.names = Arrays.asList(names);
    }

    public static Optional<Subject> fromString(String s) {
        s = s.toLowerCase();
        for (Subject type : Subject.values()) {
            if (type.names.contains(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getWord() {
        return names.get(0);
    }
}
