package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.DState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.o.DONState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
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
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new InfixSubstring("E", 'S', DOState::state);
            case 'I' -> new INGMorpheme();
            case 'N' -> DONState.state();
            case 'W' -> new SuffixSubstring("WN", Particle.DOWN);
            case ',', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'I', 'N', ',', '\0', ' ' -> SourceVerb.DO;
            default -> null;
        });
    }
}
