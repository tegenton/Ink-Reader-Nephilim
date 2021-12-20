package tegenton.card.parse.dfa.state.e.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.ENState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.turn.Step;

import java.util.Optional;

public class ENDState extends ENState {
    private static final ENDState INSTANCE = new ENDState();

    public static ENDState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Step.END;
            default -> null;
        });
    }
}
