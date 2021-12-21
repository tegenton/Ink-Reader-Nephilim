package tegenton.card.parse.dfa.state.l;

import tegenton.card.parse.dfa.state.LState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.o.s.LOSEState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.SubordinateConjunction;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class LOState extends LState {
    private static final LOState INSTANCE = new LOState();

    public static LOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NG", SubordinateConjunction.LONG);
            case 'O' -> new SuffixSubstring("OK", PlayerVerb.LOOK);
            case 'S' -> new InfixSubstring("S", 'E', LOSEState::state);
            case 'Y' -> new SuffixSubstring("YALTY", ObjectAttribute.LOYALTY);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
