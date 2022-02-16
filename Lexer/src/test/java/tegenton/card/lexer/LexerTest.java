package tegenton.card.lexer;

import org.junit.jupiter.api.Test;
import tegenton.card.json.JsonLoader;
import tegenton.card.json.model.SetJson;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {
    @Test
    void empty() {
        final String text = "";
        final List<Word> tokens = List.of();
        assertEquals(tokens, Lexer.lex(text));
    }

    @Test
    void singleWord() {
        final String text = "Target";
        final List<Word> tokens = List.of(Determiner.TARGET);
        assertEquals(tokens, Lexer.lex(text));
    }

    @Test
    void ancestralRecall() {
        final String text = "Target player draws three cards.";
        final List<Word> tokens =
                List.of(Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY,
                        Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW,
                        Symbol.SPACE, EnglishNumber.THREE, Symbol.SPACE,
                        ObjectNoun.CARD, Morpheme.S, Symbol.PERIOD);
        assertEquals(tokens, Lexer.lex(text));
    }

    @Test
    void alpha() throws IOException {
        final JsonLoader jsonLoader = new JsonLoader();
        final SetJson setJson = jsonLoader.loadSet("LEA");
        setJson.getCards().forEach(card -> {
            try {
                Lexer.lex(card.getProcessedText());
            } catch (final IllegalStateException e) {
                System.err.println("Card: " + card.getName());
                System.err.println("Text: " + card.getProcessedText());
                throw e;
            }
        });
    }
}
