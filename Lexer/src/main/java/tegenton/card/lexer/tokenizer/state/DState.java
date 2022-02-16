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
            MAP.put("DAMAGE", TransitionFactory.mapOf(GameNoun.DAMAGE));
            MAP.put("DE", TransitionFactory.mapOf('A', 'C', 'F', 'S'));
            MAP.put("DEA", TransitionFactory.mapOf('L'));
            MAP.put("DEAL", TransitionFactory.mapOf(SourceVerb.DEAL));
            MAP.get("DEAL")
                    .put('T', new Transition('T', SourceVerb.DEAL, "ED"));
            MAP.put("DEC", TransitionFactory.mapOf('K', 'L'));
            MAP.put("DECK", TransitionFactory.mapOf(Zone.DECK));
            TransitionFactory.sequence(MAP, "DECL", "AR");
            MAP.put("DECLAR", TransitionFactory.mapOf('E', 'I'));
            MAP.put("DECLARE", TransitionFactory.mapOf(PlayerVerb.DECLARE));
            MAP.get("DECLARE")
                    .put('D', new Transition('D', PlayerVerb.DECLARE, "ED"));
            MAP.put("DECLARI",
                    Map.of('N', new Transition('N', PlayerVerb.DECLARE, "IN")));
            TransitionFactory.sequence(MAP, "DEF", "END");
            MAP.put("DEFEND", TransitionFactory.mapOf('E', 'I'));
            MAP.put("DEFENDE", TransitionFactory.mapOf('R'));
            MAP.put("DEFENDER", TransitionFactory.mapOf(Keyword.DEFENDER));
            TransitionFactory.sequence(MAP, "DEFENDI", "NG");
            MAP.put("DEFENDING",
                    TransitionFactory.mapOf(PlayerAdjective.DEFENDING));
            TransitionFactory.sequence(MAP, "DES", "TROY");
            MAP.put("DESTROY", TransitionFactory.mapOf(PlayerVerb.DESTROY));
            MAP.put("DI", TransitionFactory.mapOf('E', 'F', 'S', 'V'));
            MAP.get("DI").put('D', new Transition('D', SourceVerb.DO));
            MAP.put("DID", Map.of('N', new Transition('N', Morpheme.ED, "N")));
            MAP.put("DIE", TransitionFactory.mapOf(ObjectVerb.DIE));
            MAP.get("DIE").put('D', new Transition('D', ObjectVerb.DIE, "ED"));
            TransitionFactory.sequence(MAP, "DIF", "FERENT");
            MAP.put("DIFFERENT", TransitionFactory.mapOf(Adjective.DIFFERENT));
            TransitionFactory.sequence(MAP, "DIS", "CARD");
            MAP.put("DISCARD", TransitionFactory.mapOf(PlayerVerb.DISCARD));
            TransitionFactory.sequence(MAP, "DIV", "IDE");
            MAP.put("DIVIDE", TransitionFactory.mapOf(PlayerVerb.DIVIDE));
            MAP.get("DIVIDE")
                    .put('D', new Transition('D', PlayerVerb.DIVIDE, "ED"));
            MAP.put("DO", TransitionFactory.mapOf(SourceVerb.DO, 'E', 'W'));
            MAP.get("DO").put('I', new Transition('I', SourceVerb.DO, "I"));
            MAP.get("DO").put('N', new Transition('N', SourceVerb.DO, "N"));
            MAP.put("DOE", TransitionFactory.mapOf('S'));
            MAP.put("DOES", TransitionFactory.mapOf(SourceVerb.DO));
            MAP.get("DOES").put('N', new Transition('N', SourceVerb.DO, "N"));
            MAP.put("DOW", TransitionFactory.mapOf('N'));
            MAP.put("DOWN", TransitionFactory.mapOf(Particle.DOWN));
            TransitionFactory.sequence(MAP, "DR", "AW");
            MAP.put("DRAW", TransitionFactory.mapOf(PlayerVerb.DRAW));
            TransitionFactory.sequence(MAP, "DU", "RING");
            MAP.put("DURING", TransitionFactory.mapOf(Chronology.DURING));
        }
        return MAP;
    }
}
