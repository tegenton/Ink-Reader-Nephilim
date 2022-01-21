package tegenton.card.parse.dfa.state.c.r.e.a.t.u.r;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.c.r.e.a.CREATState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetModifier;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class CREATUREState extends CREATState {
    private static final CREATUREState INSTANCE = new CREATUREState();

    public static CREATUREState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\u2019' -> new SuffixSubstring("\u2019S", TargetModifier.POSSESSIVE);
            case ',', '\n', '.', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\u2019', ',', '\n', '.', '\0', ' ' -> CardType.CREATURE;
            default -> null;
        });
    }
}
