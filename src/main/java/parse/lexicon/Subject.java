package parse.lexicon;

import java.util.Optional;

public enum Subject implements Word {
    cards;

    public static Optional<Subject> fromString(String s) {
        for (Subject type : Subject.values()) {
            if (type.getWord().equalsIgnoreCase(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getWord() {
        return name();
    }
}
