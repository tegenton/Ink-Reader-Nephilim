package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.a.ABState;
import tegenton.card.parse.dfa.state.a.ALState;
import tegenton.card.parse.dfa.state.a.ANState;
import tegenton.card.parse.dfa.state.a.ATState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.parse.lexicon.game.type.CardType;
import tegenton.card.parse.lexicon.game.type.EnchantmentType;

import java.util.Optional;

public class AState extends State {
    private static final AState INSTANCE = new AState();

    public static State state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> ABState.state();
            case 'C' -> new SuffixSubstring("CTIVATE", PlayerVerb.ACTIVATE);
            case 'D' -> new SuffixSubstring("DD", PlayerVerb.ADD);
            case 'L' -> ALState.state();
            case 'N' -> ANState.state();
            case 'R' -> new SuffixSubstring("RTIFACT", CardType.ARTIFACT);
            case 'T' -> ATState.state();
            case 'U' -> new SuffixSubstring("URA", EnchantmentType.AURA);
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Determiner.A);
            default -> Optional.empty();
        };
    }
}
