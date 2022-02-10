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
import java.util.List;
import java.util.Map;

public class CState extends State {
    private static final Map<String, List<Transition>> MAP = new HashMap<>();

    CState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of C states.
     *
     * @return Map of C state transitions.
     */
    protected Map<String, List<Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("CA", TransitionFactory.listOf('N', 'R', 'S', 'U'));
            MAP.put("CAN", TransitionFactory.toWord(TargetAuxiliaryVerb.CAN));
            MAP.put("CAR", TransitionFactory.listOf('D'));
            MAP.put("CARD", List.of(new Transition('S', ObjectNoun.CARD, "S"),
                    new Transition('\0', ObjectNoun.CARD, "")));
            MAP.put("CAS", TransitionFactory.listOf('T'));
            MAP.put("CAST", TransitionFactory.toWord(PlayerVerb.CAST));
            TransitionFactory.sequence(MAP, "CAU", "SE");
            MAP.put("CAUSE", TransitionFactory.toWord(GameVerb.CAUSE));
            MAP.put("CH", TransitionFactory.listOf('A', 'O'));
            TransitionFactory.sequence(MAP, "CHA", "NGE");
            MAP.put("CHANGE", TransitionFactory.toWord(PlayerVerb.CHANGE));
            MAP.put("CHO", TransitionFactory.listOf('I', 'O', 'S'));
            TransitionFactory.sequence(MAP, "CHOI", "CE");
            MAP.put("CHOICE", TransitionFactory.toWord(Noun.CHOICE));
            TransitionFactory.sequence(MAP, "CHOO", "SE");
            MAP.put("CHOOSE", TransitionFactory.toWord(PlayerVerb.CHOOSE));
            TransitionFactory.sequence(MAP, "CHOS", "EN");
            MAP.put("CHOSEN", TransitionFactory.toWord(Adjective.CHOSEN));
            MAP.put("CO", TransitionFactory.listOf('L', 'M', 'N', 'P', 'R', 'S',
                    'U'));
            TransitionFactory.sequence(MAP, "COL", "OR");
            MAP.put("COLOR", TransitionFactory.toWord(GameNoun.COLOR));
            MAP.put("COM", TransitionFactory.listOf('B', 'P'));
            TransitionFactory.sequence(MAP, "COMB", "AT");
            MAP.put("COMBAT", TransitionFactory.toWord(Phase.COMBAT));
            TransitionFactory.sequence(MAP, "COMP", "LETELY");
            MAP.put("COMPLETELY", TransitionFactory.toWord(Adverb.COMPLETELY));
            MAP.put("CON", TransitionFactory.listOf('T'));
            MAP.put("CONT", TransitionFactory.listOf('I', 'R'));
            TransitionFactory.sequence(MAP, "CONTI", "NUOUSLY");
            MAP.put("CONTINUOUSLY",
                    TransitionFactory.toWord(PlayerAdverb.CONTINUOUSLY));
            TransitionFactory.sequence(MAP, "CONTR", "OL");
            MAP.put("CONTROL", TransitionFactory.toWord(PlayerVerb.CONTROL));
            MAP.put("COP", TransitionFactory.listOf('Y'));
            MAP.put("COPY", TransitionFactory.toWord(ObjectNoun.COPY));
            TransitionFactory.sequence(MAP, "COR", "PSE");
            MAP.put("CORPSE", TransitionFactory.toWord(CounterType.CORPSE));
            MAP.put("COS", TransitionFactory.listOf('T'));
            MAP.put("COST", TransitionFactory.toWord(ObjectVerb.COST));
            MAP.put("COU", TransitionFactory.listOf('L', 'N'));
            MAP.put("COUL", TransitionFactory.listOf('D'));
            MAP.put("COULD", TransitionFactory.toWord(PlayerVerb.COULD));
            TransitionFactory.sequence(MAP, "COUN", "TER");
            MAP.put("COUNTER", TransitionFactory.toWord(PlayerVerb.COUNTER));
            TransitionFactory.sequence(MAP, "CR", "EAT");
            MAP.put("CREAT", TransitionFactory.listOf('E', 'U'));
            MAP.put("CREATE", TransitionFactory.toWord(PlayerVerb.CREATE));
            TransitionFactory.sequence(MAP, "CREATU", "RE");
            MAP.put("CREATURE", TransitionFactory.toWord(CardType.CREATURE));
        }
        return MAP;
    }
}
