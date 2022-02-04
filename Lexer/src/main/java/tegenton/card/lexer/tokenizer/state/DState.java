package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import java.util.List;
import java.util.Map;

public class DState extends State {
    public DState(String name) {
        super(name);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.of("DR", List.of(new Transition('A')), "DRA",
                List.of(new Transition('W')), "DRAW",
                List.of(new Transition('\0', PlayerVerb.DRAW, "")));
    }
}
