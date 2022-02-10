package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.Morpheme;

import java.util.Map;

public class EState extends State {
    public EState(String name) {
        super(name);
    }

    protected Map<String, Map<Character, Transition>> transitions() {
        return Map.of("ER",
                Map.of('\0', new Transition('\0', Morpheme.ER, ""), ' ',
                        new Transition(' ', Morpheme.ER, " ")));
    }
}
