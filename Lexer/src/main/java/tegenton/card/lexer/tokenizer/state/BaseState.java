package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.Tap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseState extends State {
    private static final Map<String, List<Transition>> MAP = new HashMap<>();

    public BaseState(String s) {
        super(s);
    }

    protected Map<String, List<Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("",
                    TransitionFactory.listOf('A', 'B', 'C', 'D', 'E', 'F', 'P',
                            'T'));
            MAP.put("A", List.of(new Transition('\0', Determiner.A, "")));
            MAP.put("B", TransitionFactory.listOf('E'));
            MAP.put("C", TransitionFactory.listOf('A'));
            MAP.put("D", TransitionFactory.listOf('R'));
            MAP.put("E", TransitionFactory.listOf('R'));
            MAP.put("F", TransitionFactory.listOf('O'));
            MAP.put("P", TransitionFactory.listOf('L'));
            MAP.put("S", List.of(new Transition('.', Morpheme.S, ".")));
            MAP.put("T", List.of(new Transition('A'), new Transition('E'),
                    new Transition('H'), new Transition('I'),
                    new Transition('\0', Tap.T, "")));
            MAP.put(".", List.of(new Transition('\0', Symbol.PERIOD, "")));
            MAP.put(" ", List.of(new Transition('\0', Symbol.SPACE, "")));
        }
        return MAP;
    }
}
