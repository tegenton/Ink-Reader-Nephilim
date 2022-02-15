package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.CreatureType;
import tegenton.card.lexicon.game.type.LandType;

import java.util.HashMap;
import java.util.Map;

public class IState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    IState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of I states.
     *
     * @return Map of I state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("IF", TransitionFactory.mapOf(SubordinateConjunction.IF));
            MAP.put("IG", TransitionFactory.mapOf('N'));
            MAP.put("IGN", TransitionFactory.mapOf('O'));
            MAP.put("IGNO", TransitionFactory.mapOf('R'));
            MAP.put("IGNOR", TransitionFactory.mapOf('E'));
            MAP.put("IGNORE", TransitionFactory.mapOf(PlayerVerb.IGNORE));
            MAP.put("IN",
                    TransitionFactory.mapOf(Preposition.IN, 'D', 'G', 'S'));
            MAP.get("IN").put('T', new Transition('T', Preposition.IN, "T"));
            MAP.put("IND", TransitionFactory.mapOf('E'));
            MAP.put("INDE", TransitionFactory.mapOf('S'));
            MAP.put("INDES", TransitionFactory.mapOf('T'));
            MAP.put("INDEST", TransitionFactory.mapOf('R'));
            MAP.put("INDESTR", TransitionFactory.mapOf('U'));
            MAP.put("INDESTRU", TransitionFactory.mapOf('C'));
            MAP.put("INDESTRUC", TransitionFactory.mapOf('T'));
            MAP.put("INDESTRUCT", TransitionFactory.mapOf('I'));
            MAP.put("INDESTRUCTI", TransitionFactory.mapOf('B'));
            MAP.put("INDESTRUCTIB", TransitionFactory.mapOf('L'));
            MAP.put("INDESTRUCTIBL", TransitionFactory.mapOf('E'));
            MAP.put("INDESTRUCTIBLE",
                    TransitionFactory.mapOf(Keyword.INDESTRUCTIBLE));
            MAP.put("ING", TransitionFactory.mapOf(Morpheme.ING));
            MAP.put("INS", TransitionFactory.mapOf('E', 'T'));
            MAP.put("INSE", TransitionFactory.mapOf('C'));
            MAP.put("INSEC", TransitionFactory.mapOf('T'));
            MAP.put("INSECT", TransitionFactory.mapOf(CreatureType.INSECT));
            MAP.put("INST", TransitionFactory.mapOf('A', 'E'));
            MAP.put("INSTA", TransitionFactory.mapOf('N'));
            MAP.put("INSTAN", TransitionFactory.mapOf('C', 'T'));
            MAP.put("INSTANC", TransitionFactory.mapOf('E'));
            MAP.put("INSTANCE", TransitionFactory.mapOf(Noun.INSTANCE));
            MAP.put("INSTANT", TransitionFactory.mapOf(CardType.INSTANT));
            MAP.put("INSTE", TransitionFactory.mapOf('A'));
            MAP.put("INSTEA", TransitionFactory.mapOf('D'));
            MAP.put("INSTEAD", TransitionFactory.mapOf(Adverb.INSTEAD));
            MAP.put("IS", TransitionFactory.mapOf(ObjectVerb.IS, 'L'));
            MAP.get("IS").put('N', new Transition('N', ObjectVerb.IS, "N"));
            MAP.put("ISL", TransitionFactory.mapOf('A'));
            MAP.put("ISLA", TransitionFactory.mapOf('N'));
            MAP.put("ISLAN", TransitionFactory.mapOf('D'));
            MAP.put("ISLAND", TransitionFactory.mapOf(LandType.ISLAND));
            MAP.get("ISLAND")
                    .put('W', new Transition('W', LandType.ISLAND, "W"));
            MAP.put("IT", TransitionFactory.mapOf(ObjectNoun.IT));
            MAP.get("IT").put('S', new Transition('S', ObjectNoun.IT, "'S"));
            MAP.get("IT").put('\'', new Transition('\'', ObjectNoun.IT, "I"));
        }
        return MAP;
    }
}
