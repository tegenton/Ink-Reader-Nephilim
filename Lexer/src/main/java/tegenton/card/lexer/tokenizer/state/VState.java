package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.type.CounterType;

import java.util.HashMap;
import java.util.Map;

public class VState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    VState(final String name) {
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
            MAP.put("VA", TransitionFactory.mapOf('L'));
            MAP.put("VAL", TransitionFactory.mapOf('U'));
            MAP.put("VALU", TransitionFactory.mapOf('E'));
            MAP.put("VALUE", TransitionFactory.mapOf(ObjectAttribute.VALUE));
            MAP.put("VI", TransitionFactory.mapOf('G', 'T'));
            MAP.put("VIG", TransitionFactory.mapOf('I'));
            MAP.put("VIGI", TransitionFactory.mapOf('L'));
            MAP.put("VIGIL", TransitionFactory.mapOf('A'));
            MAP.put("VIGILA", TransitionFactory.mapOf('N'));
            MAP.put("VIGILAN", TransitionFactory.mapOf('C'));
            MAP.put("VIGILANC", TransitionFactory.mapOf('E'));
            MAP.put("VIGILANCE", TransitionFactory.mapOf(Keyword.VIGILANCE));
            MAP.put("VIT", TransitionFactory.mapOf('A'));
            MAP.put("VITA", TransitionFactory.mapOf('L'));
            MAP.put("VITAL", TransitionFactory.mapOf('I'));
            MAP.put("VITALI", TransitionFactory.mapOf('T'));
            MAP.put("VITALIT", TransitionFactory.mapOf('Y'));
            MAP.put("VITALITY", TransitionFactory.mapOf(CounterType.VITALITY));
        }
        return MAP;
    }
}
