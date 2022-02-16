package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.TargetVerb;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.CardType;

import java.util.HashMap;
import java.util.Map;

public class LState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    LState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of L states.
     *
     * @return Map of L state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("LA", TransitionFactory.mapOf('B', 'N'));
            MAP.put("LAB", TransitionFactory.mapOf('E'));
            MAP.put("LABE", TransitionFactory.mapOf('L'));
            MAP.put("LABEL", TransitionFactory.mapOf(Noun.LABEL));
            MAP.put("LAN", TransitionFactory.mapOf('D'));
            MAP.put("LAND", TransitionFactory.mapOf(CardType.LAND));
            MAP.put("LE", TransitionFactory.mapOf('A', 'F', 'S'));
            MAP.put("LEA", TransitionFactory.mapOf('S', 'V'));
            MAP.put("LEAS", TransitionFactory.mapOf('T'));
            MAP.put("LEAST", TransitionFactory.mapOf(Determiner.LEAST));
            MAP.put("LEAV", TransitionFactory.mapOf('E'));
            MAP.put("LEAVE", TransitionFactory.mapOf(ObjectVerb.LEAVE));
            MAP.put("LEF", TransitionFactory.mapOf('T'));
            MAP.put("LEFT", TransitionFactory.mapOf(Particle.LEFT));
            MAP.put("LES", TransitionFactory.mapOf('S'));
            MAP.put("LESS", TransitionFactory.mapOf(Comparative.LESS));
            MAP.put("LI", TransitionFactory.mapOf('B', 'F', 'K'));
            MAP.put("LIB", TransitionFactory.mapOf('R'));
            MAP.put("LIBR", TransitionFactory.mapOf('A'));
            MAP.put("LIBRA", TransitionFactory.mapOf('R'));
            MAP.put("LIBRAR", TransitionFactory.mapOf('Y'));
            MAP.put("LIBRARY", TransitionFactory.mapOf(Zone.LIBRARY));
            MAP.put("LIF", TransitionFactory.mapOf('E'));
            MAP.put("LIFE", TransitionFactory.mapOf(GameNoun.LIFE));
            MAP.put("LIK", TransitionFactory.mapOf('E'));
            MAP.put("LIKE", TransitionFactory.mapOf('W'));
            MAP.put("LIKEW", TransitionFactory.mapOf('I'));
            MAP.put("LIKEWI", TransitionFactory.mapOf('S'));
            MAP.put("LIKEWIS", TransitionFactory.mapOf('E'));
            MAP.put("LIKEWISE", TransitionFactory.mapOf(Adverb.LIKEWISE));
            MAP.put("LO", TransitionFactory.mapOf('N', 'O', 'S', 'Y'));
            MAP.put("LON", TransitionFactory.mapOf('G'));
            MAP.put("LONG",
                    TransitionFactory.mapOf(SubordinateConjunction.LONG));
            MAP.put("LOO", TransitionFactory.mapOf('K'));
            MAP.put("LOOK", TransitionFactory.mapOf(PlayerVerb.LOOK));
            MAP.put("LOS", TransitionFactory.mapOf('E'));
            MAP.get("LOS").put('T', new Transition('T', TargetVerb.LOSE, "ED"));
            MAP.put("LOSE", TransitionFactory.mapOf(TargetVerb.LOSE));
            MAP.put("LOY", TransitionFactory.mapOf('A'));
            MAP.put("LOYA", TransitionFactory.mapOf('L'));
            MAP.put("LOYAL", TransitionFactory.mapOf('T'));
            MAP.put("LOYALT", TransitionFactory.mapOf('Y'));
            MAP.put("LOYALTY",
                    TransitionFactory.mapOf(ObjectAttribute.LOYALTY));
        }
        return MAP;
    }
}
