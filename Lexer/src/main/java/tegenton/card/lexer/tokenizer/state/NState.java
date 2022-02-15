package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.HashMap;
import java.util.Map;

public class NState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    NState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of N states.
     *
     * @return Map of N state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("NA", TransitionFactory.mapOf('M'));
            MAP.put("NAM", TransitionFactory.mapOf('E'));
            MAP.put("NAME", TransitionFactory.mapOf(ObjectAttribute.NAME));
            MAP.put("NE", TransitionFactory.mapOf('W', 'X'));
            MAP.put("NEW", TransitionFactory.mapOf(Adjective.NEW));
            MAP.put("NEX", TransitionFactory.mapOf('T'));
            MAP.put("NEXT", TransitionFactory.mapOf(Adjective.NEXT));
            MAP.put("NI", TransitionFactory.mapOf('N'));
            MAP.put("NIN", TransitionFactory.mapOf('E'));
            MAP.put("NINE", TransitionFactory.mapOf(EnglishNumber.NINE, 'T'));
            MAP.put("NINET", TransitionFactory.mapOf('E'));
            MAP.put("NINETE", TransitionFactory.mapOf('E'));
            MAP.put("NINETEE", TransitionFactory.mapOf('N'));
            MAP.put("NINETEEN",
                    TransitionFactory.mapOf(EnglishNumber.NINETEEN));
            MAP.put("NO", TransitionFactory.mapOf(Determiner.NO, 'T'));
            MAP.put("NOT", TransitionFactory.mapOf(Adverb.NOT));
            MAP.put("NU", TransitionFactory.mapOf('M'));
            MAP.put("NUM", TransitionFactory.mapOf('B'));
            MAP.put("NUMB", TransitionFactory.mapOf('E'));
            MAP.put("NUMBE", TransitionFactory.mapOf('R'));
            MAP.put("NUMBER", TransitionFactory.mapOf(Noun.NUMBER));
            MAP.put("N'", TransitionFactory.mapOf('T'));
            MAP.put("N'T", TransitionFactory.toWord(Adverb.NOT));
        }
        return MAP;
    }
}
