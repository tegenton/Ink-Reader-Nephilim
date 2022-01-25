package tegenton.card.lexer.dfa.state.d.e.f.e.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.d.DEState;
import tegenton.card.lexer.dfa.substring.morpheme.ERMorpheme;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.source.target.player.PlayerAdjective;

import java.util.Optional;

public class DEFENDState extends DEState {
    private static final DEFENDState INSTANCE = new DEFENDState();

    /**
     * @return Singleton instance.
     */
    public static DEFENDState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new ERMorpheme(Keyword.DEFENDER);
            case 'I' -> new INGMorpheme(PlayerAdjective.DEFENDING);
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
