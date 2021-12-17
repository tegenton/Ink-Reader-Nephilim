package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.DState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.e.f.e.n.DEFENDState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.SourceVerb;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class DEState extends DState {
    private static final DEState INSTANCE = new DEState();

    public static DEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("AL", SourceVerb.DEAL);
            case 'F' -> new InfixSubstring("FEN", 'D', DEFENDState::state);
            case 'S' -> new SuffixSubstring("STROY", PlayerVerb.DESTROY);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
