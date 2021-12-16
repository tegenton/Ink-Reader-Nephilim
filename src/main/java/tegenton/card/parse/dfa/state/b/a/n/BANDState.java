package tegenton.card.parse.dfa.state.b.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.b.a.BANState;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class BANDState extends BANState {
    private static final BANDState INSTANCE = new BANDState();

    public static BANDState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'I' -> new INGMorpheme(Keyword.BANDING);
            default -> throw new IllegalStateException(
                    "Cannot transition from BANDState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
