package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.game.GameVerb;

import java.util.List;
import java.util.Map;

public class BState extends State {
    public BState(String name) {
        super(name);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.of("BE", List.of(new Transition('\0', GameVerb.BE, "")));
    }
}
