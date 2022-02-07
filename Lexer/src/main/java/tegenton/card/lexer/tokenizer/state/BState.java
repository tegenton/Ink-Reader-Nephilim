package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Chronology;
import tegenton.card.lexicon.game.turn.Phase;
import tegenton.card.lexicon.game.type.SuperType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BState extends State {
    private static final Map<String, List<Transition>> MAP = new HashMap<>();

    BState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of B states.
     *
     * @return Map of B state transitions.
     */
    protected Map<String, List<Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("BA", TransitionFactory.listOf('C', 'N', 'S', 'T'));
            MAP.put("BAC", TransitionFactory.listOf('K'));
            MAP.put("BACK", TransitionFactory.toWord(Adverb.BACK));
            TransitionFactory.sequence(MAP, "BAN", "DING");
            MAP.put("BANDING", TransitionFactory.toWord(Keyword.BANDING));
            TransitionFactory.sequence(MAP, "BAS", "IC");
            MAP.put("BASIC", TransitionFactory.toWord(SuperType.BASIC));
            TransitionFactory.sequence(MAP, "BAT", "TLEFIELD");
            MAP.put("BATTLEFIELD", TransitionFactory.toWord(Zone.BATTLEFIELD));
            MAP.put("BE",
                    TransitionFactory.listOf(GameVerb.BE, 'C', 'E', 'F', 'G',
                            'Y'));
            TransitionFactory.sequence(MAP, "BEC", "OME");
            MAP.put("BECOME", TransitionFactory.toWord(ObjectVerb.BECOME));
            MAP.put("BEE", List.of(new Transition('N', GameVerb.BE)));
            MAP.put("BEEN", TransitionFactory.toWord(Morpheme.ED));
            TransitionFactory.sequence(MAP, "BEF", "ORE");
            MAP.put("BEFORE", TransitionFactory.toWord(Chronology.BEFORE));
            TransitionFactory.sequence(MAP, "BEG", "IN");
            MAP.put("BEGIN", TransitionFactory.listOf(PlayerVerb.BEGIN, 'N'));
            TransitionFactory.sequence(MAP, "BEGINN", "ING");
            MAP.put("BEGINNING", TransitionFactory.toWord(Phase.BEGINNING));
            TransitionFactory.sequence(MAP, "BEY", "OND");
            MAP.put("BEYOND", TransitionFactory.toWord(Preposition.BEYOND));
        }
        return MAP;
    }
}
