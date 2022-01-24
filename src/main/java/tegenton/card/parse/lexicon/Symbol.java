package tegenton.card.parse.lexicon;

public enum Symbol implements Word {
    BULLET("\u2022"),
    CLOSEQUOTE("\u201D"),
    COMMA(","),
    COLON(":"),
    DASH("\u2014"),
    LBRACKET("{"),
    HYPHEN("-"),
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
    public String getWord() {
        return name;
    }
}
