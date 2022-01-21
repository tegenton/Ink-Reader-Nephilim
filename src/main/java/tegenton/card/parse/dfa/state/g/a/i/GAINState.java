package tegenton.card.parse.dfa.state.g.a.i;

import tegenton.card.parse.dfa.state.GState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetVerb;

import java.util.Optional;

public class GAINState extends GState {
    private static final GAINState INSTANCE = new GAINState();

    public static GAINState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> TargetVerb.GAIN;
            default -> null;
        });
    }
}
