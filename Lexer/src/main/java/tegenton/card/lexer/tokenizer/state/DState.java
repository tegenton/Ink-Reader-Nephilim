package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import java.util.Map;

public class DState extends State {
    public DState(String name) {
        super(name);
    }

    protected Map<String, Map<Character, Transition>> transitions() {
        return Map.of("DR", Map.of('A', new Transition('A')), "DRA",
                Map.of('W', new Transition('W')), "DRAW",
                Map.of('S', new Transition('S', "DRAW"), '\0',
                        new Transition('\0', PlayerVerb.DRAW, ""), ' ',
                        new Transition(' ', PlayerVerb.DRAW, " ")));
    }
}
