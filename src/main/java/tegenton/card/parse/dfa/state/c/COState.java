package tegenton.card.parse.dfa.state.c;

import tegenton.card.parse.dfa.state.CState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.o.COMState;
import tegenton.card.parse.dfa.state.c.o.CONState;
import tegenton.card.parse.dfa.state.c.o.COUState;
import tegenton.card.parse.dfa.state.c.o.s.COSTState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.parse.lexicon.game.type.CounterName;

import java.util.Optional;

public class COState extends CState {
    private static final COState INSTANCE = new COState();

    public static COState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> new SuffixSubstring("LOR", GameNoun.COLOR);
            case 'M' -> COMState.state();
            case 'N' -> CONState.state();
            case 'P' -> new SuffixSubstring("PY", ObjectNoun.COPY);
            case 'R' -> new SuffixSubstring("RPSE", CounterName.CORPSE);
            case 'S' -> new InfixSubstring("S", 'T', COSTState::state);
            case 'U' -> COUState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
