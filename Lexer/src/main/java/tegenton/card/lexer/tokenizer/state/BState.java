package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Chronology;
import tegenton.card.lexicon.game.turn.Phase;
import tegenton.card.lexicon.game.type.SuperType;

import java.util.HashMap;
import java.util.Map;

public class BState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    BState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of B states.
     *
     * @return Map of B state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("BA", TransitionFactory.mapOf('C', 'N', 'S', 'T'));
            MAP.put("BAC", TransitionFactory.mapOf('K'));
            MAP.put("BACK", TransitionFactory.mapOf(Adverb.BACK));
            TransitionFactory.sequence(MAP, "BAN", "DING");
            MAP.put("BANDING", TransitionFactory.mapOf(Keyword.BANDING));
            TransitionFactory.sequence(MAP, "BAS", "IC");
            MAP.put("BASIC", TransitionFactory.mapOf(SuperType.BASIC));
            TransitionFactory.sequence(MAP, "BAT", "TLEFIELD");
            MAP.put("BATTLEFIELD", TransitionFactory.mapOf(Zone.BATTLEFIELD));
            MAP.put("BE",
                    TransitionFactory.mapOf(GameVerb.BE, 'C', 'E', 'F', 'G',
                            'Y'));
            TransitionFactory.sequence(MAP, "BEC", "OME");
            MAP.put("BECOME", TransitionFactory.mapOf(ObjectVerb.BECOME));
            MAP.put("BEE", Map.of('N', new Transition('N', GameVerb.BE)));
            MAP.put("BEEN", TransitionFactory.mapOf(Morpheme.ED));
            TransitionFactory.sequence(MAP, "BEF", "ORE");
            MAP.put("BEFORE", TransitionFactory.mapOf(Chronology.BEFORE));
            TransitionFactory.sequence(MAP, "BEG", "IN");
            MAP.put("BEGIN", TransitionFactory.mapOf(PlayerVerb.BEGIN, 'N'));
            TransitionFactory.sequence(MAP, "BEGINN", "ING");
            MAP.put("BEGINNING", TransitionFactory.mapOf(Phase.BEGINNING));
            TransitionFactory.sequence(MAP, "BEY", "OND");
            MAP.put("BEYOND", TransitionFactory.mapOf(Preposition.BEYOND));
            MAP.put("BL", TransitionFactory.mapOf('A', 'O', 'U'));
            TransitionFactory.sequence(MAP, "BLA", "CK");
            MAP.put("BLACK", TransitionFactory.mapOf(ColorWord.BLACK));
            TransitionFactory.sequence(MAP, "BLO", "CK");
            MAP.put("BLOCK", TransitionFactory.mapOf(ObjectVerb.BLOCK));
            MAP.put("BLOCKE",
                    Map.of('R', new Transition('R', ObjectVerb.BLOCK, "ER")));
            MAP.put("BLU", TransitionFactory.mapOf('E'));
            MAP.put("BLUE", TransitionFactory.mapOf(ColorWord.BLUE));
            MAP.put("BU", TransitionFactory.mapOf('T'));
            MAP.put("BUT", TransitionFactory.mapOf(SubordinateConjunction.BUT));
            MAP.put("BY", TransitionFactory.mapOf(Preposition.BY));
        }
        return MAP;
    }
}
