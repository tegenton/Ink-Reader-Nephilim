package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexicon.Morpheme;

import java.util.List;
import java.util.Map;

public class EState extends State {
    public EState(String name) {
        super(name);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.of("ER", List.of(new Transition('\0', Morpheme.ER, "")));
    }
}
