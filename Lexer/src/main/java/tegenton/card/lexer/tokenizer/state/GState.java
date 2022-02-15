package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.TargetVerb;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.type.CreatureType;

import java.util.HashMap;
import java.util.Map;

public class GState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    GState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of G states.
     *
     * @return Map of G state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("GA", TransitionFactory.mapOf('I', 'M'));
            MAP.put("GAI", TransitionFactory.mapOf('N'));
            MAP.put("GAIN", TransitionFactory.toVerb(TargetVerb.GAIN));
            MAP.put("GAM", TransitionFactory.mapOf('E'));
            MAP.put("GAME", TransitionFactory.mapOf(GameNoun.GAME));
            MAP.put("GE", TransitionFactory.mapOf('T'));
            MAP.put("GET", TransitionFactory.toVerb(ObjectVerb.GET));
            MAP.put("GO", TransitionFactory.mapOf('B', 'L'));
            MAP.put("GOB", TransitionFactory.mapOf('L'));
            MAP.put("GOBL", TransitionFactory.mapOf('I'));
            MAP.put("GOBLI", TransitionFactory.mapOf('N'));
            MAP.put("GOBLIN", TransitionFactory.mapOf(CreatureType.GOBLIN));
            MAP.put("GOL", TransitionFactory.mapOf('E'));
            MAP.put("GOLE", TransitionFactory.mapOf('M'));
            MAP.put("GOLEM", TransitionFactory.mapOf(CreatureType.GOLEM));
            MAP.put("GR", TransitionFactory.mapOf('A', 'E'));
            MAP.put("GRA", TransitionFactory.mapOf('V'));
            MAP.put("GRAV", TransitionFactory.mapOf('E'));
            MAP.put("GRAVE", TransitionFactory.mapOf('Y'));
            MAP.put("GRAVEY", TransitionFactory.mapOf('A'));
            MAP.put("GRAVEYA", TransitionFactory.mapOf('R'));
            MAP.put("GRAVEYAR", TransitionFactory.mapOf('D'));
            MAP.put("GRAVEYARD", TransitionFactory.mapOf(Zone.GRAVEYARD));
            MAP.put("GRE", TransitionFactory.mapOf('A', 'E'));
            MAP.put("GREA", TransitionFactory.mapOf('T'));
            MAP.put("GREAT", TransitionFactory.mapOf('E'));
            MAP.put("GREATE", TransitionFactory.mapOf('R'));
            MAP.put("GREATER", TransitionFactory.mapOf(Comparative.GREATER));
            MAP.put("GREE", TransitionFactory.mapOf('N'));
            MAP.put("GREEN", TransitionFactory.mapOf(ColorWord.GREEN));
        }
        return MAP;
    }
}
