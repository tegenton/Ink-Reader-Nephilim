package tegenton.card.parse.token.lexicon;

import java.util.Optional;

public enum KeywordAction implements Word {
    scry,
    fateseal;

    public static Optional<KeywordAction> fromString(String s) {
        for (KeywordAction type : KeywordAction.values()) {
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
