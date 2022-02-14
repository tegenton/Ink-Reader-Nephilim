package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.target.player.PlayerAttribute;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Phase;
import tegenton.card.lexicon.game.type.CounterType;
import tegenton.card.lexicon.game.type.CreatureType;
import tegenton.card.lexicon.game.type.LandType;

import java.util.HashMap;
import java.util.Map;

public class MState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    MState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of M states.
     *
     * @return Map of M state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("MA", TransitionFactory.mapOf('I', 'N', 'X', 'Y'));
            MAP.put("MAI", TransitionFactory.mapOf('N'));
            MAP.put("MAIN", TransitionFactory.mapOf(Phase.MAIN));
            MAP.put("MAN", TransitionFactory.mapOf('A', 'Y'));
            MAP.put("MANA", TransitionFactory.mapOf(GameNoun.MANA));
            MAP.put("MANY", TransitionFactory.mapOf(Determiner.MANY));
            MAP.put("MAX", TransitionFactory.mapOf('I'));
            MAP.put("MAXI", TransitionFactory.mapOf('M'));
            MAP.put("MAXIM", TransitionFactory.mapOf('U'));
            MAP.put("MAXIMU", TransitionFactory.mapOf('M'));
            MAP.put("MAXIMUM",
                    TransitionFactory.mapOf(PlayerAttribute.MAXIMUM));
            MAP.put("MAY", TransitionFactory.mapOf(PlayerVerb.MAY));
            MAP.put("ME", TransitionFactory.mapOf('R'));
            MAP.put("MER", TransitionFactory.mapOf('F'));
            MAP.put("MERF", TransitionFactory.mapOf('O'));
            MAP.put("MERFO", TransitionFactory.mapOf('L'));
            MAP.put("MERFOL", TransitionFactory.mapOf('K'));
            MAP.put("MERFOLK", TransitionFactory.mapOf(CreatureType.MERFOLK));
            MAP.put("MI", TransitionFactory.mapOf('N', 'R'));
            MAP.put("MIN", TransitionFactory.mapOf('U'));
            MAP.put("MINU", TransitionFactory.mapOf('S'));
            MAP.put("MINUS", TransitionFactory.mapOf(Preposition.MINUS));
            MAP.put("MIR", TransitionFactory.mapOf('E'));
            MAP.put("MIRE", TransitionFactory.mapOf(CounterType.MIRE));
            MAP.put("MO", TransitionFactory.mapOf('R', 'U'));
            MAP.put("MOR", TransitionFactory.mapOf('E'));
            MAP.put("MORE", TransitionFactory.mapOf(Comparative.MORE));
            MAP.put("MOU", TransitionFactory.mapOf('N'));
            MAP.put("MOUN", TransitionFactory.mapOf('T'));
            MAP.put("MOUNT", TransitionFactory.mapOf('A'));
            MAP.put("MOUNTA", TransitionFactory.mapOf('I'));
            MAP.put("MOUNTAI", TransitionFactory.mapOf('N'));
            MAP.put("MOUNTAIN", TransitionFactory.mapOf(LandType.MOUNTAIN));
        }
        return MAP;
    }
}
