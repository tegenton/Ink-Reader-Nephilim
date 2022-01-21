package tegenton.card.parse.dfa.state.t.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.TOState;
import tegenton.card.parse.dfa.state.t.o.u.c.TOUCHState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute;

import java.util.Optional;

public class TOUState extends TOState {
    private static final TOUState INSTANCE = new TOUState();

    public static TOUState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> new InfixSubstring("C", 'H', TOUCHState::state);
            case 'G' -> new SuffixSubstring("GHNESS", ObjectAttribute.TOUGHNESS);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
