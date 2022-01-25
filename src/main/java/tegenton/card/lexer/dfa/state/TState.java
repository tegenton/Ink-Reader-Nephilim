package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.t.TAState;
import tegenton.card.lexer.dfa.state.t.TEState;
import tegenton.card.lexer.dfa.state.t.THState;
import tegenton.card.lexer.dfa.state.t.TOState;
import tegenton.card.lexer.dfa.state.t.TWState;
import tegenton.card.lexer.dfa.state.t.i.m.TIMEState;
import tegenton.card.lexer.dfa.state.t.u.r.TURNState;
import tegenton.card.lexer.dfa.state.t.y.p.TYPEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Tap;

import java.util.Optional;

public class TState extends tegenton.card.lexer.dfa.state.State {
    private static final TState INSTANCE = new TState();

    /**
     * @return Singleton instance.
     */
    public static TState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> TAState.state();
            case 'E' -> TEState.state();
            case 'H' -> THState.state();
            case 'I' -> new InfixSubstring("IM", 'E', TIMEState::state);
            case 'O' -> TOState.state();
            case 'R' -> new SuffixSubstring("RAMPLE", Keyword.TRAMPLE);
            case 'U' -> new InfixSubstring("UR", 'N', TURNState::state);
            case 'W' -> TWState.state();
            case 'Y' -> new InfixSubstring("YP", 'E', TYPEState::state);
            case '}' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '}' -> Tap.T;
            default -> null;
        });
    }
}
