package tegenton.card.parse.dfa.state.c.o.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.o.CONState;
import tegenton.card.parse.dfa.state.c.o.n.t.CONTRState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerAdverb;

import java.util.Optional;

public class CONTState extends CONState {
    private static final CONTState INSTANCE = new CONTState();

    public static CONTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("INUOUSLY",
                    PlayerAdverb.CONTINUOUSLY);
            case 'R' -> CONTRState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
