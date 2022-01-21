package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.t.*;
import tegenton.card.parse.dfa.state.t.i.m.TIMEState;
import tegenton.card.parse.dfa.state.t.u.r.TURNState;
import tegenton.card.parse.dfa.state.t.y.p.TYPEState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.game.Tap;

import java.util.Optional;

public class TState extends State {
    private static final TState INSTANCE = new TState();

    public static TState state() {
        return INSTANCE;
    }

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

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '}' -> Tap.T;
            default -> null;
        });
    }
}
