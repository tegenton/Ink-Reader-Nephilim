package tegenton.card.parse.dfa.state.u;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.UState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Particle;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.turn.Step;

import java.util.Optional;

public class UPState extends UState {
    private static final UPState INSTANCE = new UPState();

    public static UPState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'K' -> new SuffixSubstring("KEEP", Step.UPKEEP);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Particle.UP;
            default -> null;
        });
    }
}
