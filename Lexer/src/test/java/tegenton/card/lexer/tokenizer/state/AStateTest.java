package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.*;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.TriggerWord;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.TargetAdjective;
import tegenton.card.lexicon.game.target.TargetVerb;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Chronology;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.EnchantmentType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AStateTest {
    public static String input;
    public static Word expected;
    public static Tokenizer tokenizer;

    @BeforeEach
    void setup() {
        tokenizer = new Tokenizer();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, tokenizer.tokenize(input).get(0));
    }

    @Test
    void a() {
        input = "A";
        expected = Determiner.A;
    }

    @Test
    void ability() {
        input = "ABILITY";
        expected = GameNoun.ABILITY;
    }

    @Test
    void able() {
        input = "ABLE";
        expected = TargetAdjective.ABLE;
    }

    @Test
    void above() {
        input = "ABOVE";
        expected = Preposition.ABOVE;
    }

    @Test
    void activate() {
        input = "ACTIVATE";
        expected = PlayerVerb.ACTIVATE;
    }

    @Test
    void add() {
        input = "ADD";
        expected = PlayerVerb.ADD;
    }

    @Test
    void additional() {
        input = "ADDITIONAL";
        expected = Adjective.ADDITIONAL;
    }

    @Test
    void after() {
        input = "AFTER";
        expected = Chronology.AFTER;
    }

    @Test
    void all() {
        input = "ALL";
        expected = Determiner.ALL;
    }

    @Test
    void among() {
        input = "AMONG";
        expected = Preposition.AMONG;
    }

    @Test
    void amount() {
        input = "AMOUNT";
        expected = Noun.AMOUNT;
    }

    @Test
    void an() {
        input = "AN";
        expected = Determiner.AN;
    }

    @Test
    void and() {
        input = "AND";
        expected = Conjunction.AND;
    }

    @Test
    void ante() {
        input = "ANTE";
        expected = Zone.ANTE;
    }

    @Test
    void another() {
        input = "ANOTHER";
        expected = Determiner.ANOTHER;
    }

    @Test
    void any() {
        input = "ANY";
        expected = Determiner.ANY;
    }

    @Test
    void are() {
        input = "ARE";
        expected = ObjectVerb.IS;
    }

    @Test
    void artifact() {
        input = "ARTIFACT";
        expected = CardType.ARTIFACT;
    }

    @Test
    void as() {
        input = "AS";
        expected = SubordinateConjunction.AS;
    }

    @Test
    void assign() {
        input = "ASSIGN";
        expected = TargetVerb.ASSIGN;
    }

    @Test
    void at() {
        input = "AT";
        expected = TriggerWord.AT;
    }

    @Test
    void attach() {
        input = "ATTACH";
        expected = PlayerVerb.ATTACH;
    }

    @Test
    void attack() {
        input = "ATTACK";
        expected = ObjectVerb.ATTACK;
    }

    @Test
    void aura() {
        input = "AURA";
        expected = EnchantmentType.AURA;
    }

}
