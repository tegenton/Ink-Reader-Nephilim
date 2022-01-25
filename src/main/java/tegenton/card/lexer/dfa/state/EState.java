package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.e.EAState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexer.dfa.state.e.EIState;
import tegenton.card.lexer.dfa.state.e.ELState;
import tegenton.card.lexer.dfa.state.e.ENState;
import tegenton.card.lexer.dfa.state.e.ERState;
import tegenton.card.lexer.dfa.state.e.EXState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;

import java.util.Optional;

public class EState extends State {
    private static final EState INSTANCE = new EState();

    /**
     * @return Singleton instance.
     */
    public static EState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> EAState.state();
            case 'D' -> EDState.state();
            case 'F' -> new SuffixSubstring("FFECT", GameNoun.EFFECT);
            case 'I' -> EIState.state();
            case 'L' -> ELState.state();
            case 'N' -> ENState.state();
            case 'Q' -> new SuffixSubstring("QUAL", Adjective.EQUAL);
            case 'R' -> ERState.state();
            case 'V' -> new SuffixSubstring("VENLY", Adverb.EVENLY);
            case 'X' -> EXState.state();
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
