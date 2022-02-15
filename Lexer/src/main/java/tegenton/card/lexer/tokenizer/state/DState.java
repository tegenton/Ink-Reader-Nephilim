package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.object.source.SourceVerb;
import tegenton.card.lexicon.game.target.player.PlayerAdjective;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Chronology;

import java.util.HashMap;
import java.util.Map;

public class DState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    DState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of D states.
     *
     * @return Map of D state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            TransitionFactory.sequence(MAP, "DA", "MAGE");
            MAP.put("DAMAGE", TransitionFactory.toWord(GameNoun.DAMAGE));
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
            MAP.put("DI", Map.of('D', new Transition('D', SourceVerb.DO), 'E',
                    TransitionFactory.getTransition('E'), 'F',
                    TransitionFactory.getTransition('F'), 'S',
                    TransitionFactory.getTransition('S'), 'V',
                    TransitionFactory.getTransition('V')));
            MAP.put("DID", Map.of('N', new Transition('N', Morpheme.ED, "N")));
            MAP.put("DIE", TransitionFactory.toWord(ObjectVerb.DIE));
            TransitionFactory.sequence(MAP, "DIF", "FERENT");
            MAP.put("DIFFERENT", TransitionFactory.toWord(Adjective.DIFFERENT));
            TransitionFactory.sequence(MAP, "DIS", "CARD");
            MAP.put("DISCARD", TransitionFactory.toWord(PlayerVerb.DISCARD));
            TransitionFactory.sequence(MAP, "DIV", "IDE");
            MAP.put("DIVIDE", TransitionFactory.toWord(PlayerVerb.DIVIDE));
            MAP.put("DO", TransitionFactory.mapOf(SourceVerb.DO, 'W'));
            MAP.put("DOW", TransitionFactory.mapOf('N'));
            MAP.put("DOWN", TransitionFactory.toWord(Particle.DOWN));
            TransitionFactory.sequence(MAP, "DR", "AW");
            MAP.put("DRAW", Map.of('S', new Transition('S', "DRAW"), '\0',
                    new Transition('\0', PlayerVerb.DRAW, ""), ' ',
                    new Transition(' ', PlayerVerb.DRAW, " ")));
            TransitionFactory.sequence(MAP, "DU", "RING");
            MAP.put("DURING", TransitionFactory.toWord(Chronology.DURING));
        }
        return MAP;
    }
}
