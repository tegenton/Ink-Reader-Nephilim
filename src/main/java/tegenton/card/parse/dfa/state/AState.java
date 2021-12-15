package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.a.ALState;
import tegenton.card.parse.dfa.state.a.ANState;
import tegenton.card.parse.dfa.state.a.ATState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.player.PlayerVerb;
import java.util.Optional;

public class AState extends State {
    private static final AState INSTANCE = new AState();

    public static State state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> new StateSequence("BOVE", Preposition.ABOVE);
            case 'C' -> new StateSequence("CTIVATE", PlayerVerb.ACTIVATE);
            case 'D' -> new StateSequence("DD", PlayerVerb.ADD);
            case 'L' -> ALState.state();
            case 'N' -> ANState.state();
            case 'T' -> ATState.state();
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Determiner.A);
            default -> Optional.empty();
        };
    }
}
