package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;

import java.util.List;
import java.util.Map;

public class BaseState extends State {
    public BaseState(String s) {
        super(s);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.ofEntries(Map.entry("",
                        Transition.listOf('A', 'B', 'C', 'D', 'E', 'P', 'T')),
                Map.entry("A", List.of(new Transition('\0', Determiner.A, ""))),
                Map.entry("B", Transition.listOf('E')),
                Map.entry("C", Transition.listOf('A')),
                Map.entry("D", Transition.listOf('R')),
                Map.entry("E", Transition.listOf('R')),
                Map.entry("P", Transition.listOf('R')),
                Map.entry("S", List.of(new Transition('.', Morpheme.S, "."))),
                Map.entry("T", Transition.listOf('A', 'H')), Map.entry(".",
                        List.of(new Transition('\0', Symbol.PERIOD, ""))),
                Map.entry(" ",
                        List.of(new Transition('\0', Symbol.SPACE, ""))));
    }
}
