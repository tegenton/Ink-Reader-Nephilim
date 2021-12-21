package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetModifier;

import java.util.Optional;

public class PossessiveState extends State {
    private static final PossessiveState INSTANCE = new PossessiveState();

    public static PossessiveState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> TargetModifier.POSSESSIVE;
            default -> null;
        });
    }
}
