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
        return Map.ofEntries(Map.entry("TA", Transition.listOf('R')),
                Map.entry("TAR", Transition.listOf('G')),
                Map.entry("TARG", Transition.listOf('E')),
                Map.entry("TARGE", Transition.listOf('T')), Map.entry("TARGET",
                        List.of(new Transition('\0', Determiner.TARGET, ""),
                                new Transition(' ', Determiner.TARGET, " "))),
                Map.entry("TH", Transition.listOf('R')),
                Map.entry("THR", Transition.listOf('E')),
                Map.entry("THRE", Transition.listOf('E')), Map.entry("THREE",
                        List.of(new Transition('\0', EnglishNumber.THREE, ""),
                                new Transition(' ', EnglishNumber.THREE,
                                        " "))));
    }
}
