package tegenton.card.parse;

import tegenton.card.parse.token.TokenStream;

public final class RulesTextParser {
    private RulesTextParser() {
    }

    /**
     * Generate abilities from rules text.
     *
     * @param s Rules text
     */
    public static String fromString(final String s) {
        return s.toUpperCase();
    }
}
