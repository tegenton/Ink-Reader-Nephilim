package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Symbol;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class SymbolState extends State {
    private final char symbol;

    private SymbolState(char symbol) {
        this.symbol = symbol;
    }

    public static SymbolState state(char c) {
        return new SymbolState(c);
    }

    @Override
    public State transition(char c) {
        return EmptyState.state().transition(c);
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (symbol) {
            case ':' -> Symbol.COLON;
            case ',' -> Symbol.COMMA;
            case '{' -> Symbol.LBRACKET;
            case '.' -> Symbol.PERIOD;
            case '+' -> Symbol.PLUS;
            case '\n' -> Symbol.NEWLINE;
            case '}' -> Symbol.RBRACKET;
            case ';' -> Symbol.SEMICOLON;
            case '/' -> Symbol.SLASH;
            case ' ' -> Symbol.SPACE;
            case '~' -> Symbol.TILDE;
            default -> null;
        });
    }
}
