package tegenton.card.parse.dfa.state.s.a.c.r.i.f.i.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.dfa.state.s.SAState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class SACRIFICEState extends SAState {
    private static final SACRIFICEState INSTANCE = new SACRIFICEState();

    public static SACRIFICEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', '\0', ' ' -> PlayerVerb.SACRIFICE;
            default -> null;
        });
    }
}
