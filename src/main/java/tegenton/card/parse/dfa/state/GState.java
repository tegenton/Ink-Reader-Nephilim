package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.g.GAState;
import tegenton.card.parse.dfa.state.g.GOState;
import tegenton.card.parse.dfa.state.g.GRState;
import tegenton.card.parse.dfa.state.g.e.GETState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Color;

import java.util.Optional;

public class GState extends State {
    private static final GState INSTANCE = new GState();

    public static GState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> GAState.state();
            case 'E' -> new InfixSubstring("E", 'T', GETState::state);
            case 'O' -> GOState.state();
            case 'R' -> GRState.state();
            case '}', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '}', '\0', ' ' -> Color.G;
            default -> null;
        });
    }
}
