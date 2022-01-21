package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.b.i.l.i.ABILITState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetAdjective;

import java.util.Optional;

public class ABState extends AState {
    private static final ABState INSTANCE = new ABState();

    public static ABState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new InfixSubstring("ILI", 'T', ABILITState::state);
            case 'L' -> new SuffixSubstring("LE", TargetAdjective.ABLE);
            case 'O' -> new SuffixSubstring("OVE", Preposition.ABOVE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
