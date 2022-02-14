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

import static tegenton.card.lexicon.Determiner.TARGET;

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
            MAP.put("TAKE", TransitionFactory.toWord(PlayerVerb.TAKE));
            MAP.put("TAP", TransitionFactory.toWord(ObjectVerb.TAP));
            TransitionFactory.sequence(MAP, "TAR", "GET");
            MAP.put("TARGET", TransitionFactory.toWord(TARGET));
            MAP.put("TE", TransitionFactory.mapOf('N', 'X'));
            MAP.put("TEN", TransitionFactory.toWord(EnglishNumber.TEN));
            MAP.put("TEX", TransitionFactory.mapOf('T'));
            MAP.put("TEXT", TransitionFactory.toWord(Noun.TEXT));
            MAP.put("TH", TransitionFactory.mapOf('A', 'E', 'I', 'O', 'R'));
            MAP.put("THA", TransitionFactory.mapOf('N', 'T'));
            MAP.put("THAN", TransitionFactory.toWord(Comparative.THAN));
            MAP.put("THAT", TransitionFactory.toWord(Determiner.THAT));
            MAP.put("THE",
                    TransitionFactory.mapOf(Determiner.THE, 'I', 'M', 'N', 'S',
                            'Y'));
            MAP.put("THEI", Map.of('R', new Transition('R', TargetNoun.THEY)));
            MAP.put("THEIR",
                    TransitionFactory.toWord(TargetModifier.POSSESSIVE));
            MAP.put("THEM", TransitionFactory.toWord(TargetNoun.THEM));
            MAP.put("THEN", TransitionFactory.toWord(Conjunction.THEN));
            MAP.put("THES", TransitionFactory.mapOf('E'));
            MAP.put("THESE", TransitionFactory.toWord(Determiner.THESE));
            MAP.put("THEY", TransitionFactory.toWord(TargetNoun.THEY));
            MAP.put("THI", TransitionFactory.mapOf('R', 'S'));
            TransitionFactory.sequence(MAP, "THIR", "TEEN");
            MAP.put("THIRTEEN",
                    TransitionFactory.toWord(EnglishNumber.THIRTEEN));
            MAP.put("THIS", TransitionFactory.toWord(Determiner.THIS));
            MAP.put("THO", TransitionFactory.mapOf('S', 'U'));
            MAP.put("THOS", TransitionFactory.mapOf('E'));
            MAP.put("THOSE", TransitionFactory.toWord(Determiner.THOSE));
            TransitionFactory.sequence(MAP, "THOU", "GH");
            MAP.put("THOUGH",
                    TransitionFactory.toWord(SubordinateConjunction.THOUGH));
            TransitionFactory.sequence(MAP, "THR", "EE");
            MAP.put("THREE", TransitionFactory.toWord(EnglishNumber.THREE));
            TransitionFactory.sequence(MAP, "TI", "ME");
            MAP.put("TIME", TransitionFactory.toWord(Noun.TIME));
            MAP.put("TO", TransitionFactory.mapOf(Preposition.TO, 'K', 'P', 'T',
                    'U'));
            TransitionFactory.sequence(MAP, "TOK", "EN");
            MAP.put("TOKEN", TransitionFactory.toWord(ObjectNoun.TOKEN));
            MAP.put("TOP", TransitionFactory.toWord(ObjectAdjective.TOP));
            TransitionFactory.sequence(MAP, "TOT", "AL");
            MAP.put("TOTAL", TransitionFactory.toWord(PlayerAttribute.TOTAL));
            MAP.put("TOU", TransitionFactory.mapOf('C', 'G'));
            MAP.put("TOUC", TransitionFactory.mapOf('H'));
            MAP.put("TOUCH", TransitionFactory.toWord(GameVerb.TOUCH));
            TransitionFactory.sequence(MAP, "TOUG", "HNESS");
            MAP.put("TOUGHNESS",
                    TransitionFactory.toWord(ObjectAttribute.TOUGHNESS));
            TransitionFactory.sequence(MAP, "TR", "AMPLE");
            MAP.put("TRAMPLE", TransitionFactory.toWord(Keyword.TRAMPLE));
            MAP.put("TW", TransitionFactory.mapOf('E', 'O'));
            MAP.put("TWE", TransitionFactory.mapOf('L', 'N'));
            TransitionFactory.sequence(MAP, "TWEL", "VE");
            MAP.put("TWELVE", TransitionFactory.toWord(EnglishNumber.TWELVE));
            TransitionFactory.sequence(MAP, "TWEN", "TY");
            MAP.put("TWENTY", TransitionFactory.toWord(EnglishNumber.TWENTY));
            MAP.put("TWO", TransitionFactory.toWord(EnglishNumber.TWO));
            TransitionFactory.sequence(MAP, "TU", "RN");
            MAP.put("TURN", TransitionFactory.toWord(GameNoun.TURN));
            TransitionFactory.sequence(MAP, "TY", "PE");
            MAP.put("TYPE", TransitionFactory.toWord(GameNoun.TYPE));
        }
        return MAP;
    }
}
