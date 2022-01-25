package tegenton.card.lexer.dfa.state.y.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.PossessiveState;
import tegenton.card.lexer.dfa.state.YState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerNoun;

import java.util.Optional;

public class YOUState extends YState {
    private static final YOUState INSTANCE = new YOUState();

    /**
     * @return Singleton instance.
     */
    public static YOUState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> PossessiveState.state();
            case '\u2019' -> AState.state();
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'R', '\u2019', '\0', '.', ' ' -> PlayerNoun.YOU;
            default -> null;
        });
    }
}
