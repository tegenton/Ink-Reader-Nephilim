package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.game.target.player.PlayerNoun;

import java.util.HashMap;
import java.util.Map;

public class YState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    YState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of Y states.
     *
     * @return Map of Y state transitions.
     */
    @Override
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("YO", TransitionFactory.mapOf('U'));
            MAP.put("YOU", TransitionFactory.mapOf(PlayerNoun.YOU));
            MAP.get("YOU").put('R', new Transition('R', PlayerNoun.YOU, "'S"));
            MAP.get("YOU").put('\'', new Transition('\'', PlayerNoun.YOU, "A"));
        }
        return MAP;
    }
}
