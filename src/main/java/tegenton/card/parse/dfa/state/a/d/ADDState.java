package tegenton.card.parse.dfa.state.a.d;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.ADState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class ADDState extends ADState {
    private static final ADDState INSTANCE = new ADDState();

    public static ADDState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("ITION", Preposition.ADDITION);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> PlayerVerb.ADD;
            default -> null;
        });
    }
}
