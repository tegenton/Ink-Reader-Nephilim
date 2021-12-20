package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.DState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Particle;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.SourceVerb;

import java.util.Optional;

public class DOState extends DState {
    private static final DOState INSTANCE = new DOState();

    public static DOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'W' -> new SuffixSubstring("WN", Particle.DOWN);
            case ',' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case ',', '\0', ' ' -> SourceVerb.DO;
            default -> null;
        });
    }
}
