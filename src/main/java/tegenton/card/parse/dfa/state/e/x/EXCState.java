package tegenton.card.parse.dfa.state.e.x;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.EXState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.SubordinateConjunction;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class EXCState extends EXState {
    private static final EXCState INSTANCE = new EXCState();

    public static EXCState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new SuffixSubstring("EPT", SubordinateConjunction.EXCEPT);
            case 'H' -> new SuffixSubstring("HANGE", PlayerVerb.EXCHANGE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
