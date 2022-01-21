package tegenton.card.parse.dfa.state.a.s.s.i.g;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.ASState;
import tegenton.card.parse.dfa.substring.morpheme.EDMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetVerb;

import java.util.Optional;

public class ASSIGNState extends ASState {
    private static final ASSIGNState INSTANCE = new ASSIGNState();

    public static ASSIGNState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new EDMorpheme();
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'E', '\0', ' ' -> TargetVerb.ASSIGN;
            default -> null;
        });
    }
}
