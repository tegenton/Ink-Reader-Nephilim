package tegenton.card.lexer.dfa.state.c;

import tegenton.card.lexer.dfa.state.CState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.o.COMState;
import tegenton.card.lexer.dfa.state.c.o.CONState;
import tegenton.card.lexer.dfa.state.c.o.COUState;
import tegenton.card.lexer.dfa.state.c.o.l.o.COLORState;
import tegenton.card.lexer.dfa.state.c.o.s.COSTState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.game.type.CounterName;

import java.util.Optional;

public class COState extends CState {
    private static final COState INSTANCE = new COState();

    /**
     * @return Singleton instance.
     */
    public static COState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> new InfixSubstring("LO", 'R', COLORState::state);
            case 'M' -> COMState.state();
            case 'N' -> CONState.state();
            case 'P' -> new SuffixSubstring("PY", ObjectNoun.COPY);
            case 'R' -> new SuffixSubstring("RPSE", CounterName.CORPSE);
            case 'S' -> new InfixSubstring("S", 'T', COSTState::state);
            case 'U' -> COUState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
