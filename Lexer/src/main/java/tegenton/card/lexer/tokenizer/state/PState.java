package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexicon.game.target.player.PlayerVerb;

import java.util.List;
import java.util.Map;

public class PState extends State {
    public PState(String name) {
        super(name);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.of("PL", List.of(new Transition('A')), "PLA",
                List.of(new Transition('Y')), "PLAY",
                List.of(new Transition('\0', PlayerVerb.PLAY, "")));
    }
}
