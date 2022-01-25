package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.g.GAState;
import tegenton.card.lexer.dfa.state.g.GOState;
import tegenton.card.lexer.dfa.state.g.GRState;
import tegenton.card.lexer.dfa.state.g.e.GETState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Color;

import java.util.Optional;

public class GState extends State {
    private static final GState INSTANCE = new GState();

    /**
     * @return Singleton instance.
     */
    public static GState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> GAState.state();
            case 'E' -> new InfixSubstring("E", 'T', GETState::state);
            case 'O' -> GOState.state();
            case 'R' -> GRState.state();
            case '}', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '}', '\0', ' ' -> Color.G;
            default -> null;
        });
    }
}
