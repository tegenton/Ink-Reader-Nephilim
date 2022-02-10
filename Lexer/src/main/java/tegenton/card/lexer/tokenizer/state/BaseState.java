package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.Tap;

import java.util.HashMap;
import java.util.Map;

public class BaseState extends State {
    private static final Map<String, Map<Character, Transition>> MAP = new HashMap<>();

    BaseState(final String s) {
        super(s);
    }

    /**
     * Lazily load singleton map of base states, which begin from an empty
     * string.
     *
     * @return Map of base state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("",
                    TransitionFactory.mapOf('A', 'B', 'C', 'D', 'E', 'F', 'P',
                            'T'));
            MAP.put("A",
                    TransitionFactory.mapOf(Determiner.A, 'B', 'C', 'D', 'F',
                            'L', 'M', 'N', 'R', 'S', 'T', 'U'));
            MAP.put("B",
                    TransitionFactory.mapOf(ManaSymbol.B, 'A', 'E', 'L', 'U',
                            'Y'));
            MAP.put("C",
                    TransitionFactory.mapOf(ManaSymbol.C, 'A', 'H', 'O', 'R'));
            MAP.put("D", TransitionFactory.mapOf('A', 'E', 'R'));
            MAP.put("E", TransitionFactory.mapOf('R'));
            MAP.put("F", TransitionFactory.mapOf('O'));
            MAP.put("P", TransitionFactory.mapOf('L'));
            MAP.put("S", Map.of('.', new Transition('.', Morpheme.S, ".")));
            MAP.put("T",
                    TransitionFactory.mapOf(Tap.T, 'A', 'E', 'H', 'I', 'O', 'R',
                            'W', 'U', 'Y'));
            MAP.put(".", TransitionFactory.toWord(Symbol.PERIOD));
            MAP.put(" ", Map.of('\0', new Transition('\0', Symbol.SPACE, "")));
        }
        return MAP;
    }
}
