package tegenton.card.parse.dfa.state.s.p;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.SPState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.object.ObjectNoun;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public class SPEState extends SPState {
    private static final SPEState INSTANCE = new SPEState();

    public static SPEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> new SuffixSubstring("LL", ObjectNoun.SPELL);
            case 'N' -> new SuffixSubstring("ND", PlayerVerb.SPEND);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
