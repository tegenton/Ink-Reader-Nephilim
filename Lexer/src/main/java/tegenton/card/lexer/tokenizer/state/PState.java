package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import java.util.Map;

public class PState extends State {
    public PState(String name) {
        super(name);
    }

    protected Map<String, Map<Character, Transition>> transitions() {
        return Map.of("PL", Map.of('A', new Transition('A')), "PLA",
                Map.of('Y', new Transition('Y')), "PLAY",
                Map.of('\0', new Transition('\0', PlayerVerb.PLAY, ""), 'E',
                        new Transition('E', PlayerVerb.PLAY, "E")));
    }
}
