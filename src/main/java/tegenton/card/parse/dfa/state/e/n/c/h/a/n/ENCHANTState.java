package tegenton.card.parse.dfa.state.e.n.c.h.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.n.ENCState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.type.CardType;
import java.util.Optional;

public class ENCHANTState extends ENCState {
    private static final ENCHANTState INSTANCE = new ENCHANTState();

    public static ENCHANTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'M' -> new SuffixSubstring("MENT", CardType.ENCHANTMENT);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Keyword.ENCHANT);
            default -> Optional.empty();
        };
    }
}
