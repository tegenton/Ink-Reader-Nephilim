package tegenton.card.lexer.dfa.state.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexer.dfa.state.t.o.TOPState;
import tegenton.card.lexer.dfa.state.t.o.TOUState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.game.source.target.player.PlayerAttribute;

import java.util.Optional;

public class TOState extends TState {
    private static final TOState INSTANCE = new TOState();

    /**
     * @return Singleton instance.
     */
    public static TOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'K' -> new SuffixSubstring("KEN", ObjectNoun.TOKEN);
            case 'P' -> TOPState.state();
            case 'T' -> new SuffixSubstring("TAL", PlayerAttribute.TOTAL);
            case 'U' -> TOUState.state();
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
            case '\0', ' ' -> Preposition.TO;
            default -> null;
        });
    }
}
