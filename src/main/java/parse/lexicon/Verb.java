package parse.lexicon;

import java.util.Optional;

public enum Verb implements Word {
    draw,
    create;

    public static Optional<Verb> fromString(String s) {
        for (Verb type : Verb.values()) {
            if (type.getWord().equalsIgnoreCase(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getWord() {
        return this.name();
    }
}
