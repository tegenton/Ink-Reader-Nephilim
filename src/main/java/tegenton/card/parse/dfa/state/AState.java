package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.a.*;
import tegenton.card.parse.dfa.state.a.c.t.i.ACTIVState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.turn.Chronology;
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
            case 'C' -> new InfixSubstring("CTI", 'V', ACTIVState::state);
            case 'D' -> ADState.state();
            case 'F' -> new SuffixSubstring("FTER", Chronology.AFTER);
            case 'L' -> ALState.state();
            case 'M' -> AMState.state();
            case 'N' -> ANState.state();
            case 'R' -> new SuffixSubstring("RTIFACT", CardType.ARTIFACT);
            case 'S' -> ASState.state();
            case 'T' -> ATState.state();
            case 'U' -> new SuffixSubstring("URA", EnchantmentType.AURA);
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Determiner.A;
            default -> null;
        });
    }
}
