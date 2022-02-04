package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.Preposition;

import java.util.List;
import java.util.Map;

public class FState extends State {
    public FState(String name) {
        super(name);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.ofEntries(Map.entry("FO", Transition.listOf('R')),
                Map.entry("FOR",
                        List.of(new Transition('\0', Preposition.FOR, ""))));
    }
}
