package tegenton.card.parse.token.lexicon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static Subject fromString(String s) {
        s = s.toLowerCase();
        for (Subject type : Subject.values()) {
            if (type.names.contains(s)) {
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
