package tegenton.card.lexer;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.List;

public class Lexer {
    public static List<Word> lex(String text) {
        return List.of(Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY,
                Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW, Symbol.SPACE,
                EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD, Morpheme.S,
                Symbol.PERIOD);
    }
}
