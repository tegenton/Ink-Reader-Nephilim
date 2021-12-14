package tegenton.card.parse.lexicon;

public enum Symbol implements Word {
    APOSTROPHE("’"),
    BULLET("•"),
    CLOSEQUOTE("”"),
    COMMA(","),
    COLON(":"),
    DASH("—"),
    LBRACKET("{"),
    NEWLINE("\n"),
    OPENQUOTE("“"),
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
