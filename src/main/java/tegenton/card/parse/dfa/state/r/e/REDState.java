package tegenton.card.parse.dfa.state.r.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.r.REState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.ColorWord;

import java.util.Optional;

public class REDState extends REState {
    private static final REDState INSTANCE = new REDState();

    public static REDState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> ColorWord.RED;
            default -> null;
        });
    }
}
