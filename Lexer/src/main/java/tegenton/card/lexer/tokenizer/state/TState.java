package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.List;
import java.util.Map;

public class TState extends State {
    public TState(String name) {
        super(name);
    }

    protected Map<String, List<Transition>> transitions() {
        return Map.ofEntries(Map.entry("TA", Transition.listOf('K', 'P', 'R')),
                Map.entry("TAK", Transition.listOf('E')), Map.entry("TAKE",
                        List.of(new Transition('\0', PlayerVerb.TAKE, ""))),
                Map.entry("TAP",
                        List.of(new Transition('\0', ObjectVerb.TAP, ""))),
                Map.entry("TAR", Transition.listOf('G')),
                Map.entry("TARG", Transition.listOf('E')),
                Map.entry("TARGE", Transition.listOf('T')), Map.entry("TARGET",
                        List.of(new Transition('\0', Determiner.TARGET, ""),
                                new Transition(' ', Determiner.TARGET, " "))),
                Map.entry("TE", Transition.listOf('N', 'X')), Map.entry("TEN",
                        List.of(new Transition('\0', EnglishNumber.TEN, ""))),
                Map.entry("TEX", Transition.listOf('T')),
                Map.entry("TEXT", List.of(new Transition('\0', Noun.TEXT, ""))),
                Map.entry("TH", Transition.listOf('R')),
                Map.entry("THR", Transition.listOf('E')),
                Map.entry("THRE", Transition.listOf('E')), Map.entry("THREE",
                        List.of(new Transition('\0', EnglishNumber.THREE, ""),
                                new Transition(' ', EnglishNumber.THREE,
                                        " "))));
    }
}
