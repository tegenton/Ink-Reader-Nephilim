package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.game.turn.Duration;
import tegenton.card.lexicon.game.turn.Step;

import java.util.HashMap;
import java.util.Map;

public class UState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    UState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of U states.
     *
     * @return Map of U state transitions.
     */
    @Override
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("UN", TransitionFactory.mapOf('D', 'L', 'T'));
            MAP.put("UND", TransitionFactory.mapOf('E'));
            MAP.put("UNDE", TransitionFactory.mapOf('R'));
            MAP.put("UNDER", TransitionFactory.mapOf(Preposition.UNDER));
            MAP.put("UNL", TransitionFactory.mapOf('E'));
            MAP.put("UNLE", TransitionFactory.mapOf('S'));
            MAP.put("UNLES", TransitionFactory.mapOf('S'));
            MAP.put("UNLESS", TransitionFactory.mapOf(Conjunction.UNLESS));
            MAP.put("UNT", TransitionFactory.mapOf('A', 'I'));
            MAP.put("UNTA",
                    Map.of('P', new Transition('P', Adverb.NOT, "TAP")));
            MAP.put("UNTI", TransitionFactory.mapOf('L'));
            MAP.put("UNTIL", TransitionFactory.mapOf(Duration.UNTIL));
            MAP.put("UP", TransitionFactory.mapOf(Particle.UP, 'K'));
            MAP.put("UPK", TransitionFactory.mapOf('E'));
            MAP.put("UPKE", TransitionFactory.mapOf('E'));
            MAP.put("UPKEE", TransitionFactory.mapOf('P'));
            MAP.put("UPKEEP", TransitionFactory.mapOf(Step.UPKEEP));
        }
        return MAP;
    }
}
