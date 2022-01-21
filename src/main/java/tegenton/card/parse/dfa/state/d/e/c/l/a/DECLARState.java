package tegenton.card.parse.dfa.state.d.e.c.l.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.DEState;
import tegenton.card.parse.dfa.state.d.e.c.l.a.r.DECLAREState;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class DECLARState extends DEState {
    private static final DECLARState INSTANCE = new DECLARState();

    public static DECLARState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> DECLAREState.state();
            case 'I' -> new INGMorpheme();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', '\0', ' ' -> PlayerVerb.DECLARE;
            default -> null;
        });
    }
}
