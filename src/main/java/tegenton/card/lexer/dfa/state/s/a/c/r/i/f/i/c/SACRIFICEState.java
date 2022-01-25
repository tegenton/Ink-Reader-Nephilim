package tegenton.card.lexer.dfa.state.s.a.c.r.i.f.i.c;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexer.dfa.state.s.SAState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class SACRIFICEState extends SAState {
    private static final SACRIFICEState INSTANCE = new SACRIFICEState();

    /**
     * @return Singleton instance.
     */
    public static SACRIFICEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', '\0', ' ' -> PlayerVerb.SACRIFICE;
            default -> null;
        });
    }
}
