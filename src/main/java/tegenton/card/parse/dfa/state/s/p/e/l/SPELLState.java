package tegenton.card.parse.dfa.state.s.p.e.l;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.s.p.e.SPELState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;

import java.util.Optional;

public class SPELLState extends SPELState {
    private static final SPELLState INSTANCE = new SPELLState();

    public static SPELLState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', ',', '\0', '.', ' ' -> ObjectNoun.SPELL;
            default -> null;
        });
    }
}