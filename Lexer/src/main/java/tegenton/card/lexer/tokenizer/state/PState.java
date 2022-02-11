package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.card.CardName;
import tegenton.card.lexicon.game.target.object.source.SourceVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.LandType;

import java.util.HashMap;
import java.util.Map;

public class PState extends State {
    private static final Map<String, Map<Character, Transition>> MAP = new HashMap<>();

    public PState(String name) {
        super(name);
    }

    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("PA", TransitionFactory.mapOf('Y'));
            MAP.put("PAY", TransitionFactory.mapOf(PlayerVerb.PAY));
            MAP.put("PE", TransitionFactory.mapOf('R'));
            MAP.put("PER", TransitionFactory.mapOf('M'));
            MAP.put("PERM", TransitionFactory.mapOf('A'));
            MAP.put("PERMA", TransitionFactory.mapOf('N'));
            MAP.put("PERMAN", TransitionFactory.mapOf('E'));
            MAP.put("PERMANE", TransitionFactory.mapOf('N'));
            MAP.put("PERMANEN", TransitionFactory.mapOf('T'));
            MAP.put("PERMANENT", TransitionFactory.mapOf(ObjectNoun.PERMANENT));
            MAP.put("PI", TransitionFactory.mapOf('L'));
            MAP.put("PIL", TransitionFactory.mapOf('E'));
            MAP.put("PILE", TransitionFactory.mapOf(GameNoun.PILE));
            MAP.put("PO", TransitionFactory.mapOf('W'));
            MAP.put("POW", TransitionFactory.mapOf('E'));
            MAP.put("POWE", TransitionFactory.mapOf('R'));
            MAP.put("POWER", TransitionFactory.mapOf(ObjectAttribute.POWER));
            MAP.put("PL", TransitionFactory.mapOf('A'));
            MAP.put("PLA", TransitionFactory.mapOf('G', 'I', 'N', 'Y'));
            MAP.put("PLAG", TransitionFactory.mapOf('U'));
            MAP.put("PLAGU", TransitionFactory.mapOf('E'));
            MAP.put("PLAGUE", TransitionFactory.mapOf(CardName.PLAGUE));
            MAP.put("PLAI", TransitionFactory.mapOf('N'));
            MAP.put("PLAIN", TransitionFactory.mapOf('S'));
            MAP.put("PLAINS", TransitionFactory.mapOf(LandType.PLAINS));
            MAP.put("PLAN", TransitionFactory.mapOf('E'));
            MAP.put("PLANE", TransitionFactory.mapOf('S'));
            MAP.put("PLANES", TransitionFactory.mapOf('W'));
            MAP.put("PLANESW", TransitionFactory.mapOf('A'));
            MAP.put("PLANESWA", TransitionFactory.mapOf('L'));
            MAP.put("PLANESWAL", TransitionFactory.mapOf('K'));
            MAP.put("PLANESWALK", TransitionFactory.mapOf('E'));
            MAP.put("PLANESWALKE", TransitionFactory.mapOf('R'));
            MAP.put("PLANESWALKER",
                    TransitionFactory.mapOf(CardType.PLANESWALKER));
            MAP.put("PLAY", TransitionFactory.mapOf(PlayerVerb.PLAY));
            MAP.put("PR", TransitionFactory.mapOf('E', 'O'));
            MAP.put("PRE", TransitionFactory.mapOf('V'));
            MAP.put("PREV", TransitionFactory.mapOf('E'));
            MAP.put("PREVE", TransitionFactory.mapOf('N'));
            MAP.put("PREVEN", TransitionFactory.mapOf('T'));
            MAP.put("PREVENT", TransitionFactory.mapOf(PlayerVerb.PREVENT));
            MAP.put("PRO", TransitionFactory.mapOf('D', 'T'));
            MAP.put("PROD", TransitionFactory.mapOf('U'));
            MAP.put("PRODU", TransitionFactory.mapOf('C'));
            MAP.put("PRODUC", TransitionFactory.mapOf('E'));
            MAP.put("PRODUCE", TransitionFactory.mapOf(SourceVerb.PRODUCE));
            MAP.put("PROT", TransitionFactory.mapOf('E'));
            MAP.put("PROTE", TransitionFactory.mapOf('C'));
            MAP.put("PROTEC", TransitionFactory.mapOf('T'));
            MAP.put("PROTECT", TransitionFactory.mapOf('I'));
            MAP.put("PROTECTI", TransitionFactory.mapOf('O'));
            MAP.put("PROTECTIO", TransitionFactory.mapOf('N'));
            MAP.put("PROTECTION", TransitionFactory.mapOf(Keyword.PROTECTION));
            MAP.put("PU", TransitionFactory.mapOf('T'));
            MAP.put("PUT", TransitionFactory.mapOf(PlayerVerb.PUT));
        }
        return MAP;
    }
}
