package tegenton.card.parse.dfa.state.e.a.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class EACHState extends State {
    private static final EACHState instance = new EACHState();

    public static EACHState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from EACHState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Determiner.EACH);
            default -> Optional.empty();
        };
    }
}
