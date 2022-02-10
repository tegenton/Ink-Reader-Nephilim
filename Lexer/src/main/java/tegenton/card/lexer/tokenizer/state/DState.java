package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.source.SourceVerb;
import tegenton.card.lexicon.game.target.player.PlayerAdjective;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import java.util.HashMap;
import java.util.Map;

public class DState extends State {
    private static final Map<String, Map<Character, Transition>> MAP = new HashMap<>();

    DState(String name) {
        super(name);
    }

    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            TransitionFactory.sequence(MAP, "DA", "MAGE");
            MAP.put("DAMAGE", TransitionFactory.toWord(GameNoun.DAMAGE));
            TransitionFactory.sequence(MAP, "DR", "AW");
            MAP.put("DE", TransitionFactory.mapOf('A', 'C', 'F', 'S'));
            MAP.put("DEA", TransitionFactory.mapOf('L'));
            MAP.put("DEAL", TransitionFactory.toWord(SourceVerb.DEAL));
            MAP.put("DEC", TransitionFactory.mapOf('K', 'L'));
            MAP.put("DECK", TransitionFactory.toWord(Zone.DECK));
            TransitionFactory.sequence(MAP, "DECL", "ARE");
            MAP.put("DECLARE", TransitionFactory.toWord(PlayerVerb.DECLARE));
            TransitionFactory.sequence(MAP, "DEF", "END");
            MAP.put("DEFEND", TransitionFactory.mapOf('E', 'I'));
            MAP.put("DEFENDE", TransitionFactory.mapOf('R'));
            MAP.put("DEFENDER", TransitionFactory.toWord(Keyword.DEFENDER));
            TransitionFactory.sequence(MAP, "DEFENDI", "NG");
            MAP.put("DEFENDING",
                    TransitionFactory.toWord(PlayerAdjective.DEFENDING));
            TransitionFactory.sequence(MAP, "DES", "TROY");
            MAP.put("DESTROY", TransitionFactory.toWord(PlayerVerb.DESTROY));
            MAP.put("DRAW", Map.of('S', new Transition('S', "DRAW"), '\0',
                    new Transition('\0', PlayerVerb.DRAW), ' ',
                    new Transition(' ', PlayerVerb.DRAW, " ")));
        }
        return MAP;
    }
}
