package tegenton.card.lexer.dfa.state.p.l;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.p.PLState;
import tegenton.card.lexer.dfa.state.p.l.a.PLAYState;
import tegenton.card.lexer.dfa.state.p.l.a.n.e.s.w.a.l.k.e.PLANESWALKERState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.card.CardName;
import tegenton.card.lexicon.game.type.LandType;

import java.util.Optional;

public class PLAState extends PLState {
    private static final PLAState INSTANCE = new PLAState();

    /**
     * @return Singleton instance.
     */
    public static PLAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'G' -> new SuffixSubstring("GUE", CardName.PLAGUE);
            case 'I' -> new SuffixSubstring("INS", LandType.PLAINS);
            case 'N' -> new InfixSubstring("NESWALKE",
                    'R',
                    PLANESWALKERState::state);
            case 'Y' -> PLAYState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
