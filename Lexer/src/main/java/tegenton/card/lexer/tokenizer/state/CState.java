package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CState extends State {
    private static final Map<String, List<Transition>> MAP = new HashMap<>();

    CState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of C states.
     *
     * @return Map of C state transitions.
     */
    protected Map<String, List<Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("CA", TransitionFactory.listOf('N', 'R', 'S', 'U'));
            MAP.put("CAN", TransitionFactory.toWord(TargetAuxiliaryVerb.CAN));
            MAP.put("CAR", TransitionFactory.listOf('D'));
            MAP.put("CARD", List.of(new Transition('S', ObjectNoun.CARD, "S"),
                    new Transition('\0', ObjectNoun.CARD, "")));
            MAP.put("CAS", TransitionFactory.listOf('T'));
            MAP.put("CAST", TransitionFactory.toWord(PlayerVerb.CAST));
            TransitionFactory.sequence(MAP, "CAU", "SE");
            MAP.put("CAUSE", TransitionFactory.toWord(GameVerb.CAUSE));
        }
        return MAP;
    }
}
