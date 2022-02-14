package tegenton.card.lexicon;

/**
 * Non-alphanumeric characters that appear on cards.
 */
public enum Symbol implements Word {
    BULLET("\u2022"),
    CLOSEQUOTE("\u201D"),
    COLON(":"),
    COMMA(","),
    DASH("\u2014"),
    HYPHEN("-"),
    LBRACKET("{"),
    NEWLINE("\n"),
    OPENQUOTE("\u201C"),
    PERIOD("."),
    PLUS("+"),
    RBRACKET("}"),
    SEMICOLON(";"),
    SLASH("/"),
    SPACE(" "),
    TILDE("~");

    private final String name;

    Symbol(final String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
