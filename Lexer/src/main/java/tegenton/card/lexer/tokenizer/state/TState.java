package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.*;
import tegenton.card.lexicon.game.GameVerb;
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
            MAP.put("TAKE", TransitionFactory.toWord(PlayerVerb.TAKE));
            MAP.put("TAP", TransitionFactory.toWord(ObjectVerb.TAP));
            TransitionFactory.sequence(MAP, "TAR", "GET");
            MAP.put("TARGET", TransitionFactory.toWord(TARGET));
            MAP.put("TE", TransitionFactory.listOf('N', 'X'));
            MAP.put("TEN", TransitionFactory.toWord(EnglishNumber.TEN));
            MAP.put("TEX", TransitionFactory.listOf('T'));
            MAP.put("TEXT", TransitionFactory.toWord(Noun.TEXT));
            MAP.put("TH", TransitionFactory.listOf('A', 'E', 'I', 'O', 'R'));
            MAP.put("THA", TransitionFactory.listOf('N', 'T'));
            MAP.put("THAN", TransitionFactory.toWord(Comparative.THAN));
            MAP.put("THAT", TransitionFactory.toWord(Determiner.THAT));
            MAP.put("THE",
                    TransitionFactory.listOf(Determiner.THE, 'I', 'M', 'N', 'S',
                            'Y'));
            MAP.put("THEI", List.of(new Transition('R', TargetNoun.THEY)));
            MAP.put("THEIR",
                    TransitionFactory.toWord(TargetModifier.POSSESSIVE));
            MAP.put("THEM", TransitionFactory.toWord(TargetNoun.THEM));
            MAP.put("THEN", TransitionFactory.toWord(Conjunction.THEN));
            MAP.put("THES", TransitionFactory.listOf('E'));
            MAP.put("THESE", TransitionFactory.toWord(Determiner.THESE));
            MAP.put("THEY", TransitionFactory.toWord(TargetNoun.THEY));
            MAP.put("THI", TransitionFactory.listOf('R', 'S'));
            TransitionFactory.sequence(MAP, "THIR", "TEEN");
            MAP.put("THIRTEEN",
                    TransitionFactory.toWord(EnglishNumber.THIRTEEN));
            MAP.put("THIS", TransitionFactory.toWord(Determiner.THIS));
            MAP.put("THO", TransitionFactory.listOf('S', 'U'));
            MAP.put("THOS", TransitionFactory.listOf('E'));
            MAP.put("THOSE", TransitionFactory.toWord(Determiner.THOSE));
            TransitionFactory.sequence(MAP, "THOU", "GH");
            MAP.put("THOUGH",
                    TransitionFactory.toWord(SubordinateConjunction.THOUGH));
            TransitionFactory.sequence(MAP, "THR", "EE");
            MAP.put("THREE", TransitionFactory.toWord(EnglishNumber.THREE));
            TransitionFactory.sequence(MAP, "TI", "ME");
            MAP.put("TIME", TransitionFactory.toWord(Noun.TIME));
            MAP.put("TO",
                    TransitionFactory.listOf(Preposition.TO, 'K', 'P', 'T',
                            'U'));
            TransitionFactory.sequence(MAP, "TOK", "EN");
            MAP.put("TOKEN", TransitionFactory.toWord(ObjectNoun.TOKEN));
            MAP.put("TOP", TransitionFactory.toWord(ObjectAdjective.TOP));
            TransitionFactory.sequence(MAP, "TOT", "AL");
            MAP.put("TOTAL", TransitionFactory.toWord(PlayerAttribute.TOTAL));
            MAP.put("TOU", TransitionFactory.listOf('C', 'G'));
            MAP.put("TOUC", TransitionFactory.listOf('H'));
            MAP.put("TOUCH", TransitionFactory.toWord(GameVerb.TOUCH));
            TransitionFactory.sequence(MAP, "TOUG", "HNESS");
            MAP.put("TOUGHNESS",
                    TransitionFactory.toWord(ObjectAttribute.TOUGHNESS));
        }
        return MAP;
    }
}
