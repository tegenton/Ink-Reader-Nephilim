package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.m.MOState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.player.PlayerVerb;
import java.util.Optional;

public class MState extends State {
    private static final MState INSTANCE = new MState();

    public static MState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new StateSequence("AY", PlayerVerb.MAY);
            case 'O' -> MOState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
