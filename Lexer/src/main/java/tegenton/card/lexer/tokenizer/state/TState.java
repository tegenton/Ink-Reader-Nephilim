package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.game.target.TargetModifier;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tegenton.card.lexicon.Determiner.TARGET;

public class TState extends State {
    private static final Map<String, List<Transition>> MAP = new HashMap<>();

    public TState(String name) {
        super(name);
    }

    protected Map<String, List<Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("TA", TransitionFactory.listOf('K', 'P', 'R'));
            MAP.put("TAK", TransitionFactory.listOf('E'));
            MAP.put("TAKE", List.of(new Transition('\0', PlayerVerb.TAKE, "")));
            MAP.put("TAP", List.of(new Transition('\0', ObjectVerb.TAP, "")));
            TransitionFactory.sequence(MAP, "TAR", "GET");
            MAP.put("TARGET", TransitionFactory.toWord(TARGET));
            MAP.put("TE", TransitionFactory.listOf('N', 'X'));
            MAP.put("TEN", TransitionFactory.toWord(EnglishNumber.TEN));
            MAP.put("TEX", TransitionFactory.listOf('T'));
            MAP.put("TEXT", List.of(new Transition('\0', Noun.TEXT, "")));
            MAP.put("TH", TransitionFactory.listOf('A', 'E', 'R'));
            MAP.put("THA", TransitionFactory.listOf('N', 'T'));
            MAP.put("THAN", TransitionFactory.toWord(Comparative.THAN));
            MAP.put("THAT", TransitionFactory.toWord(Determiner.THAT));
            MAP.put("THE", List.of(new Transition('I'), new Transition('M'),
                    new Transition('\0', Determiner.THE, "")));
            MAP.put("THEI", List.of(new Transition('R', TargetNoun.THEY)));
            MAP.put("THEIR",
                    TransitionFactory.toWord(TargetModifier.POSSESSIVE));
            MAP.put("THEM", TransitionFactory.toWord(TargetNoun.THEM));
            MAP.put("THR", TransitionFactory.listOf('E'));
            MAP.put("THRE", TransitionFactory.listOf('E'));
            MAP.put("THREE", TransitionFactory.toWord(EnglishNumber.THREE));
        }
        return MAP;
    }
}
