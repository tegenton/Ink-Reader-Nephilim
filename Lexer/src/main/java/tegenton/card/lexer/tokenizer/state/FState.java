package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Preposition;

import java.util.Map;

public class FState extends State {
    public FState(String name) {
        super(name);
    }

    protected Map<String, Map<Character, Transition>> transitions() {
        return Map.ofEntries(Map.entry("FO", TransitionFactory.mapOf('R')),
                Map.entry("FOR", Map.of('\0',
                        new Transition('\0', Preposition.FOR, ""))));
    }
}
