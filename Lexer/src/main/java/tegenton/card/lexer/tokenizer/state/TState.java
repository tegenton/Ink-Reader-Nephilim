package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.List;
import java.util.Map;

public class TState extends State {
    public TState(String name) {
        super(name);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.of("TA", List.of(new Transition('R')), "TAR",
                List.of(new Transition('G')), "TARG",
                List.of(new Transition('E')), "TARGE",
                List.of(new Transition('T')), "TARGET",
                List.of(new Transition('\0', Determiner.TARGET, ""),
                        new Transition(' ', Determiner.TARGET, " ")), "TH",
                List.of(new Transition('R')), "THR",
                List.of(new Transition('E')), "THRE",
                List.of(new Transition('E')), "THREE",
                List.of(new Transition('\0', EnglishNumber.THREE, ""),
                        new Transition(' ', EnglishNumber.THREE, " ")));
    }
}
