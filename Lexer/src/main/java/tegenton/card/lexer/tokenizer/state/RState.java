package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.card.CardName;
import tegenton.card.lexicon.game.target.object.source.SourceVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import java.util.HashMap;
import java.util.Map;

public class RState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    RState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of R states.
     *
     * @return Map of R state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("RA", TransitionFactory.mapOf('N', 'T'));
            MAP.put("RAN", TransitionFactory.mapOf('D'));
            MAP.put("RAND", TransitionFactory.mapOf('O'));
            MAP.put("RANDO", TransitionFactory.mapOf('M'));
            MAP.put("RANDOM", TransitionFactory.mapOf(Noun.RANDOM));
            MAP.put("RAT", TransitionFactory.mapOf('S'));
            MAP.put("RATS", TransitionFactory.mapOf(CardName.RATS));
            MAP.put("RE",
                    TransitionFactory.mapOf('A', 'D', 'G', 'M', 'P', 'S', 'T'));
            MAP.put("REA", TransitionFactory.mapOf('C'));
            MAP.put("REAC", TransitionFactory.mapOf('H'));
            MAP.put("REACH", TransitionFactory.mapOf(Keyword.REACH));
            MAP.put("RED", TransitionFactory.mapOf(ColorWord.RED));
            MAP.put("REG", TransitionFactory.mapOf('E'));
            MAP.put("REGE", TransitionFactory.mapOf('N'));
            MAP.put("REGEN", TransitionFactory.mapOf('E'));
            MAP.put("REGENE", TransitionFactory.mapOf('R'));
            MAP.put("REGENER", TransitionFactory.mapOf('A'));
            MAP.put("REGENERA", TransitionFactory.mapOf('T'));
            MAP.put("REGENERAT", TransitionFactory.mapOf('E'));
            MAP.put("REGENERATE",
                    TransitionFactory.mapOf(PlayerVerb.REGENERATE));
            MAP.get("REGENERATE")
                    .put('D', new Transition('D', PlayerVerb.REGENERATE, "ED"));
            MAP.put("REM", TransitionFactory.mapOf('O'));
            MAP.put("REMO", TransitionFactory.mapOf('V'));
            MAP.put("REMOV", TransitionFactory.mapOf('E'));
            MAP.put("REMOVE", TransitionFactory.mapOf(PlayerVerb.REMOVE));
            MAP.put("REP", TransitionFactory.mapOf('L'));
            MAP.put("REPL", TransitionFactory.mapOf('A'));
            MAP.put("REPLA", TransitionFactory.mapOf('C'));
            MAP.put("REPLAC", TransitionFactory.mapOf('E'));
            MAP.get("REPLAC")
                    .put('I', new Transition('I', PlayerVerb.REPLACE, "I"));
            MAP.put("REPLACE", TransitionFactory.mapOf(PlayerVerb.REPLACE));
            MAP.put("RES", TransitionFactory.mapOf('O', 'T'));
            MAP.put("RESO", TransitionFactory.mapOf('L'));
            MAP.put("RESOL", TransitionFactory.mapOf('V'));
            MAP.put("RESOLV", TransitionFactory.mapOf('E'));
            MAP.put("RESOLVE", TransitionFactory.mapOf(SourceVerb.RESOLVE));
            MAP.put("REST", TransitionFactory.mapOf(Noun.REST));
            MAP.put("RET", TransitionFactory.mapOf('U'));
            MAP.put("RETU", TransitionFactory.mapOf('R'));
            MAP.put("RETUR", TransitionFactory.mapOf('N'));
            MAP.put("RETURN", TransitionFactory.mapOf(PlayerVerb.RETURN));
            MAP.put("RI", TransitionFactory.mapOf('G'));
            MAP.put("RIG", TransitionFactory.mapOf('H'));
            MAP.put("RIGH", TransitionFactory.mapOf('T'));
            MAP.put("RIGHT", TransitionFactory.mapOf(Particle.RIGHT));
            MAP.put("RO", TransitionFactory.mapOf('U'));
            MAP.put("ROU", TransitionFactory.mapOf('N'));
            MAP.put("ROUN", TransitionFactory.mapOf('D'));
            MAP.put("ROUND", TransitionFactory.mapOf('E'));
            MAP.put("ROUNDE", TransitionFactory.mapOf('D'));
            MAP.put("ROUNDED", TransitionFactory.mapOf(Adjective.ROUNDED));
        }
        return MAP;
    }
}
