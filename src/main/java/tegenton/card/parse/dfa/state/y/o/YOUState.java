package tegenton.card.parse.dfa.state.y.o;

import tegenton.card.parse.dfa.state.PossessiveState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.YState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerNoun;

import java.util.Optional;

public class YOUState extends YState {
    private static final YOUState INSTANCE = new YOUState();

    public static YOUState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> PossessiveState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'R', '\0', ' ' -> PlayerNoun.YOU;
            default -> null;
        });
    }
}
