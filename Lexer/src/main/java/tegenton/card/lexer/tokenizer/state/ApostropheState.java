package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.game.target.TargetModifier;

import java.util.HashMap;
import java.util.Map;

public class ApostropheState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    ApostropheState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of V states.
     *
     * @return Map of V state transitions.
     */
    @Override
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("'S", TransitionFactory.toWord(TargetModifier.POSSESSIVE));
        }
        return MAP;
    }
}
