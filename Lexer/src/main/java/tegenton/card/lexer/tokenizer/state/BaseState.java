package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.Determiner;

import java.util.List;
import java.util.Map;

public class BaseState extends State {
    public BaseState(String s) {
        super(s);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.of("", Transition.listOf('A', 'B', 'C', 'D', 'E', 'P', 'T'),
                "A", List.of(new Transition('\0', Determiner.A, "")), "B",
                List.of(new Transition('E')), "C", List.of(new Transition('A')),
                "D", List.of(new Transition('R')), "E",
                List.of(new Transition('R')), "P", List.of(new Transition('L')),
                "T", List.of(new Transition('A'), new Transition('H')));
    }
}
