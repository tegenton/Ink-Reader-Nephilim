package tegenton.card.parse.dfa.state.d.r.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.player.PlayerVerb;
import java.util.Optional;

public class DRAWState extends State {
    private static final DRAWState instance = new DRAWState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from DRAWState on " + c);
        }
    }

    @Override
    public Optional<Word> produce(char c) {
        if (c == '\0') {
            return Optional.of(PlayerVerb.DRAW);
        }
        return Optional.empty();
    }
}