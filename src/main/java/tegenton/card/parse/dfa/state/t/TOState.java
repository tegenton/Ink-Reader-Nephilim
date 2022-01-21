package tegenton.card.parse.dfa.state.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.dfa.state.t.o.TOPState;
import tegenton.card.parse.dfa.state.t.o.TOUState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerAttribute;

import java.util.Optional;

public class TOState extends TState {
    private static final TOState INSTANCE = new TOState();

    public static TOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'K' -> new SuffixSubstring("KEN", ObjectNoun.TOKEN);
            case 'P' -> TOPState.state();
            case 'T' -> new SuffixSubstring("TAL", PlayerAttribute.TOTAL);
            case 'U' -> TOUState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Preposition.TO;
            default -> null;
        });
    }
}
