package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Symbol;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public final class SymbolState extends State {
    private final char symbol;

    private SymbolState(final char c) {
        this.symbol = c;
    }

    public static SymbolState state(final char c) {
        return new SymbolState(c);
    }

    @Override
    public State transition(final char c) {
        return EmptyState.state().transition(c);
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (symbol) {
            case '\u2022' -> Symbol.BULLET;
            case '\u201D' -> Symbol.CLOSEQUOTE;
            case ':' -> Symbol.COLON;
            case ',' -> Symbol.COMMA;
            case '\u2014' -> Symbol.DASH;
            case '{' -> Symbol.LBRACKET;
            case '-' -> Symbol.HYPHEN;
            case '\n' -> Symbol.NEWLINE;
            case '\u201C' -> Symbol.OPENQUOTE;
            case '.' -> Symbol.PERIOD;
            case '+' -> Symbol.PLUS;
            case '}' -> Symbol.RBRACKET;
            case ';' -> Symbol.SEMICOLON;
            case '/' -> Symbol.SLASH;
            case ' ' -> Symbol.SPACE;
            case '~' -> Symbol.TILDE;
            default -> null;
        });
    }
}
