package tegenton.card.parse.dfa.state.i;

import tegenton.card.parse.dfa.state.IState;
import tegenton.card.parse.dfa.state.PossessiveState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class ITState extends IState {
    private static final ITState INSTANCE = new ITState();

    public static ITState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> PossessiveState.state();
            case '\u2019' -> new SuffixSubstring("\u2019S", ObjectVerb.IS);
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\u2019', ',', '\0', '.', ' ' -> ObjectNoun.IT;
            default -> null;
        });
    }
}
