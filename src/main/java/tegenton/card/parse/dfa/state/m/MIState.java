package tegenton.card.parse.dfa.state.m;

import tegenton.card.parse.dfa.state.MState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CounterName;

import java.util.Optional;

public class MIState extends MState {
    private static final MIState INSTANCE = new MIState();

    public static MIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NUS", Preposition.MINUS);
            case 'R' -> new SuffixSubstring("RE", CounterName.MIRE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
