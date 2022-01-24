package tegenton.card.parse.dfa.state.s;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Pronoun;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.SourceNoun;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class SOState extends SState {
    private static final SOState INSTANCE = new SOState();

    /**
     * @return Singleton instance.
     */
    public static SOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'M' -> new SuffixSubstring("ME", Determiner.SOME);
            case 'R' -> new SuffixSubstring("RCERY", CardType.SORCERY);
            case 'U' -> new SuffixSubstring("URCE", SourceNoun.SOURCE);
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case ',', '\0', '.', ' ' -> Pronoun.SO;
            default -> null;
        });
    }
}
