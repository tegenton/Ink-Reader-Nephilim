package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerAdverb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Phase;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.CounterType;

import java.util.HashMap;
import java.util.Map;

public class CState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    CState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of C states.
     *
     * @return Map of C state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("CA", TransitionFactory.mapOf('N', 'R', 'S', 'U'));
            MAP.put("CAN", TransitionFactory.mapOf(TargetAuxiliaryVerb.CAN));
            MAP.get("CAN").put('\'',
                    new Transition('\'', TargetAuxiliaryVerb.CAN, "NO"));
            MAP.put("CAR", TransitionFactory.mapOf('D'));
            MAP.put("CARD", TransitionFactory.mapOf(ObjectNoun.CARD));
            MAP.put("CAS", TransitionFactory.mapOf('T'));
            MAP.put("CAST", TransitionFactory.mapOf(PlayerVerb.CAST));
            TransitionFactory.sequence(MAP, "CAU", "SE");
            MAP.put("CAUSE", TransitionFactory.mapOf(GameVerb.CAUSE));
            MAP.put("CH", TransitionFactory.mapOf('A', 'O'));
            TransitionFactory.sequence(MAP, "CHA", "NGE");
            MAP.put("CHANGE", TransitionFactory.mapOf(PlayerVerb.CHANGE));
            MAP.put("CHO", TransitionFactory.mapOf('I', 'O', 'S'));
            TransitionFactory.sequence(MAP, "CHOI", "CE");
            MAP.put("CHOICE", TransitionFactory.mapOf(Noun.CHOICE));
            TransitionFactory.sequence(MAP, "CHOO", "SE");
            MAP.put("CHOOSE", TransitionFactory.mapOf(PlayerVerb.CHOOSE));
            TransitionFactory.sequence(MAP, "CHOS", "EN");
            MAP.put("CHOSEN", TransitionFactory.mapOf(Adjective.CHOSEN));
            MAP.put("CO",
                    TransitionFactory.mapOf('L', 'M', 'N', 'P', 'R', 'S', 'U'));
            TransitionFactory.sequence(MAP, "COL", "OR");
            MAP.put("COLOR", TransitionFactory.mapOf(GameNoun.COLOR));
            MAP.put("COM", TransitionFactory.mapOf('B', 'P'));
            TransitionFactory.sequence(MAP, "COMB", "AT");
            MAP.put("COMBAT", TransitionFactory.mapOf(Phase.COMBAT));
            TransitionFactory.sequence(MAP, "COMP", "LETELY");
            MAP.put("COMPLETELY", TransitionFactory.mapOf(Adverb.COMPLETELY));
            MAP.put("CON", TransitionFactory.mapOf('T'));
            MAP.put("CONT", TransitionFactory.mapOf('I', 'R'));
            TransitionFactory.sequence(MAP, "CONTI", "NUOUSLY");
            MAP.put("CONTINUOUSLY",
                    TransitionFactory.mapOf(PlayerAdverb.CONTINUOUSLY));
            TransitionFactory.sequence(MAP, "CONTR", "OL");
            MAP.put("CONTROL",
                    TransitionFactory.mapOf(PlayerVerb.CONTROL, 'L', 'S'));
            MAP.put("CONTROLL",
                    Map.of('E', new Transition('E', PlayerVerb.CONTROL, "E")));
            MAP.put("CONTROLS", TransitionFactory.mapOf(PlayerVerb.CONTROL));
            MAP.put("COP", TransitionFactory.mapOf('Y'));
            MAP.put("COPY", TransitionFactory.mapOf(ObjectNoun.COPY));
            TransitionFactory.sequence(MAP, "COR", "PSE");
            MAP.put("CORPSE", TransitionFactory.mapOf(CounterType.CORPSE));
            MAP.put("COS", TransitionFactory.mapOf('T'));
            MAP.put("COST", TransitionFactory.mapOf(ObjectVerb.COST));
            MAP.put("COU", TransitionFactory.mapOf('L', 'N'));
            MAP.put("COUL", TransitionFactory.mapOf('D'));
            MAP.put("COULD", TransitionFactory.mapOf(PlayerVerb.COULD));
            TransitionFactory.sequence(MAP, "COUN", "TER");
            MAP.put("COUNTER", TransitionFactory.mapOf(PlayerVerb.COUNTER));
            TransitionFactory.sequence(MAP, "CR", "EAT");
            MAP.put("CREAT", TransitionFactory.mapOf('E', 'U'));
            MAP.put("CREATE", TransitionFactory.mapOf(PlayerVerb.CREATE));
            TransitionFactory.sequence(MAP, "CREATU", "RE");
            MAP.put("CREATURE", TransitionFactory.mapOf(CardType.CREATURE));
        }
        return MAP;
    }
}
