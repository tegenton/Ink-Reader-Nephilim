package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.game.type.CreatureType;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.HashMap;
import java.util.Map;

public class ZState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    ZState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of Z states.
     *
     * @return Map of Z state transitions.
     */
    @Override
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("ZE", TransitionFactory.mapOf('R'));
            MAP.put("ZER", TransitionFactory.mapOf('O'));
            MAP.put("ZERO", TransitionFactory.mapOf(EnglishNumber.ZERO));
            MAP.put("ZO", TransitionFactory.mapOf('M'));
            MAP.put("ZOM", TransitionFactory.mapOf('B'));
            MAP.put("ZOMB", TransitionFactory.mapOf('I'));
            MAP.put("ZOMBI", TransitionFactory.mapOf('E'));
            MAP.put("ZOMBIE", TransitionFactory.mapOf(CreatureType.ZOMBIE));
        }
        return MAP;
    }
}
