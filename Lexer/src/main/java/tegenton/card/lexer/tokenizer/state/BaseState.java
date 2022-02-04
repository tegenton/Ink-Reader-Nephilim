package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexicon.Determiner;

import java.util.List;
import java.util.Map;

public class BaseState extends State {
    public BaseState(String s) {
        super(s);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.of("", List.of(new Transition('A'), new Transition('B'),
                        new Transition('T')), "A",
                List.of(new Transition('\0', Determiner.A, "")), "B",
                List.of(new Transition('E')), "T",
                List.of(new Transition('A')));
    }
}
