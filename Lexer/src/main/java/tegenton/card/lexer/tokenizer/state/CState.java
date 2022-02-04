package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.game.target.object.ObjectNoun;

import java.util.List;
import java.util.Map;

public class CState extends State {
    public CState(String name) {
        super(name);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.of("CA", List.of(new Transition('R')), "CAR",
                List.of(new Transition('D')), "CARD",
                List.of(new Transition('\0', ObjectNoun.CARD, "")));
    }
}
