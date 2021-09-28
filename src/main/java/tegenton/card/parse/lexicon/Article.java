package tegenton.card.parse.lexicon;

import java.util.Optional;

public enum Article implements Word {
    a,
    an;

    public static Optional<Article> fromString(String s) {
        for (Article type : Article.values()) {
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
