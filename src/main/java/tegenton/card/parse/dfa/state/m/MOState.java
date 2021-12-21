package tegenton.card.parse.dfa.state.m;

import tegenton.card.parse.dfa.state.MState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.o.MORState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.LandType;

import java.util.Optional;

public class MOState extends MState {
    private static final MOState INSTANCE = new MOState();

    public static MOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> MORState.state();
            case 'U' -> new SuffixSubstring("UNTAIN", LandType.MOUNTAIN);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
