package tegenton.card.parse.dfa.state.c.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.COState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.turn.Phase;

import java.util.Optional;

public class COMState extends COState {
    private static final COMState INSTANCE = new COMState();

    public static COMState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> new SuffixSubstring("BAT", Phase.COMBAT);
            case 'P' -> new SuffixSubstring("PLETELY", Adverb.COMPLETELY);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
