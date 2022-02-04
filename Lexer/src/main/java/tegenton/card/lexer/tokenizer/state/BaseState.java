package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.Tap;

import java.util.List;
import java.util.Map;

public class BaseState extends State {
    public BaseState(String s) {
        super(s);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.ofEntries(Map.entry("",
                        TransitionFactory.listOf('A', 'B', 'C', 'D', 'E', 'F', 'P',
                                'T')),
                Map.entry("A", List.of(new Transition('\0', Determiner.A, ""))),
                Map.entry("B", TransitionFactory.listOf('E')),
                Map.entry("C", TransitionFactory.listOf('A')),
                Map.entry("D", TransitionFactory.listOf('R')),
                Map.entry("E", TransitionFactory.listOf('R')),
                Map.entry("F", TransitionFactory.listOf('O')),
                Map.entry("P", TransitionFactory.listOf('L')),
                Map.entry("S", List.of(new Transition('.', Morpheme.S, "."))),
                Map.entry("T", List.of(new Transition('A'), new Transition('E'),
                        new Transition('H'), new Transition('\0', Tap.T, ""))),
                Map.entry(".",
                        List.of(new Transition('\0', Symbol.PERIOD, ""))),
                Map.entry(" ",
                        List.of(new Transition('\0', Symbol.SPACE, ""))));
    }
}
