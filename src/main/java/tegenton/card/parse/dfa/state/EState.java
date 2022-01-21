package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.e.*;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adjective;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;

import java.util.Optional;

public class EState extends State {
    private static final EState INSTANCE = new EState();

    public static EState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> EAState.state();
            case 'D' -> EDState.state();
            case 'F' -> new SuffixSubstring("FFECT", GameNoun.EFFECT);
            case 'I' -> EIState.state();
            case 'L' -> ELState.state();
            case 'N' -> ENState.state();
            case 'Q' -> new SuffixSubstring("QUAL", Adjective.EQUAL);
            case 'R' -> ERState.state();
            case 'V' -> new SuffixSubstring("VENLY", Adverb.EVENLY);
            case 'X' -> EXState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
