package tegenton.card.lexer.dfa.state.i;

import tegenton.card.lexer.dfa.state.IState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.i.s.l.a.n.ISLANDState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class ISState extends IState {
    private static final ISState INSTANCE = new ISState();

    /**
     * @return Singleton instance.
     */
    public static ISState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> new InfixSubstring("LAN", 'D', ISLANDState::state);
            case 'N' -> new SuffixSubstring("N\u2019T", Adverb.NOT);
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
            case 'N', '\0', ' ' -> ObjectVerb.IS;
            default -> null;
        });
    }
}
