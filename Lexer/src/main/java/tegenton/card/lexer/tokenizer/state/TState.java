package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.TargetModifier;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.object.ObjectAdjective;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerAttribute;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.HashMap;
import java.util.Map;

public class TState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    TState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of T states.
     *
     * @return Map of T state transitions.
     */
    @Override
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("TA", TransitionFactory.mapOf('K', 'P', 'R'));
            MAP.put("TAK", TransitionFactory.mapOf('E'));
            MAP.put("TAKE", TransitionFactory.mapOf(PlayerVerb.TAKE));
            MAP.put("TAP", TransitionFactory.mapOf(ObjectVerb.TAP, 'P'));
            MAP.put("TAPP",
                    Map.of('E', new Transition('E', ObjectVerb.TAP, "E")));
            TransitionFactory.sequence(MAP, "TAR", "GET");
            MAP.put("TARGET", TransitionFactory.mapOf(Determiner.TARGET));
            MAP.get("TARGET")
                    .put('S', new Transition('S', Determiner.TARGET, "S"));
            MAP.put("TE", TransitionFactory.mapOf('N', 'X'));
            MAP.put("TEN", TransitionFactory.mapOf(EnglishNumber.TEN));
            MAP.put("TEX", TransitionFactory.mapOf('T'));
            MAP.put("TEXT", TransitionFactory.mapOf(Noun.TEXT));
            MAP.put("TH", TransitionFactory.mapOf('A', 'E', 'I', 'O', 'R'));
            MAP.put("THA", TransitionFactory.mapOf('N', 'T'));
            MAP.put("THAN", TransitionFactory.mapOf(Comparative.THAN));
            MAP.put("THAT", TransitionFactory.mapOf(Determiner.THAT));
            MAP.put("THE",
                    TransitionFactory.mapOf(Determiner.THE, 'I', 'M', 'N', 'S',
                            'Y'));
            MAP.put("THEI", Map.of('R', new Transition('R', TargetNoun.THEY)));
            MAP.put("THEIR",
                    TransitionFactory.mapOf(TargetModifier.POSSESSIVE));
            MAP.put("THEM", TransitionFactory.mapOf(TargetNoun.THEM));
            MAP.put("THEN", TransitionFactory.mapOf(Conjunction.THEN));
            MAP.put("THES", TransitionFactory.mapOf('E'));
            MAP.put("THESE", TransitionFactory.mapOf(Determiner.THESE));
            MAP.put("THEY", TransitionFactory.mapOf(TargetNoun.THEY));
            MAP.get("THEY")
                    .put('\'', new Transition('\'', TargetNoun.THEY, "A"));
            MAP.put("THI", TransitionFactory.mapOf('R', 'S'));
            TransitionFactory.sequence(MAP, "THIR", "TEEN");
            MAP.put("THIRTEEN",
                    TransitionFactory.mapOf(EnglishNumber.THIRTEEN));
            MAP.put("THIS", TransitionFactory.mapOf(Determiner.THIS));
            MAP.put("THO", TransitionFactory.mapOf('S', 'U'));
            MAP.put("THOS", TransitionFactory.mapOf('E'));
            MAP.put("THOSE", TransitionFactory.mapOf(Determiner.THOSE));
            TransitionFactory.sequence(MAP, "THOU", "GH");
            MAP.put("THOUGH",
                    TransitionFactory.mapOf(SubordinateConjunction.THOUGH));
            TransitionFactory.sequence(MAP, "THR", "EE");
            MAP.put("THREE", TransitionFactory.mapOf(EnglishNumber.THREE));
            TransitionFactory.sequence(MAP, "TI", "ME");
            MAP.put("TIME", TransitionFactory.mapOf(Noun.TIME));
            MAP.put("TO", TransitionFactory.mapOf(Preposition.TO, 'K', 'P', 'T',
                    'U'));
            TransitionFactory.sequence(MAP, "TOK", "EN");
            MAP.put("TOKEN", TransitionFactory.mapOf(ObjectNoun.TOKEN));
            MAP.put("TOP", TransitionFactory.mapOf(ObjectAdjective.TOP));
            TransitionFactory.sequence(MAP, "TOT", "AL");
            MAP.put("TOTAL", TransitionFactory.mapOf(PlayerAttribute.TOTAL));
            MAP.put("TOU", TransitionFactory.mapOf('C', 'G'));
            MAP.put("TOUC", TransitionFactory.mapOf('H'));
            MAP.put("TOUCH", TransitionFactory.mapOf(GameVerb.TOUCH));
            TransitionFactory.sequence(MAP, "TOUG", "HNESS");
            MAP.put("TOUGHNESS",
                    TransitionFactory.mapOf(ObjectAttribute.TOUGHNESS));
            TransitionFactory.sequence(MAP, "TR", "AMPLE");
            MAP.put("TRAMPLE", TransitionFactory.mapOf(Keyword.TRAMPLE));
            MAP.put("TW", TransitionFactory.mapOf('E', 'O'));
            MAP.put("TWE", TransitionFactory.mapOf('L', 'N'));
            TransitionFactory.sequence(MAP, "TWEL", "VE");
            MAP.put("TWELVE", TransitionFactory.mapOf(EnglishNumber.TWELVE));
            TransitionFactory.sequence(MAP, "TWEN", "TY");
            MAP.put("TWENTY", TransitionFactory.mapOf(EnglishNumber.TWENTY));
            MAP.put("TWO", TransitionFactory.mapOf(EnglishNumber.TWO));
            TransitionFactory.sequence(MAP, "TU", "RN");
            MAP.put("TURN", TransitionFactory.mapOf(GameNoun.TURN));
            TransitionFactory.sequence(MAP, "TY", "PE");
            MAP.put("TYPE", TransitionFactory.mapOf(GameNoun.TYPE));
        }
        return MAP;
    }
}
