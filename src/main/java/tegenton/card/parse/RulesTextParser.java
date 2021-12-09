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
    public static void fromString(final String s) {
        fromTokens(new TokenStream(s));
    }

    private static void fromTokens(final TokenStream tokenStream) {

    }
}
