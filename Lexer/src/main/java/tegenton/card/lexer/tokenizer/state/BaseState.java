package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.Tap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseState extends State {
    private static final Map<String, List<Transition>> MAP = new HashMap<>();

    BaseState(final String s) {
        super(s);
    }

    /**
     * Lazily load singleton map of base states, which begin from an empty
     * string.
     *
     * @return Map of base state transitions.
     */
    protected Map<String, List<Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("",
                    TransitionFactory.listOf('A', 'B', 'C', 'D', 'E', 'F', 'P',
                            'T'));
            MAP.put("A",
                    TransitionFactory.listOf(Determiner.A, 'B', 'C', 'D', 'F',
                            'L', 'M', 'N', 'R', 'S', 'T', 'U'));
            MAP.put("B",
                    TransitionFactory.listOf(ManaSymbol.B, 'A', 'E', 'L', 'U',
                            'Y'));
            MAP.put("C",
                    TransitionFactory.listOf(ManaSymbol.C, 'A', 'H', 'O', 'R'));
            MAP.put("D", TransitionFactory.listOf('R'));
            MAP.put("E", TransitionFactory.listOf('R'));
            MAP.put("F", TransitionFactory.listOf('O'));
            MAP.put("P", TransitionFactory.listOf('L'));
            MAP.put("S", List.of(new Transition('.', Morpheme.S, ".")));
            MAP.put("T",
                    TransitionFactory.listOf(Tap.T, 'A', 'E', 'H', 'I', 'O',
                            'R', 'W', 'U', 'Y'));
            MAP.put(".", TransitionFactory.toWord(Symbol.PERIOD));
            MAP.put(" ", List.of(new Transition('\0', Symbol.SPACE, "")));
        }
        return MAP;
    }
}
