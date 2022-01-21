package tegenton.card.parse.dfa.state.p.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.p.PLState;
import tegenton.card.parse.dfa.state.p.l.a.PLAYState;
import tegenton.card.parse.dfa.state.p.la.n.e.s.w.a.l.k.e.PLANESWALKERState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.card.CardName;
import tegenton.card.parse.lexicon.game.type.LandType;

import java.util.Optional;

public class PLAState extends PLState {
    private static final PLAState INSTANCE = new PLAState();

    public static PLAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'G' -> new SuffixSubstring("GUE", CardName.PLAGUE);
            case 'I' -> new SuffixSubstring("INS", LandType.PLAINS);
            case 'N' -> new InfixSubstring("NESWALKE", 'R', PLANESWALKERState::state);
            case 'Y' -> PLAYState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
