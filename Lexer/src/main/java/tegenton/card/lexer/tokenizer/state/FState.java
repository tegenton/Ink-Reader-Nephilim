package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.LandType;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.HashMap;
import java.util.Map;

public class FState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    FState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of F states.
     *
     * @return Map of F state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("FA", TransitionFactory.mapOf('C'));
            MAP.put("FAC", TransitionFactory.mapOf('E'));
            MAP.put("FACE", TransitionFactory.mapOf(ObjectAttribute.FACE));
            MAP.put("FE", TransitionFactory.mapOf('A', 'W'));
            MAP.put("FEA", TransitionFactory.mapOf('R'));
            MAP.put("FEAR", TransitionFactory.mapOf(Keyword.FEAR));
            MAP.put("FEW", TransitionFactory.mapOf('E'));
            MAP.put("FEWE", TransitionFactory.mapOf('S'));
            MAP.put("FEWES", TransitionFactory.mapOf('T'));
            MAP.put("FEWEST", TransitionFactory.mapOf(Noun.FEWEST));
            MAP.put("FI", TransitionFactory.mapOf('F', 'N', 'R', 'V'));
            MAP.put("FIF", TransitionFactory.mapOf('T'));
            MAP.put("FIFT", TransitionFactory.mapOf('E'));
            MAP.put("FIFTE", TransitionFactory.mapOf('E'));
            MAP.put("FIFTEE", TransitionFactory.mapOf('N'));
            MAP.put("FIFTEEN", TransitionFactory.mapOf(EnglishNumber.FIFTEEN));
            MAP.put("FIN", TransitionFactory.mapOf('I'));
            MAP.put("FINI", TransitionFactory.mapOf('S'));
            MAP.put("FINIS", TransitionFactory.mapOf('H'));
            MAP.put("FINISH", TransitionFactory.mapOf(GameVerb.FINISH));
            MAP.put("FIR", TransitionFactory.mapOf('S'));
            MAP.put("FIRS", TransitionFactory.mapOf('T'));
            MAP.put("FIRST", TransitionFactory.mapOf(Adjective.FIRST));
            MAP.put("FIV", TransitionFactory.mapOf('E'));
            MAP.put("FIVE", TransitionFactory.mapOf(EnglishNumber.FIVE));
            MAP.put("FL", TransitionFactory.mapOf('I', 'Y'));
            MAP.put("FLI", TransitionFactory.mapOf('P'));
            MAP.put("FLIP", TransitionFactory.mapOf(PlayerVerb.FLIP));
            MAP.put("FLY", TransitionFactory.mapOf('I'));
            MAP.put("FLYI", TransitionFactory.mapOf('N'));
            MAP.put("FLYIN", TransitionFactory.mapOf('G'));
            MAP.put("FLYING", TransitionFactory.mapOf(Keyword.FLYING));
            MAP.put("FO", TransitionFactory.mapOf('O', 'R', 'U'));
            MAP.put("FOO", TransitionFactory.mapOf('T'));
            MAP.put("FOOT", TransitionFactory.mapOf(Noun.FOOT));
            MAP.put("FOR", TransitionFactory.mapOf(Preposition.FOR, 'E'));
            MAP.put("FORE", TransitionFactory.mapOf('S'));
            MAP.put("FORES", TransitionFactory.mapOf('T'));
            MAP.put("FOREST", TransitionFactory.mapOf(LandType.FOREST));
            MAP.put("FOU", TransitionFactory.mapOf('R'));
            MAP.put("FOUR", TransitionFactory.mapOf(EnglishNumber.FOUR));
            MAP.put("FR", TransitionFactory.mapOf('O'));
            MAP.put("FRO", TransitionFactory.mapOf('M'));
            MAP.put("FROM", TransitionFactory.mapOf(Preposition.FROM));
        }
        return MAP;
    }
}
