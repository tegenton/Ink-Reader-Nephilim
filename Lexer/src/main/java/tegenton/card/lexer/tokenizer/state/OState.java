package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.game.target.player.PlayerNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.HashMap;
import java.util.Map;

public class OState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    OState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of O states.
     *
     * @return Map of O state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {

            MAP.put("OF", TransitionFactory.mapOf(Preposition.OF));
            MAP.put("ON",
                    TransitionFactory.mapOf(Preposition.ON, 'C', 'E', 'L'));
            MAP.put("ONC", TransitionFactory.mapOf('E'));
            MAP.put("ONCE", TransitionFactory.mapOf(Adverb.ONCE));
            MAP.put("ONE", TransitionFactory.mapOf(EnglishNumber.ONE));
            MAP.put("ONL", TransitionFactory.mapOf('Y'));
            MAP.put("ONLY", TransitionFactory.mapOf(Adverb.ONLY));
            MAP.put("OP", TransitionFactory.mapOf('P'));
            MAP.put("OPP", TransitionFactory.mapOf('O'));
            MAP.put("OPPO", TransitionFactory.mapOf('N'));
            MAP.put("OPPON", TransitionFactory.mapOf('E'));
            MAP.put("OPPONE", TransitionFactory.mapOf('N'));
            MAP.put("OPPONEN", TransitionFactory.mapOf('T'));
            MAP.put("OPPONENT", TransitionFactory.mapOf(PlayerNoun.OPPONENT));
            MAP.put("OR", TransitionFactory.mapOf(Conjunction.OR, 'D'));
            MAP.put("ORD", TransitionFactory.mapOf('E'));
            MAP.put("ORDE", TransitionFactory.mapOf('R'));
            MAP.put("ORDER", TransitionFactory.mapOf(Noun.ORDER));
            MAP.put("OT", TransitionFactory.mapOf('H'));
            MAP.put("OTH", TransitionFactory.mapOf('E'));
            MAP.put("OTHE", TransitionFactory.mapOf('R'));
            MAP.put("OTHER", TransitionFactory.mapOf(Determiner.OTHER));
            MAP.put("OU", TransitionFactory.mapOf('T'));
            MAP.put("OUT", TransitionFactory.mapOf(Preposition.OUT));
            MAP.put("OV", TransitionFactory.mapOf('E'));
            MAP.put("OVE", TransitionFactory.mapOf('R'));
            MAP.put("OVER", TransitionFactory.mapOf(Adverb.OVER));
            MAP.put("OW", TransitionFactory.mapOf('N'));
            MAP.put("OWN", TransitionFactory.mapOf(PlayerVerb.OWN));

        }
        return MAP;
    }
}
