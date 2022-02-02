package tegenton.card.lexer;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {
    @Test
    void empty() {
        String text = "";
        List<Word> tokens = List.of();
        assertEquals(tokens, Lexer.lex(text));
    }

    @Test
    void singleWord() {
        String text = "Target";
        List<Word> tokens = List.of(Determiner.TARGET);
        assertEquals(tokens, Lexer.lex(text));
    }

    @Test
    void ancestralRecall() {
        String text = "Target player draws three cards.";
        List<Word> tokens = List.of(Determiner.TARGET, Symbol.SPACE,
                PlayerVerb.PLAY, Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW,
                Symbol.SPACE, EnglishNumber.THREE, Symbol.SPACE,
                ObjectNoun.CARD, Morpheme.S, Symbol.PERIOD);
        assertEquals(tokens, Lexer.lex(text));
    }
}
