package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.p.PLState;
import tegenton.card.parse.dfa.state.p.PRState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.object.ObjectAttribute;
import tegenton.card.parse.lexicon.source.target.object.ObjectNoun;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public class PState extends State {
    private static final PState INSTANCE = new PState();

    public static PState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("AY", PlayerVerb.PAY);
            case 'E' -> new SuffixSubstring("ERMANENT", ObjectNoun.PERMANENT);
            case 'O' -> new SuffixSubstring("OWER", ObjectAttribute.POWER);
            case 'L' -> PLState.state();
            case 'R' -> PRState.state();
            case 'U' -> new SuffixSubstring("UT", PlayerVerb.PUT);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
