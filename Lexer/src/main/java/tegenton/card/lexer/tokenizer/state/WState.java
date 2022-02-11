package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.TriggerWord;
import tegenton.card.lexicon.game.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.object.card.CardName;
import tegenton.card.lexicon.game.turn.Duration;
import tegenton.card.lexicon.game.type.CreatureType;

import java.util.HashMap;
import java.util.Map;

public class WState extends State {
    private static final Map<String, Map<Character, Transition>> MAP = new HashMap<>();

    WState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of W states.
     *
     * @return Map of W state transitions.
     */
    @Override
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("WA", TransitionFactory.mapOf('L', 'S', 'Y'));
            MAP.put("WAL", TransitionFactory.mapOf('K', 'L'));
            MAP.put("WALK", TransitionFactory.mapOf(Keyword.WALK));
            MAP.put("WALL", TransitionFactory.mapOf(CreatureType.WALL));
            MAP.put("WAS", TransitionFactory.mapOf('P'));
            MAP.put("WASP", TransitionFactory.mapOf(CardName.WASP));
            MAP.put("WAY", TransitionFactory.mapOf(Noun.WAY));
            MAP.put("WH", TransitionFactory.mapOf('E', 'I', 'O'));
            MAP.put("WHE", TransitionFactory.mapOf('N', 'R'));
            MAP.put("WHEN", TransitionFactory.mapOf(TriggerWord.WHEN, 'E'));
            MAP.put("WHENE", TransitionFactory.mapOf('V'));
            MAP.put("WHENEV", TransitionFactory.mapOf('E'));
            MAP.put("WHENEVE", TransitionFactory.mapOf('R'));
            MAP.put("WHENEVER", TransitionFactory.mapOf(TriggerWord.WHENEVER));
            MAP.put("WHER", TransitionFactory.mapOf('E'));
            MAP.put("WHERE",
                    TransitionFactory.mapOf(SubordinateConjunction.WHERE));
            MAP.put("WHI", TransitionFactory.mapOf('L', 'T'));
            MAP.put("WHIL", TransitionFactory.mapOf('E'));
            MAP.put("WHILE", TransitionFactory.mapOf(Duration.WHILE));
            MAP.put("WHIT", TransitionFactory.mapOf('E'));
            MAP.put("WHITE", TransitionFactory.mapOf(ColorWord.WHITE));
            MAP.put("WHO", TransitionFactory.mapOf(TargetNoun.WHO));
            MAP.put("WI", TransitionFactory.mapOf('T'));
            MAP.put("WIT", TransitionFactory.mapOf('H'));
            MAP.put("WITH", TransitionFactory.mapOf(Preposition.WITH));
            MAP.put("WO", TransitionFactory.mapOf('R', 'U'));
            MAP.put("WOR", TransitionFactory.mapOf('D'));
            MAP.put("WORD", TransitionFactory.mapOf(Noun.WORD));
            MAP.put("WOU", TransitionFactory.mapOf('L'));
            MAP.put("WOUL", TransitionFactory.mapOf('D'));
            MAP.put("WOULD",
                    TransitionFactory.mapOf(TargetAuxiliaryVerb.WOULD));
        }
        return MAP;
    }
}
