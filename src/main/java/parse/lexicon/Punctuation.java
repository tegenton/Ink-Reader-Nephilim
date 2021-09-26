package parse.lexicon;

import java.util.Optional;

public enum Punctuation implements Word {
    period("."),
    comma(".");

    private final String name;

    Punctuation(String s) {
        name = s;
    }

    public static Optional<Punctuation> fromString(String s) {
        for (Punctuation type : Punctuation.values()) {
            if (type.getWord().equalsIgnoreCase(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getWord() {
        return name;
    }
}
