package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Genitive;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.ObjectVerb;

import java.util.HashMap;
import java.util.Map;

public class HState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    HState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of H states.
     *
     * @return Map of H state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("HA", TransitionFactory.mapOf('L', 'N', 'S', 'V'));
            MAP.put("HAL", TransitionFactory.mapOf('F'));
            MAP.put("HALF", TransitionFactory.mapOf(Genitive.HALF));
            MAP.put("HAN", TransitionFactory.mapOf('D'));
            MAP.put("HAND", TransitionFactory.mapOf(Zone.HAND));
            MAP.put("HAS", TransitionFactory.mapOf(ObjectVerb.HAVE, 'T'));
            MAP.put("HAST", TransitionFactory.mapOf('E'));
            MAP.put("HASTE", TransitionFactory.mapOf(Keyword.HASTE));
            MAP.put("HAV", TransitionFactory.mapOf('E'));
            MAP.get("HAV").put('I', new Transition('I', ObjectVerb.HAVE, "I"));
            MAP.put("HAVE", TransitionFactory.mapOf(ObjectVerb.HAVE));
            MAP.put("HE", TransitionFactory.mapOf('I'));
            MAP.put("HEI", TransitionFactory.mapOf('G'));
            MAP.put("HEIG", TransitionFactory.mapOf('H'));
            MAP.put("HEIGH", TransitionFactory.mapOf('T'));
            MAP.put("HEIGHT", TransitionFactory.mapOf(Noun.HEIGHT));
        }
        return MAP;
    }
}
