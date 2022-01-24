package tegenton.card.parse.dfa.state.d.e.f.e.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.DEState;
import tegenton.card.parse.dfa.substring.morpheme.ERMorpheme;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerAdjective;

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
