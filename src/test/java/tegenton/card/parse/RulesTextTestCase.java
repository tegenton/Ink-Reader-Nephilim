package tegenton.card.parse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.value.Number;

import java.util.List;

import static tegenton.card.parse.lexicon.Adjective.*;
import static tegenton.card.parse.lexicon.Adverb.*;
import static tegenton.card.parse.lexicon.Comparative.*;
import static tegenton.card.parse.lexicon.Conjunction.*;
import static tegenton.card.parse.lexicon.Determiner.*;
import static tegenton.card.parse.lexicon.Genitive.HALF;
import static tegenton.card.parse.lexicon.Morpheme.*;
import static tegenton.card.parse.lexicon.Noun.*;
import static tegenton.card.parse.lexicon.Particle.DOWN;
import static tegenton.card.parse.lexicon.Particle.UP;
import static tegenton.card.parse.lexicon.Preposition.*;
import static tegenton.card.parse.lexicon.Pronoun.SO;
import static tegenton.card.parse.lexicon.SubordinateConjunction.*;
import static tegenton.card.parse.lexicon.Symbol.MINUS;
import static tegenton.card.parse.lexicon.Symbol.*;
import static tegenton.card.parse.lexicon.game.Color.*;
import static tegenton.card.parse.lexicon.game.ColorWord.*;
import static tegenton.card.parse.lexicon.game.GameNoun.*;
import static tegenton.card.parse.lexicon.game.GameVerb.BE;
import static tegenton.card.parse.lexicon.game.GameVerb.FINISH;
import static tegenton.card.parse.lexicon.game.Keyword.*;
import static tegenton.card.parse.lexicon.game.Tap.T;
import static tegenton.card.parse.lexicon.game.TriggerWord.*;
import static tegenton.card.parse.lexicon.game.Zone.*;
import static tegenton.card.parse.lexicon.game.source.SourceNoun.SOURCE;
import static tegenton.card.parse.lexicon.game.source.SourceVerb.*;
import static tegenton.card.parse.lexicon.game.source.target.TargetAdjective.ABLE;
import static tegenton.card.parse.lexicon.game.source.target.TargetAuxiliaryVerb.CAN;
import static tegenton.card.parse.lexicon.game.source.target.TargetAuxiliaryVerb.WOULD;
import static tegenton.card.parse.lexicon.game.source.target.TargetModifier.POSSESSIVE;
import static tegenton.card.parse.lexicon.game.source.target.TargetNoun.THEY;
import static tegenton.card.parse.lexicon.game.source.target.TargetNoun.WHO;
import static tegenton.card.parse.lexicon.game.source.target.TargetVerb.GAIN;
import static tegenton.card.parse.lexicon.game.source.target.TargetVerb.LOSE;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectAdjective.TOP;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute.*;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun.*;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb.*;
import static tegenton.card.parse.lexicon.game.source.target.object.card.CardName.PLAGUE;
import static tegenton.card.parse.lexicon.game.source.target.object.card.CardName.RATS;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerAdjective.ACTIVE;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerAdjective.DEFENDING;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerAdverb.CONTINUOUSLY;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerAttribute.TOTAL;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerNoun.OPPONENT;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerNoun.YOU;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb.*;
import static tegenton.card.parse.lexicon.game.turn.Chronology.*;
import static tegenton.card.parse.lexicon.game.turn.Duration.*;
import static tegenton.card.parse.lexicon.game.turn.Phase.BEGINNING;
import static tegenton.card.parse.lexicon.game.turn.Phase.COMBAT;
import static tegenton.card.parse.lexicon.game.turn.Step.END;
import static tegenton.card.parse.lexicon.game.turn.Step.UPKEEP;
import static tegenton.card.parse.lexicon.game.type.CardType.*;
import static tegenton.card.parse.lexicon.game.type.CounterName.CORPSE;
import static tegenton.card.parse.lexicon.game.type.CreatureType.*;
import static tegenton.card.parse.lexicon.game.type.EnchantmentType.AURA;
import static tegenton.card.parse.lexicon.game.type.LandType.*;
import static tegenton.card.parse.lexicon.game.type.SuperType.BASIC;
import static tegenton.card.parse.lexicon.value.EnglishNumber.*;
import static tegenton.card.parse.lexicon.value.Variable.X;

public class RulesTextTestCase {
    public static String text;
    public static List<Word> tokens;

    @BeforeEach
    void setup() {
        text = null;
        tokens = null;
    }

    @Nested
    @DisplayName("Alpha")
    class LimitedEditionAlphaTests {
        @Nested
        @DisplayName("White cards")
        class WhiteCardTests {
            @Test
            @DisplayName("Animate Wall")
            void animateWall() {
                text = """
                        Enchant Wall
                        Enchanted Wall can attack as though it didn\u2019t have defender.""";
                tokens = List.of(ENCHANT, SPACE, WALL, NEWLINE,
                        ENCHANT, ED, SPACE, WALL, SPACE, CAN, SPACE, ATTACK, SPACE, AS, SPACE, THOUGH, SPACE, IT, SPACE, DO, NOT, SPACE, HAVE, SPACE, DEFENDER, PERIOD);
            }

            @Test
            @DisplayName("Armageddon")
            void armageddon() {
                text = "Destroy all lands.";
                tokens = List.of(DESTROY, SPACE, ALL, SPACE, LAND, S, PERIOD);
            }

            @Test
            @DisplayName("Balance")
            void balance() {
                text = "Each player chooses a number of lands they control equal to the number of lands controlled by the player who controls the fewest, then sacrifices the rest. Players discard cards and sacrifice creatures the same way.";
                tokens = List.of(EACH, SPACE, PLAY, ER, SPACE, CHOOSE, SPACE, A, SPACE, NUMBER, SPACE, OF, SPACE, LAND, S, SPACE, THEY, SPACE, CONTROL, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, NUMBER, SPACE, OF, SPACE, LAND, S, SPACE, CONTROL, ED, SPACE, BY, SPACE, THE, SPACE, PLAY, ER, SPACE, WHO, SPACE, CONTROL, SPACE, THE, SPACE, FEWEST, COMMA, SPACE, THEN, SPACE, SACRIFICE, SPACE, THE, SPACE, REST, PERIOD, SPACE,
                        PLAY, ER, S, SPACE, DISCARD, SPACE, CARD, S, SPACE, AND, SPACE, SACRIFICE, SPACE, CREATURE, S, SPACE, THE, SPACE, SAME, SPACE, WAY, PERIOD);
            }

            @Test
            @DisplayName("Benalish Hero")
            void benalishHero() {
                text = "Banding";
                tokens = List.of(BANDING);
            }

            @Test
            @DisplayName("Black Ward")
            void blackWard() {
                text = """
                        Enchant creature
                        Enchanted creature has protection from black. This effect doesn\u2019t remove ~.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, PROTECTION, SPACE, FROM, SPACE, BLACK, PERIOD,
                        SPACE, THIS, SPACE, EFFECT, SPACE, DO, NOT, SPACE, REMOVE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Blaze of Glory")
            void blazeOfGlory() {
                text = """
                        Cast this spell only during combat before blockers are declared.
                        Target creature defending player controls can block any number of creatures this turn. It blocks each attacking creature this turn if able.""";
                tokens = List.of(CAST, SPACE, THIS, SPACE, SPELL, SPACE, ONLY, SPACE, DURING, SPACE, COMBAT, SPACE, BEFORE, SPACE, BLOCK, ER, S, SPACE, IS, SPACE, DECLARE, ED, PERIOD, NEWLINE,
                        TARGET, SPACE, CREATURE, SPACE, DEFENDING, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, CAN, SPACE, BLOCK, SPACE, ANY, SPACE, NUMBER, SPACE, OF, SPACE, CREATURE, S, SPACE, THIS, SPACE, TURN, PERIOD, SPACE,
                        IT, SPACE, BLOCK, SPACE, EACH, SPACE, ATTACK, ING, SPACE, CREATURE, SPACE, THIS, SPACE, TURN, SPACE, IF, SPACE, ABLE, PERIOD);
            }

            @Test
            @DisplayName("Blessing")
            void blessing() {
                text = """
                        Enchant creature
                        {W}: Enchanted creature gets +1/+1 until end of turn.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        LBRACKET, W, RBRACKET, COLON, SPACE, ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, Number.ONE, SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Blue Ward")
            void blueWard() {
                text = """
                        Enchant creature
                        Enchanted creature has protection from blue. This effect doesn\u2019t remove ~.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, PROTECTION, SPACE, FROM, SPACE, BLUE, PERIOD,
                        SPACE, THIS, SPACE, EFFECT, SPACE, DO, NOT, SPACE, REMOVE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Castle")
            void castle() {
                text = "Untapped creatures you control get +0/+2.";
                tokens = List.of(NOT, TAP, ED, SPACE, CREATURE, S, SPACE, YOU, SPACE, CONTROL, SPACE, GET, SPACE, PLUS, new Number(0), SLASH, PLUS, Number.TWO, PERIOD);
            }

            @Test
            @DisplayName("Circle of Protection: Blue")
            void circleOfProtectionBlue() {
                text = "{1}: The next time a blue source of your choice would deal damage to you this turn, prevent that damage.";
                tokens = List.of(LBRACKET, Number.ONE, RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, TIME, SPACE, A, SPACE, BLUE, SPACE, SOURCE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, SPACE, WOULD, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, COMMA, SPACE, PREVENT, SPACE, THAT, SPACE, DAMAGE, PERIOD);
            }

            @Test
            @DisplayName("Circle of Protection: Green")
            void circleOfProtectionGreen() {
                text = "{1}: The next time a green source of your choice would deal damage to you this turn, prevent that damage.";
                tokens = List.of(LBRACKET, Number.ONE, RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, TIME, SPACE, A, SPACE, GREEN, SPACE, SOURCE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, SPACE, WOULD, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, COMMA, SPACE, PREVENT, SPACE, THAT, SPACE, DAMAGE, PERIOD);
            }

            @Test
            @DisplayName("Circle of Protection: Red")
            void circleOfProtectionRed() {
                text = "{1}: The next time a red source of your choice would deal damage to you this turn, prevent that damage.";
                tokens = List.of(LBRACKET, Number.ONE, RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, TIME, SPACE, A, SPACE, RED, SPACE, SOURCE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, SPACE, WOULD, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, COMMA, SPACE, PREVENT, SPACE, THAT, SPACE, DAMAGE, PERIOD);
            }

            @Test
            @DisplayName("Circle of Protection: White")
            void circleOfProtectionWhite() {
                text = "{1}: The next time a white source of your choice would deal damage to you this turn, prevent that damage.";
                tokens = List.of(LBRACKET, Number.ONE, RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, TIME, SPACE, A, SPACE, WHITE, SPACE, SOURCE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, SPACE, WOULD, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, COMMA, SPACE, PREVENT, SPACE, THAT, SPACE, DAMAGE, PERIOD);
            }

            @Test
            @DisplayName("Consecrate Land")
            void consecrateLand() {
                text = """
                        Enchant land
                        Enchanted land has indestructible and can\u2019t be enchanted by other Auras.""";
                tokens = List.of(ENCHANT, SPACE, LAND, NEWLINE,
                        ENCHANT, ED, SPACE, LAND, SPACE, HAVE, SPACE, INDESTRUCTIBLE, SPACE, AND, SPACE, CAN, NOT, SPACE, BE, SPACE, ENCHANT, ED, SPACE, BY, SPACE, OTHER, SPACE, AURA, S, PERIOD);
            }

            @Test
            @DisplayName("Conversion")
            void conversion() {
                text = """
                        At the beginning of your upkeep, sacrifice ~ unless you pay {W}{W}.
                        All Mountains are Plains.""";
                tokens = List.of(AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, UPKEEP, COMMA, SPACE, SACRIFICE, SPACE, TILDE, SPACE, UNLESS, SPACE, YOU, SPACE, PAY, SPACE, LBRACKET, W, RBRACKET, LBRACKET, W, RBRACKET, PERIOD, NEWLINE,
                        ALL, SPACE, MOUNTAIN, S, SPACE, IS, SPACE, PLAINS, PERIOD);
            }

            @Test
            @DisplayName("Crusade")
            void crusade() {
                text = "White creatures get +1/+1.";
                tokens = List.of(WHITE, SPACE, CREATURE, S, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, Number.ONE, PERIOD);
            }

            @Test
            @DisplayName("Death Ward")
            void deathWard() {
                text = "Regenerate target creature.";
                tokens = List.of(REGENERATE, SPACE, TARGET, SPACE, CREATURE, PERIOD);
            }

            @Test
            @DisplayName("Disenchant")
            void disenchant() {
                text = "Destroy target artifact or enchantment.";
                tokens = List.of(DESTROY, SPACE, TARGET, SPACE, ARTIFACT, SPACE, OR, SPACE, ENCHANTMENT, PERIOD);
            }

            @Test
            @DisplayName("Farmstead")
            void farmstead() {
                text = """
                        Enchant land
                        Enchanted land has \u201CAt the beginning of your upkeep, you may pay {W}{W}. If you do, you gain 1 life.\u201D""";
                tokens = List.of(ENCHANT, SPACE, LAND, NEWLINE,
                        ENCHANT, ED, SPACE, LAND, SPACE, HAVE, SPACE, OPENQUOTE, AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, UPKEEP, COMMA, SPACE, YOU, SPACE, MAY, SPACE, PAY, SPACE, LBRACKET, W, RBRACKET, LBRACKET, W, RBRACKET, PERIOD, SPACE,
                        IF, SPACE, YOU, SPACE, DO, COMMA, SPACE, YOU, SPACE, GAIN, SPACE, Number.ONE, SPACE, LIFE, PERIOD, CLOSEQUOTE);
            }

            @Test
            @DisplayName("Green Ward")
            void greenWard() {
                text = """
                        Enchant creature
                        Enchanted creature has protection from green. This effect doesn\u2019t remove ~.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, PROTECTION, SPACE, FROM, SPACE, GREEN, PERIOD,
                        SPACE, THIS, SPACE, EFFECT, SPACE, DO, NOT, SPACE, REMOVE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Guardian Angel")
            void guardianAngel() {
                text = "Prevent the next X damage that would be dealt to any target this turn. Until end of turn, you may pay {1} any time you could cast an instant. If you do, prevent the next 1 damage that would be dealt to that permanent or player this turn.";
                tokens = List.of(PREVENT, SPACE, THE, SPACE, NEXT, SPACE, X, SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, ANY, SPACE, TARGET, SPACE, THIS, SPACE, TURN, PERIOD, SPACE,
                        UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, COMMA, SPACE, YOU, SPACE, MAY, SPACE, PAY, SPACE, LBRACKET, Number.ONE, RBRACKET, SPACE, ANY, SPACE, TIME, SPACE, YOU, SPACE, COULD, SPACE, CAST, SPACE, AN, SPACE, INSTANT, PERIOD, SPACE,
                        IF, SPACE, YOU, SPACE, DO, COMMA, SPACE, PREVENT, SPACE, THE, SPACE, NEXT, SPACE, Number.ONE, SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, THAT, SPACE, PERMANENT, SPACE, OR, SPACE, PLAY, ER, SPACE, THIS, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Healing Salve")
            void healingSalve() {
                text = """
                        Choose one \u2014
                        \u2022 Target player gains 3 life.
                        \u2022 Prevent the next 3 damage that would be dealt to any target this turn.""";
                tokens = List.of(CHOOSE, SPACE, ONE, SPACE, DASH, NEWLINE,
                        BULLET, SPACE, TARGET, SPACE, PLAY, ER, SPACE, GAIN, SPACE, Number.THREE, SPACE, LIFE, PERIOD, NEWLINE,
                        BULLET, SPACE, PREVENT, SPACE, THE, SPACE, NEXT, SPACE, Number.THREE, SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, ANY, SPACE, TARGET, SPACE, THIS, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Holy Armor")
            void holyArmor() {
                text = """
                        Enchant creature
                        Enchanted creature gets +0/+2.
                        {W}: Enchanted creature gets +0/+1 until end of turn.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, new Number(0), SLASH, PLUS, Number.TWO, PERIOD, NEWLINE,
                        LBRACKET, W, RBRACKET, COLON, SPACE, ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, new Number(0), SLASH, PLUS, Number.ONE, SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Holy Strength")
            void holyStrength() {
                text = """
                        Enchant creature
                        Enchanted creature gets +1/+2.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, Number.TWO, PERIOD);
            }

            @Test
            @DisplayName("Island Sanctuary")
            void islandSanctuary() {
                text = "If you would draw a card during your draw step, instead you may skip that draw. If you do, until your next turn, you can\u2019t be attacked except by creatures with flying and/or islandwalk.";
                tokens = List.of(IF, SPACE, YOU, SPACE, WOULD, SPACE, DRAW, SPACE, A, SPACE, CARD, SPACE, DURING, SPACE, YOU, POSSESSIVE, SPACE, DRAW, SPACE, STEP, COMMA, SPACE, INSTEAD, SPACE, YOU, SPACE, MAY, SPACE, SKIP, SPACE, THAT, SPACE, DRAW, PERIOD, SPACE,
                        IF, SPACE, YOU, SPACE, DO, COMMA, SPACE, UNTIL, SPACE, YOU, POSSESSIVE, SPACE, NEXT, SPACE, TURN, COMMA, SPACE, YOU, SPACE, CAN, NOT, SPACE, BE, SPACE, ATTACK, ED, SPACE, EXCEPT, SPACE, BY, SPACE, CREATURE, S, SPACE, WITH, SPACE, FLYING, SPACE, AND, SLASH, OR, SPACE, ISLAND, WALK, PERIOD);
            }

            @Test
            @DisplayName("Karma")
            void karma() {
                text = "At the beginning of each player\u2019s upkeep, ~ deals damage to that player equal to the number of Swamps they control.";
                tokens = List.of(AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, EACH, SPACE, PLAY, ER, POSSESSIVE, SPACE, UPKEEP, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, PLAY, ER, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, NUMBER, SPACE, OF, SPACE, SWAMP, S, SPACE, THEY, SPACE, CONTROL, PERIOD);
            }

            @Test
            @DisplayName("Lance")
            void lance() {
                text = """
                        Enchant creature
                        Enchanted creature has first strike.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, FIRST, SPACE, STRIKE, PERIOD);
            }

            @Test
            @DisplayName("Mesa Pegasus")
            void mesaPegasus() {
                text = "Flying; banding";
                tokens = List.of(FLYING, SEMICOLON, SPACE, BANDING);
            }

            @Test
            @DisplayName("Northern Paladin")
            void northernPaladin() {
                text = "{W}{W}, {T}: Destroy target black permanent.";
                tokens = List.of(LBRACKET, W, RBRACKET, LBRACKET, W, RBRACKET, COMMA, SPACE, LBRACKET, T, RBRACKET, COLON, SPACE, DESTROY, SPACE, TARGET, SPACE, BLACK, SPACE, PERMANENT, PERIOD);
            }

            @Test
            @DisplayName("Pearled Unicorn")
            void pearledUnicorn() {
                text = "";
                tokens = List.of();
            }

            @Test
            @DisplayName("Personal Incarnation")
            void personalIncarnation() {
                text = """
                        {0}: The next 1 damage that would be dealt to ~ this turn is dealt to its owner instead. Only ~\u2019s owner may activate this ability.
                        When ~ dies, its owner loses half their life, rounded up.""";
                tokens = List.of(LBRACKET, new Number(0), RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, Number.ONE, SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, TILDE, SPACE, THIS, SPACE, TURN, SPACE, IS, SPACE, DEAL, ED, SPACE, TO, SPACE, IT, POSSESSIVE, SPACE, OWN, ER, SPACE, INSTEAD, PERIOD, SPACE,
                        ONLY, SPACE, TILDE, POSSESSIVE, SPACE, OWN, ER, SPACE, MAY, SPACE, ACTIVATE, SPACE, THIS, SPACE, ABILITY, PERIOD, NEWLINE,
                        WHEN, SPACE, TILDE, SPACE, DIE, COMMA, SPACE, IT, POSSESSIVE, SPACE, OWN, ER, SPACE, LOSE, SPACE, HALF, SPACE, THEY, POSSESSIVE, SPACE, LIFE, COMMA, SPACE, ROUNDED, SPACE, UP, PERIOD);
            }

            @Test
            @DisplayName("Purelace")
            void purelace() {
                text = "Target spell or permanent becomes white.";
                tokens = List.of(TARGET, SPACE, SPELL, SPACE, OR, SPACE, PERMANENT, SPACE, BECOME, SPACE, WHITE, PERIOD);
            }

            @Test
            @DisplayName("Red Ward")
            void redWard() {
                text = """
                        Enchant creature
                        Enchanted creature has protection from red. This effect doesn\u2019t remove ~.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, PROTECTION, SPACE, FROM, SPACE, RED, PERIOD,
                        SPACE, THIS, SPACE, EFFECT, SPACE, DO, NOT, SPACE, REMOVE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Resurrection")
            void resurrection() {
                text = "Return target creature card from your graveyard to the battlefield.";
                tokens = List.of(RETURN, SPACE, TARGET, SPACE, CREATURE, SPACE, CARD, SPACE, FROM, SPACE, YOU, POSSESSIVE, SPACE, GRAVEYARD, SPACE, TO, SPACE, THE, SPACE, BATTLEFIELD, PERIOD);
            }

            @Test
            @DisplayName("Reverse Damage")
            void reverseDamage() {
                text = "The next time a source of your choice would deal damage to you this turn, prevent that damage. You gain life equal to the damage prevented this way.";
                tokens = List.of(THE, SPACE, NEXT, SPACE, TIME, SPACE, A, SPACE, SOURCE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, SPACE, WOULD, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, COMMA, SPACE, PREVENT, SPACE, THAT, SPACE, DAMAGE, PERIOD, SPACE,
                        YOU, SPACE, GAIN, SPACE, LIFE, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, DAMAGE, SPACE, PREVENT, ED, SPACE, THIS, SPACE, WAY, PERIOD);
            }

            @Test
            @DisplayName("Righteousness")
            void righteousness() {
                text = "Target blocking creature gets +7/+7 until end of turn.";
                tokens = List.of(TARGET, SPACE, BLOCK, ING, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, new Number(7), SLASH, PLUS, new Number(7), SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Samite Healer")
            void samiteHealer() {
                text = "{T}: Prevent the next 1 damage that would be dealt to any target this turn.";
                tokens = List.of(LBRACKET, T, RBRACKET, COLON, SPACE, PREVENT, SPACE, THE, SPACE, NEXT, SPACE, Number.ONE, SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, ANY, SPACE, TARGET, SPACE, THIS, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Savannah Lions")
            void savannahLions() {
                text = "";
                tokens = List.of();
            }

            @Test
            @DisplayName("Serra Angel")
            void serraAngel() {
                text = "Flying, vigilance";
                tokens = List.of(FLYING, COMMA, SPACE, VIGILANCE);
            }

            @Test
            @DisplayName("Swords to Plowshares")
            void swordsToPlowshares() {
                text = "Exile target creature. Its controller gains life equal to its power.";
                tokens = List.of(EXILE, SPACE, TARGET, SPACE, CREATURE, PERIOD, SPACE,
                        IT, POSSESSIVE, SPACE, CONTROL, ER, SPACE, GAIN, SPACE, LIFE, SPACE, EQUAL, SPACE, TO, SPACE, IT, POSSESSIVE, SPACE, POWER, PERIOD);
            }

            @Test
            @DisplayName("Veteran Bodyguard")
            void veteranBodyguard() {
                text = "As long as ~ is untapped, all damage that would be dealt to you by unblocked creatures is dealt to ~ instead.";
                tokens = List.of(AS, SPACE, LONG, SPACE, AS, SPACE, TILDE, SPACE, IS, SPACE, NOT, TAP, ED, COMMA, SPACE, ALL, SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, YOU, SPACE, BY, SPACE, NOT, BLOCK, ED, SPACE, CREATURE, S, SPACE, IS, SPACE, DEAL, ED, SPACE, TO, SPACE, TILDE, SPACE, INSTEAD, PERIOD);
            }

            @Test
            @DisplayName("Wall of Swords")
            void wallOfSwords() {
                text = """
                        Defender
                        Flying""";
                tokens = List.of(DEFENDER, NEWLINE, FLYING);
            }

            @Test
            @DisplayName("White Knight")
            void whiteKnight() {
                text = """
                        First strike
                        Protection from black""";
                tokens = List.of(FIRST, SPACE, STRIKE, NEWLINE, PROTECTION, SPACE, FROM, SPACE, BLACK);
            }

            @Test
            @DisplayName("White Ward")
            void whiteWard() {
                text = """
                        Enchant creature
                        Enchanted creature has protection from white. This effect doesn\u2019t remove ~.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, PROTECTION, SPACE, FROM, SPACE, WHITE, PERIOD,
                        SPACE, THIS, SPACE, EFFECT, SPACE, DO, NOT, SPACE, REMOVE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Wrath of God")
            void wrathOfGod() {
                text = "Destroy all creatures. They can\u2019t be regenerated.";
                tokens = List.of(DESTROY, SPACE, ALL, SPACE, CREATURE, S, PERIOD, SPACE,
                        THEY, SPACE, CAN, NOT, SPACE, BE, SPACE, REGENERATE, ED, PERIOD);
            }
        }

        @Nested
        @DisplayName("Blue cards")
        class BlueCardTests {
            @Test
            @DisplayName("Air Elemental")
            void airElemental() {
                text = "Flying";
                tokens = List.of(FLYING);
            }

            @Test
            @DisplayName("Ancestral Recall")
            void ancestralRecall() {
                text = "Target player draws three cards.";
                tokens = List.of(TARGET, SPACE, PLAY, ER, SPACE, DRAW, SPACE, THREE, SPACE, CARD, S, PERIOD);
            }

            @Test
            @DisplayName("Animate Artifact")
            void animateArtifact() {
                text = """
                        Enchant artifact
                        As long as enchanted artifact isn\u2019t a creature, it\u2019s an artifact creature with power and toughness each equal to its mana value.""";
                tokens = List.of(ENCHANT, SPACE, ARTIFACT, NEWLINE,
                        AS, SPACE, LONG, SPACE, AS, SPACE, ENCHANT, ED, SPACE, ARTIFACT, SPACE, IS, NOT, SPACE, A, SPACE, CREATURE, COMMA, SPACE, IT, IS, SPACE, AN, SPACE, ARTIFACT, SPACE, CREATURE, SPACE, WITH, SPACE, POWER, SPACE, AND, SPACE, TOUGHNESS, SPACE, EACH, SPACE, EQUAL, SPACE, TO, SPACE, IT, POSSESSIVE, SPACE, MANA, SPACE, VALUE, PERIOD);
            }

            @Test
            @DisplayName("Blue Elemental Blast")
            void blueElementalBlast() {
                text = """
                        Choose one \u2014
                        \u2022 Counter target red spell.
                        \u2022 Destroy target red permanent.""";
                tokens = List.of(CHOOSE, SPACE, ONE, SPACE, DASH, NEWLINE,
                        BULLET, SPACE, COUNTER, SPACE, TARGET, SPACE, RED, SPACE, SPELL, PERIOD, NEWLINE,
                        BULLET, SPACE, DESTROY, SPACE, TARGET, SPACE, RED, SPACE, PERMANENT, PERIOD);
            }

            @Test
            @DisplayName("Braingeyser")
            void braingeyser() {
                text = "Target player draws X cards.";
                tokens = List.of(TARGET, SPACE, PLAY, ER, SPACE, DRAW, SPACE, X, SPACE, CARD, S, PERIOD);
            }

            @Test
            @DisplayName("Clone")
            void cloneTest() {
                text = "You may have ~ enter the battlefield as a copy of any creature on the battlefield.";
                tokens = List.of(YOU, SPACE, MAY, SPACE, HAVE, SPACE, TILDE, SPACE, ENTER, SPACE, THE, SPACE, BATTLEFIELD, SPACE, AS, SPACE, A, SPACE, COPY, SPACE, OF, SPACE, ANY, SPACE, CREATURE, SPACE, ON, SPACE, THE, SPACE, BATTLEFIELD, PERIOD);
            }

            @Test
            @DisplayName("Control Magic")
            void controlMagic() {
                text = """
                        Enchant creature
                        You control enchanted creature.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        YOU, SPACE, CONTROL, SPACE, ENCHANT, ED, SPACE, CREATURE, PERIOD);
            }

            @Test
            @DisplayName("Copy Artifact")
            void copyArtifact() {
                text = "You may have ~ enter the battlefield as a copy of any artifact on the battlefield, except it\u2019s an enchantment in addition to its other types.";
                tokens = List.of(YOU, SPACE, MAY, SPACE, HAVE, SPACE, TILDE, SPACE, ENTER, SPACE, THE, SPACE, BATTLEFIELD, SPACE, AS, SPACE, A, SPACE, COPY, SPACE, OF, SPACE, ANY, SPACE, ARTIFACT, SPACE, ON, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, EXCEPT, SPACE, IT, IS, SPACE, AN, SPACE, ENCHANTMENT, SPACE, IN, SPACE, ADDITION, SPACE, TO, SPACE, IT, POSSESSIVE, SPACE, OTHER, SPACE, TYPE, S, PERIOD);
            }

            @Test
            @DisplayName("Counterspell")
            void counterspell() {
                text = "Counter target spell.";
                tokens = List.of(COUNTER, SPACE, TARGET, SPACE, SPELL, PERIOD);
            }

            @Test
            @DisplayName("Creature Bond")
            void creatureBond() {
                text = """
                        Enchant creature
                        When enchanted creature dies, ~ deals damage equal to that creature\u2019s toughness to the creature\u2019s controller.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        WHEN, SPACE, ENCHANT, ED, SPACE, CREATURE, SPACE, DIE, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, DAMAGE, SPACE, EQUAL, SPACE, TO, SPACE, THAT, SPACE, CREATURE, POSSESSIVE, SPACE, TOUGHNESS, SPACE, TO, SPACE, THE, SPACE, CREATURE, POSSESSIVE, SPACE, CONTROL, ER, PERIOD);
            }

            @Test
            @DisplayName("Drain Power")
            void drainPower() {
                text = "Target player activates a mana ability of each land they control. Then that player loses all unspent mana and you add the mana lost this way.";
                tokens = List.of(TARGET, SPACE, PLAY, ER, SPACE, ACTIVATE, SPACE, A, SPACE, MANA, SPACE, ABILITY, SPACE, OF, SPACE, EACH, SPACE, LAND, SPACE, THEY, SPACE, CONTROL, PERIOD, SPACE, THEN, SPACE, THAT, SPACE, PLAY, ER, SPACE, LOSE, SPACE, ALL, SPACE, NOT, SPEND, ED, SPACE, MANA, SPACE, AND, SPACE, YOU, SPACE, ADD, SPACE, THE, SPACE, MANA, SPACE, LOSE, ED, SPACE, THIS, SPACE, WAY, PERIOD);
            }

            @Test
            @DisplayName("Feedback")
            void feedback() {
                text = """
                        Enchant enchantment
                        At the beginning of the upkeep of enchanted enchantment\u2019s controller, ~ deals 1 damage to that player.""";
                tokens = List.of(ENCHANT, SPACE, ENCHANTMENT, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, UPKEEP, SPACE, OF, SPACE, ENCHANT, ED, SPACE, ENCHANTMENT, POSSESSIVE, SPACE, CONTROL, ER, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, Number.ONE, SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, PLAY, ER, PERIOD);
            }

            @Test
            @DisplayName("Flight")
            void flight() {
                text = """
                        Enchant creature
                        Enchanted creature has flying.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, FLYING, PERIOD);
            }

            @Test
            @DisplayName("invisibility")
            void invisibility() {
                text = """
                        Enchant creature
                        Enchanted creature can\u2019t be blocked except by Walls.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, CAN, NOT, SPACE, BE, SPACE, BLOCK, ED, SPACE, EXCEPT, SPACE, BY, SPACE, WALL, S, PERIOD);
            }

            @Test
            @DisplayName("Jump")
            void jump() {
                text = "Target creature gains flying until end of turn.";
                tokens = List.of(TARGET, SPACE, CREATURE, SPACE, GAIN, SPACE, FLYING, SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Lifetap")
            void lifetap() {
                text = "Whenever a Forest an opponent controls becomes tapped, you gain 1 life.";
                tokens = List.of(WHENEVER, SPACE, A, SPACE, FOREST, SPACE, AN, SPACE, OPPONENT, SPACE, CONTROL, SPACE, BECOME, SPACE, TAP, ED, COMMA, SPACE, YOU, SPACE, GAIN, SPACE, Number.ONE, SPACE, LIFE, PERIOD);
            }

            @Test
            @DisplayName("Lord of Atlantis")
            void lordOfAtlantis() {
                text = "Other Merfolk get +1/+1 and have islandwalk.";
                tokens = List.of(OTHER, SPACE, MERFOLK, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, Number.ONE, SPACE, AND, SPACE, HAVE, SPACE, ISLAND, WALK, PERIOD);
            }

            @Test
            @DisplayName("Magical Hack")
            void magicalHack() {
                text = "Change the text of target spell or permanent by replacing all instances of one basic land type with another.";
                tokens = List.of(CHANGE, SPACE, THE, SPACE, TEXT, SPACE, OF, SPACE, TARGET, SPACE, SPELL, SPACE, OR, SPACE, PERMANENT, SPACE, BY, SPACE, REPLACE, ING, SPACE, ALL, SPACE, INSTANCE, S, SPACE, OF, SPACE, ONE, SPACE, BASIC, SPACE, LAND, SPACE, TYPE, SPACE, WITH, SPACE, ANOTHER, PERIOD);
            }

            @Test
            @DisplayName("Mahamoti Djinn")
            void mahamotiDjinn() {
                text = "Flying";
                tokens = List.of(FLYING);
            }

            @Test
            @DisplayName("Mana Short")
            void manaShort() {
                text = "Tap all lands target player controls and that player loses all unspent mana.";
                tokens = List.of(TAP, SPACE, ALL, SPACE, LAND, S, SPACE, TARGET, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, AND, SPACE, THAT, SPACE, PLAY, ER, SPACE, LOSE, SPACE, ALL, SPACE, NOT, SPEND, ED, SPACE, MANA, PERIOD);
            }

            @Test
            @DisplayName("Merfolk of the Pearl Trident")
            void merfolkOfThePearlTrident() {
                text = "";
                tokens = List.of();
            }

            @Test
            @DisplayName("Phantasmal Forces")
            void phantasmalForces() {
                text = """
                        Flying
                        At the beginning of your upkeep, sacrifice ~ unless you pay {U}.""";
                tokens = List.of(FLYING, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, UPKEEP, COMMA, SPACE, SACRIFICE, SPACE, TILDE, SPACE, UNLESS, SPACE, YOU, SPACE, PAY, SPACE, LBRACKET, U, RBRACKET, PERIOD);
            }

            @Test
            @DisplayName("Phantasmal Terrain")
            void phantasmalTerrain() {
                text = """
                        Enchant land
                        As ~ enters the battlefield, choose a basic land type.
                        Enchanted land is the chosen type.""";
                tokens = List.of(ENCHANT, SPACE, LAND, NEWLINE,
                        AS, SPACE, TILDE, SPACE, ENTER, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, CHOOSE, SPACE, A, SPACE, BASIC, SPACE, LAND, SPACE, TYPE, PERIOD, NEWLINE,
                        ENCHANT, ED, SPACE, LAND, SPACE, IS, SPACE, THE, SPACE, CHOSEN, SPACE, TYPE, PERIOD);
            }

            @Test
            @DisplayName("Pirate Ship")
            void pirateShip() {
                text = """
                        ~ can\u2019t attack unless defending player controls an Island.
                        {T}: ~ deals 1 damage to any target.
                        When you control no Islands, sacrifice ~.""";
                tokens = List.of(TILDE, SPACE, CAN, NOT, SPACE, ATTACK, SPACE, UNLESS, SPACE, DEFENDING, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, AN, SPACE, ISLAND, PERIOD, NEWLINE,
                        LBRACKET, T, RBRACKET, COLON, SPACE, TILDE, SPACE, DEAL, SPACE, Number.ONE, SPACE, DAMAGE, SPACE, TO, SPACE, ANY, SPACE, TARGET, PERIOD, NEWLINE,
                        WHEN, SPACE, YOU, SPACE, CONTROL, SPACE, NO, SPACE, ISLAND, S, COMMA, SPACE, SACRIFICE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Power Leak")
            void powerLead() {
                text = """
                        Enchant enchantment
                        At the beginning of the upkeep of enchanted enchantment\u2019s controller, that player may pay any amount of mana. ~ deals 2 damage to that player. Prevent X of that damage, where X is the amount of mana that player paid this way.""";
                tokens = List.of(ENCHANT, SPACE, ENCHANTMENT, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, UPKEEP, SPACE, OF, SPACE, ENCHANT, ED, SPACE, ENCHANTMENT, POSSESSIVE, SPACE, CONTROL, ER, COMMA, SPACE, THAT, SPACE, PLAY, ER, SPACE, MAY, SPACE, PAY, SPACE, ANY, SPACE, AMOUNT, SPACE, OF, SPACE, MANA, PERIOD, SPACE,
                        TILDE, SPACE, DEAL, SPACE, Number.TWO, SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, PLAY, ER, PERIOD, SPACE,
                        PREVENT, SPACE, X, SPACE, OF, SPACE, THAT, SPACE, DAMAGE, COMMA, SPACE, WHERE, SPACE, X, SPACE, IS, SPACE, THE, SPACE, AMOUNT, SPACE, OF, SPACE, MANA, SPACE, THAT, SPACE, PLAY, ER, SPACE, PAY, ED, SPACE, THIS, SPACE, WAY, PERIOD);
            }

            @Test
            @DisplayName("Power Sink")
            void powerSink() {
                text = "Counter target spell unless its controller pays {X}. If that player doesn\u2019t, they tap all lands with mana abilities they control and lose all unspent mana.";
                tokens = List.of(COUNTER, SPACE, TARGET, SPACE, SPELL, SPACE, UNLESS, SPACE, IT, POSSESSIVE, SPACE, CONTROL, ER, SPACE, PAY, SPACE, LBRACKET, X, RBRACKET, PERIOD, SPACE, IF, SPACE, THAT, SPACE, PLAY, ER, SPACE, DO, NOT, COMMA, SPACE, THEY, SPACE, TAP, SPACE, ALL, SPACE, LAND, S, SPACE, WITH, SPACE, MANA, SPACE, ABILITY, S, SPACE, THEY, SPACE, CONTROL, SPACE, AND, SPACE, LOSE, SPACE, ALL, SPACE, NOT, SPEND, ED, SPACE, MANA, PERIOD);
            }

            @Test
            @DisplayName("Prodigal Sorcerer")
            void prodigalSorcerer() {
                text = "{T}: ~ deals 1 damage to any target.";
                tokens = List.of(LBRACKET, T, RBRACKET, COLON, SPACE, TILDE, SPACE, DEAL, SPACE, Number.ONE, SPACE, DAMAGE, SPACE, TO, SPACE, ANY, SPACE, TARGET, PERIOD);
            }

            @Test
            @DisplayName("Psionic Blast")
            void psionicBlast() {
                text = "~ deals 4 damage to any target and 2 damage to you.";
                tokens = List.of(TILDE, SPACE, DEAL, SPACE, Number.FOUR, SPACE, DAMAGE, SPACE, TO, SPACE, ANY, SPACE, TARGET, SPACE, AND, SPACE, Number.TWO, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, PERIOD);
            }

            @Test
            @DisplayName("Psychic Venom")
            void psychicVenom() {
                text = """
                        Enchant land
                        Whenever enchanted land becomes tapped, ~ deals 2 damage to that land\u2019s controller.""";
                tokens = List.of(ENCHANT, SPACE, LAND, NEWLINE,
                        WHENEVER, SPACE, ENCHANT, ED, SPACE, LAND, SPACE, BECOME, SPACE, TAP, ED, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, Number.TWO, SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, LAND, POSSESSIVE, SPACE, CONTROL, ER, PERIOD);
            }

            @Test
            @DisplayName("Sea Serpent")
            void seaSerpent() {
                text = """
                        ~ can\u2019t attack unless defending player controls an Island.
                        When you control no Islands, sacrifice ~.""";
                tokens = List.of(TILDE, SPACE, CAN, NOT, SPACE, ATTACK, SPACE, UNLESS, SPACE, DEFENDING, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, AN, SPACE, ISLAND, PERIOD, NEWLINE,
                        WHEN, SPACE, YOU, SPACE, CONTROL, SPACE, NO, SPACE, ISLAND, S, COMMA, SPACE, SACRIFICE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Siren's Call")
            void sirensCall() {
                text = """
                        Cast this spell only during an opponent\u2019s turn, before attackers are declared.
                        Creatures the active player controls attack this turn if able.
                        At the beginning of the next end step, destroy all non-Wall creatures that player controls that didn\u2019t attack this turn. Ignore this effect for each creature the player didn\u2019t control continuously since the beginning of the turn.""";
                tokens = List.of(CAST, SPACE, THIS, SPACE, SPELL, SPACE, ONLY, SPACE, DURING, SPACE, AN, SPACE, OPPONENT, POSSESSIVE, SPACE, TURN, COMMA, SPACE, BEFORE, SPACE, ATTACK, S, SPACE, IS, SPACE, DECLARE, ED, PERIOD, NEWLINE,
                        CREATURE, S, SPACE, THE, SPACE, ACTIVE, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, ATTACK, SPACE, THIS, SPACE, TURN, SPACE, IF, SPACE, ABLE, PERIOD, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, NEXT, SPACE, END, SPACE, STEP, COMMA, SPACE, DESTROY, SPACE, ALL, SPACE, NOT, MINUS, WALL, SPACE, CREATURE, S, SPACE, THAT, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, THAT, SPACE, DO, NOT, SPACE, ATTACK, SPACE, THIS, SPACE, TURN, PERIOD, SPACE, IGNORE, SPACE, THIS, SPACE, EFFECT, SPACE, FOR, SPACE, EACH, SPACE, CREATURE, SPACE, THE, SPACE, PLAY, ER, SPACE, DO, NOT, SPACE, CONTROL, SPACE, CONTINUOUSLY, SPACE, SINCE, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Sleight of Mind")
            void sleightOfMind() {
                text = "Change the text of target spell or permanent by replacing all instances of one color word with another.";
                tokens = List.of(CHANGE, SPACE, THE, SPACE, TEXT, SPACE, OF, SPACE, TARGET, SPACE, SPELL, SPACE, OR, SPACE, PERMANENT, SPACE, BY, SPACE, REPLACE, ING, SPACE, ALL, SPACE, INSTANCE, S, SPACE, OF, SPACE, ONE, SPACE, COLOR, SPACE, WORD, SPACE, WITH, SPACE, ANOTHER, PERIOD);
            }

            @Test
            @DisplayName("Spell Blast")
            void spellBlast() {
                text = "Counter target spell with mana value X.";
                tokens = List.of(COUNTER, SPACE, TARGET, SPACE, SPELL, SPACE, WITH, SPACE, MANA, SPACE, VALUE, SPACE, X, PERIOD);
            }

            @Test
            @DisplayName("Stasis")
            void stasis() {
                text = """
                        Players skip their untap steps.
                        At the beginning of your upkeep, sacrifice ~ unless you pay {U}.""";
                tokens = List.of(PLAY, ER, S, SPACE, SKIP, SPACE, THEY, POSSESSIVE, SPACE, NOT, TAP, SPACE, STEP, S, PERIOD, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, UPKEEP, COMMA, SPACE, SACRIFICE, SPACE, TILDE, SPACE, UNLESS, SPACE, YOU, SPACE, PAY, SPACE, LBRACKET, U, RBRACKET, PERIOD);
            }

            @Test
            @DisplayName("Steal Artifact")
            void stealArtifact() {
                text = """
                        Enchant artifact
                        You control enchanted artifact.""";
                tokens = List.of(ENCHANT, SPACE, ARTIFACT, NEWLINE,
                        YOU, SPACE, CONTROL, SPACE, ENCHANT, ED, SPACE, ARTIFACT, PERIOD);
            }

            @Test
            @DisplayName("Thoughtlace")
            void thoughtlace() {
                text = "Target spell or permanent becomes blue.";
                tokens = List.of(TARGET, SPACE, SPELL, SPACE, OR, SPACE, PERMANENT, SPACE, BECOME, SPACE, BLUE, PERIOD);
            }

            @Test
            @DisplayName("Time Walk")
            void timeWalk() {
                text = "Take an extra turn after this one.";
                tokens = List.of(TAKE, SPACE, AN, SPACE, EXTRA, SPACE, TURN, SPACE, AFTER, SPACE, THIS, SPACE, ONE, PERIOD);
            }

            @Test
            @DisplayName("Timetwister")
            void timeTwister() {
                text = "Each player shuffles their hand and graveyard into their library, then draws seven cards.";
                tokens = List.of(EACH, SPACE, PLAY, ER, SPACE, SHUFFLE, SPACE, THEY, POSSESSIVE, SPACE, HAND, SPACE, AND, SPACE, GRAVEYARD, SPACE, IN, TO, SPACE, THEY, POSSESSIVE, SPACE, LIBRARY, COMMA, SPACE, THEN, SPACE, DRAW, SPACE, SEVEN, SPACE, CARD, S, PERIOD);
            }

            @Test
            @DisplayName("Twiddle")
            void twiddle() {
                text = "You may tap or untap target artifact, creature, or land.";
                tokens = List.of(YOU, SPACE, MAY, SPACE, TAP, SPACE, OR, SPACE, NOT, TAP, SPACE, TARGET, SPACE, ARTIFACT, COMMA, SPACE, CREATURE, COMMA, SPACE, OR, SPACE, LAND, PERIOD);
            }

            @Test
            @DisplayName("Unsummon")
            void unsummon() {
                text = "Return target creature to its owner\u2019s hand.";
                tokens = List.of(RETURN, SPACE, TARGET, SPACE, CREATURE, SPACE, TO, SPACE, IT, POSSESSIVE, SPACE, OWN, ER, POSSESSIVE, SPACE, HAND, PERIOD);
            }

            @Test
            @DisplayName("Vesuvan Doppleganger")
            void vesuvanDoppleganger() {
                text = "You may have ~ enter the battlefield as a copy of any creature on the battlefield, except it doesn\u2019t copy that creature\u2019s color and it has \u201CAt the beginning of your upkeep, you may have this creature become a copy of target creature, except it doesn\u2019t copy that creature\u2019s color and it has this ability.\u201D";
                tokens = List.of(YOU, SPACE, MAY, SPACE, HAVE, SPACE, TILDE, SPACE, ENTER, SPACE, THE, SPACE, BATTLEFIELD, SPACE, AS, SPACE, A, SPACE, COPY, SPACE, OF, SPACE, ANY, SPACE, CREATURE, SPACE, ON, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, EXCEPT, SPACE, IT, SPACE, DO, NOT, SPACE, COPY, SPACE, THAT, SPACE, CREATURE, POSSESSIVE, SPACE, COLOR, SPACE, AND, SPACE, IT, SPACE, HAVE, SPACE, OPENQUOTE, AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, UPKEEP, COMMA, SPACE, YOU, SPACE, MAY, SPACE, HAVE, SPACE, THIS, SPACE, CREATURE, SPACE, BECOME, SPACE, A, SPACE, COPY, SPACE, OF, SPACE, TARGET, SPACE, CREATURE, COMMA, SPACE, EXCEPT, SPACE, IT, SPACE, DO, NOT, SPACE, COPY, SPACE, THAT, SPACE, CREATURE, POSSESSIVE, SPACE, COLOR, SPACE, AND, SPACE, IT, SPACE, HAVE, SPACE, THIS, SPACE, ABILITY, PERIOD, CLOSEQUOTE);
            }

            @Test
            @DisplayName("volcanic Eruption")
            void volcanicEruption() {
                text = "Destroy X target Mountains. ~ deals damage to each creature and each player equal to the number of Mountains put into a graveyard this way.";
                tokens = List.of(DESTROY, SPACE, X, SPACE, TARGET, SPACE, MOUNTAIN, S, PERIOD, SPACE, TILDE, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, EACH, SPACE, CREATURE, SPACE, AND, SPACE, EACH, SPACE, PLAY, ER, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, NUMBER, SPACE, OF, SPACE, MOUNTAIN, S, SPACE, PUT, SPACE, IN, TO, SPACE, A, SPACE, GRAVEYARD, SPACE, THIS, SPACE, WAY, PERIOD);
            }

            @Test
            @DisplayName("Wall of Air")
            void wallOfAir() {
                text = "Defender, flying";
                tokens = List.of(DEFENDER, COMMA, SPACE, FLYING);
            }

            @Test
            @DisplayName("Wall of Water")
            void wallOfWater() {
                text = """
                        Defender
                        {U}: ~ gets +1/+0 until end of turn.""";
                tokens = List.of(DEFENDER, NEWLINE,
                        LBRACKET, U, RBRACKET, COLON, SPACE, TILDE, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, new Number(0), SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Water Elemental")
            void waterElemental() {
                text = "";
                tokens = List.of();
            }
        }

        @Nested
        @DisplayName("Black Cards")
        class BlackCardTests {
            @Test
            @DisplayName("Animate Dead")
            void animateDead() {
                text = """
                        Enchant creature card in a graveyard
                        When ~ enters the battlefield, if it\u2019s on the battlefield, it loses \u201Cenchant creature card in a graveyard\u201D and gains \u201Cenchant creature put onto the battlefield with ~.\u201D Return enchanted creature card to the battlefield under your control and attach ~ to it. When ~ leaves the battlefield, that creature\u2019s controller sacrifices it.
                        Enchanted creature gets -1/-0.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, SPACE, CARD, SPACE, IN, SPACE, A, SPACE, GRAVEYARD, NEWLINE,
                        WHEN, SPACE, TILDE, SPACE, ENTER, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, IF, SPACE, IT, IS, SPACE, ON, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, IT, SPACE, LOSE, SPACE, OPENQUOTE, ENCHANT, SPACE, CREATURE, SPACE, CARD, SPACE, IN, SPACE, A, SPACE, GRAVEYARD, CLOSEQUOTE, SPACE, AND, SPACE, GAIN, SPACE, OPENQUOTE, ENCHANT, SPACE, CREATURE, SPACE, PUT, SPACE, ON, TO, SPACE, THE, SPACE, BATTLEFIELD, SPACE, WITH, SPACE, TILDE, PERIOD, CLOSEQUOTE, SPACE, RETURN, SPACE, ENCHANT, ED, SPACE, CREATURE, SPACE, CARD, SPACE, TO, SPACE, THE, SPACE, BATTLEFIELD, SPACE, UNDER, SPACE, YOU, POSSESSIVE, SPACE, CONTROL, SPACE, AND, SPACE, ATTACH, SPACE, TILDE, SPACE, TO, SPACE, IT, PERIOD, SPACE, WHEN, SPACE, TILDE, SPACE, LEAVE, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, THAT, SPACE, CREATURE, POSSESSIVE, SPACE, CONTROL, ER, SPACE, SACRIFICE, SPACE, IT, PERIOD, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, MINUS, Number.ONE, SLASH, MINUS, new Number(0), PERIOD);
            }

            @Test
            @DisplayName("Bad Moon")
            void badMoon() {
                text = "Black creatures get +1/+1.";
                tokens = List.of(BLACK, SPACE, CREATURE, S, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, Number.ONE, PERIOD);
            }

            @Test
            @DisplayName("Black Knight")
            void blackKnight() {
                text = """
                        First strike
                        Protection from white""";
                tokens = List.of(FIRST, SPACE, STRIKE, NEWLINE,
                        PROTECTION, SPACE, FROM, SPACE, WHITE);
            }

            @Test
            @DisplayName("Bog Wraith")
            void bogWraith() {
                text = "Swampwalk";
                tokens = List.of(SWAMP, WALK);
            }

            @Test
            @DisplayName("Contract from Below")
            void contractFromBelow() {
                text = """
                        Remove ~ from your deck before playing if you\u2019re not playing for ante.
                        Discard your hand, ante the top card of your library, then draw seven cards.""";
                tokens = List.of(REMOVE, SPACE, TILDE, SPACE, FROM, SPACE, YOU, POSSESSIVE, SPACE, DECK, SPACE, BEFORE, SPACE, PLAY, ING, SPACE, IF, SPACE, YOU, IS, SPACE, NOT, SPACE, PLAY, ING, SPACE, FOR, SPACE, ANTE, PERIOD, NEWLINE,
                        DISCARD, SPACE, YOU, POSSESSIVE, SPACE, HAND, COMMA, SPACE, ANTE, SPACE, THE, SPACE, TOP, SPACE, CARD, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, LIBRARY, COMMA, SPACE, THEN, SPACE, DRAW, SPACE, SEVEN, SPACE, CARD, S, PERIOD);
            }

            @Test
            @DisplayName("Cursed Land")
            void cursedLand() {
                text = """
                        Enchant land
                        At the beginning of the upkeep of enchanted land\u2019s controller, ~ deals 1 damage to that player.""";
                tokens = List.of(ENCHANT, SPACE, LAND, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, UPKEEP, SPACE, OF, SPACE, ENCHANT, ED, SPACE, LAND, POSSESSIVE, SPACE, CONTROL, ER, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, Number.ONE, SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, PLAY, ER, PERIOD);
            }

            @Test
            @DisplayName("Dark Ritual")
            void darkRitual() {
                text = "Add {B}{B}{B}.";
                tokens = List.of(ADD, SPACE, LBRACKET, B, RBRACKET, LBRACKET, B, RBRACKET, LBRACKET, B, RBRACKET, PERIOD);
            }

            @Test
            @DisplayName("Darkpact")
            void darkpact() {
                text = """
                        Remove ~ from your deck before playing if you\u2019re not playing for ante.
                        You own target card in the ante. Exchange that card with the top card of your library.""";
                tokens = List.of(REMOVE, SPACE, TILDE, SPACE, FROM, SPACE, YOU, POSSESSIVE, SPACE, DECK, SPACE, BEFORE, SPACE, PLAY, ING, SPACE, IF, SPACE, YOU, IS, SPACE, NOT, SPACE, PLAY, ING, SPACE, FOR, SPACE, ANTE, PERIOD, NEWLINE,
                        YOU, SPACE, OWN, SPACE, TARGET, SPACE, CARD, SPACE, IN, SPACE, THE, SPACE, ANTE, PERIOD, SPACE, EXCHANGE, SPACE, THAT, SPACE, CARD, SPACE, WITH, SPACE, THE, SPACE, TOP, SPACE, CARD, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, LIBRARY, PERIOD);
            }

            @Test
            @DisplayName("Deathgrip")
            void deathgrip() {
                text = "{B}{B}: Counter target green spell.";
                tokens = List.of(LBRACKET, B, RBRACKET, LBRACKET, B, RBRACKET, COLON, SPACE, COUNTER, SPACE, TARGET, SPACE, GREEN, SPACE, SPELL, PERIOD);
            }

            @Test
            @DisplayName("Deathlace")
            void deathlace() {
                text = "Target spell or permanent becomes black.";
                tokens = List.of(TARGET, SPACE, SPELL, SPACE, OR, SPACE, PERMANENT, SPACE, BECOME, SPACE, BLACK, PERIOD);
            }

            @Test
            @DisplayName("Demonic Attorney")
            void demonicAttorney() {
                text = """
                        Remove ~ from your deck before playing if you\u2019re not playing for ante.
                        Each player antes the top card of their library.""";
                tokens = List.of(REMOVE, SPACE, TILDE, SPACE, FROM, SPACE, YOU, POSSESSIVE, SPACE, DECK, SPACE, BEFORE, SPACE, PLAY, ING, SPACE, IF, SPACE, YOU, IS, SPACE, NOT, SPACE, PLAY, ING, SPACE, FOR, SPACE, ANTE, PERIOD, NEWLINE,
                        EACH, SPACE, PLAY, ER, SPACE, ANTE, SPACE, THE, SPACE, TOP, SPACE, CARD, SPACE, OF, SPACE, THEY, POSSESSIVE, SPACE, LIBRARY, PERIOD);
            }

            @Test
            @DisplayName("Demonic Hordes")
            void demonicHordes() {
                text = """
                        {T}: Destroy target land.
                        At the beginning of your upkeep, unless you pay {B}{B}{B}, tap ~ and sacrifice a land of an opponent\u2019s choice.""";
                tokens = List.of(LBRACKET, T, RBRACKET, COLON, SPACE, DESTROY, SPACE, TARGET, SPACE, LAND, PERIOD, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, UPKEEP, COMMA, SPACE, UNLESS, SPACE, YOU, SPACE, PAY, SPACE, LBRACKET, B, RBRACKET, LBRACKET, B, RBRACKET, LBRACKET, B, RBRACKET, COMMA, SPACE, TAP, SPACE, TILDE, SPACE, AND, SPACE, SACRIFICE, SPACE, A, SPACE, LAND, SPACE, OF, SPACE, AN, SPACE, OPPONENT, POSSESSIVE, SPACE, CHOICE, PERIOD);
            }

            @Test
            @DisplayName("Demonic Tutor")
            void demonicTutor() {
                text = "Search your library for a card, put that card into your hand, then shuffle.";
                tokens = List.of(SEARCH, SPACE, YOU, POSSESSIVE, SPACE, LIBRARY, SPACE, FOR, SPACE, A, SPACE, CARD, COMMA, SPACE, PUT, SPACE, THAT, SPACE, CARD, SPACE, IN, TO, SPACE, YOU, POSSESSIVE, SPACE, HAND, COMMA, SPACE, THEN, SPACE, SHUFFLE, PERIOD);
            }

            @Test
            @DisplayName("Drain Life")
            void drainLife() {
                text = """
                        Spend only black mana on X.
                        ~ deals X damage to any target. You gain life equal to the damage dealt, but not more life than the player\u2019s life total before the damage was dealt, the planeswalker\u2019s loyalty before the damage was dealt, or the creature\u2019s toughness.""";
                tokens = List.of(SPEND, SPACE, ONLY, SPACE, BLACK, SPACE, MANA, SPACE, ON, SPACE, X, PERIOD, NEWLINE,
                        TILDE, SPACE, DEAL, SPACE, X, SPACE, DAMAGE, SPACE, TO, SPACE, ANY, SPACE, TARGET, PERIOD, SPACE, YOU, SPACE, GAIN, SPACE, LIFE, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, DAMAGE, SPACE, DEAL, ED, COMMA, SPACE, BUT, SPACE, NOT, SPACE, MORE, SPACE, LIFE, SPACE, THAN, SPACE, THE, SPACE, PLAY, ER, POSSESSIVE, SPACE, LIFE, SPACE, TOTAL, SPACE, BEFORE, SPACE, THE, SPACE, DAMAGE, SPACE, IS, ED, SPACE, DEAL, ED, COMMA, SPACE, THE, SPACE, POSSESSIVE, SPACE, LOYALTY, SPACE, BEFORE, SPACE, THE, SPACE, DAMAGE, SPACE, IS, ED, SPACE, DEAL, ED, COMMA, SPACE, OR, SPACE, THE, SPACE, CREATURE, POSSESSIVE, SPACE, TOUGHNESS, PERIOD);
            }

            @Test
            @DisplayName("Drudge Skeletons")
            void drudgeSkeletons() {
                text = "{B}: Regenerate ~.";
                tokens = List.of(LBRACKET, B, RBRACKET, COLON, SPACE, REGENERATE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Evil Presence")
            void evilPresence() {
                text = """
                        Enchant land
                        Enchanted land is a Swamp.""";
                tokens = List.of(ENCHANT, SPACE, LAND, NEWLINE,
                        ENCHANT, ED, SPACE, LAND, SPACE, IS, SPACE, A, SPACE, SWAMP, PERIOD);
            }

            @Test
            @DisplayName("Fear")
            void fear() {
                text = """
                        Enchant creature
                        Enchanted creature has fear.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, FEAR, PERIOD);
            }

            @Test
            @DisplayName("Frozen Shade")
            void frozenShade() {
                text = "{B}: ~ gets +1/+1 until end of turn.";
                tokens = List.of(LBRACKET, B, RBRACKET, COLON, SPACE, TILDE, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, Number.ONE, SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Gloom")
            void gloom() {
                text = """
                        White spells cost {3} more to cast.
                        Activated abilities of white enchantments cost {3} more to activate.""";
                tokens = List.of(WHITE, SPACE, SPELL, S, SPACE, COST, SPACE, LBRACKET, Number.THREE, RBRACKET, SPACE, MORE, SPACE, TO, SPACE, CAST, PERIOD, NEWLINE,
                        ACTIVATE, ED, SPACE, ABILITY, S, SPACE, OF, SPACE, WHITE, SPACE, ENCHANTMENT, S, SPACE, COST, SPACE, LBRACKET, Number.THREE, RBRACKET, SPACE, MORE, SPACE, TO, SPACE, ACTIVATE, PERIOD);
            }

            @Test
            @DisplayName("Howl from Beyond")
            void howlFromBeyond() {
                text = "Target creature gets +X/+0 until end of turn.";
                tokens = List.of(TARGET, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, X, SLASH, PLUS, new Number(0), SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Hypnotic Specter")
            void hypnoticSpecter() {
                text = """
                        Flying
                        Whenever ~ deals damage to an opponent, that player discards a card at random.""";
                tokens = List.of(FLYING, NEWLINE,
                        WHENEVER, SPACE, TILDE, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, AN, SPACE, OPPONENT, COMMA, SPACE, THAT, SPACE, PLAY, ER, SPACE, DISCARD, SPACE, A, SPACE, CARD, SPACE, AT, SPACE, RANDOM, PERIOD);
            }

            @Test
            @DisplayName("Lich")
            void lich() {
                text = """
                        As ~ enters the battlefield, you lose life equal to your life total.
                        You don\u2019t lose the game for having 0 or less life.
                        If you would gain life, draw that many cards instead.
                        Whenever you\u2019re dealt damage, sacrifice that many nontoken permanents. If you can\u2019t, you lose the game.
                        When ~ is put into a graveyard from the battlefield, you lose the game.""";
                tokens = List.of(AS, SPACE, TILDE, SPACE, ENTER, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, YOU, SPACE, LOSE, SPACE, LIFE, SPACE, EQUAL, SPACE, TO, SPACE, YOU, POSSESSIVE, SPACE, LIFE, SPACE, TOTAL, PERIOD, NEWLINE,
                        YOU, SPACE, DO, NOT, SPACE, LOSE, SPACE, THE, SPACE, GAME, SPACE, FOR, SPACE, HAVE, ING, SPACE, new Number(0), SPACE, OR, SPACE, LESS, SPACE, LIFE, PERIOD, NEWLINE,
                        IF, SPACE, YOU, SPACE, WOULD, SPACE, GAIN, SPACE, LIFE, COMMA, SPACE, DRAW, SPACE, THAT, SPACE, MANY, SPACE, CARD, S, SPACE, INSTEAD, PERIOD, NEWLINE,
                        WHENEVER, SPACE, YOU, IS, SPACE, DEAL, ED, SPACE, DAMAGE, COMMA, SPACE, SACRIFICE, SPACE, THAT, SPACE, MANY, SPACE, NOT, TOKEN, SPACE, PERMANENT, S, PERIOD, SPACE, IF, SPACE, YOU, SPACE, CAN, NOT, COMMA, SPACE, YOU, SPACE, LOSE, SPACE, THE, SPACE, GAME, PERIOD, NEWLINE,
                        WHEN, SPACE, TILDE, SPACE, IS, SPACE, PUT, SPACE, IN, TO, SPACE, A, SPACE, GRAVEYARD, SPACE, FROM, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, YOU, SPACE, LOSE, SPACE, THE, SPACE, GAME, PERIOD);
            }

            @Test
            @DisplayName("Lord of the Pit")
            void lordOfThePit() {
                text = """
                        Flying, trample
                        At the beginning of your upkeep, sacrifice a creature other than ~. If you can\u2019t, ~ deals 7 damage to you.""";
                tokens = List.of(FLYING, COMMA, SPACE, TRAMPLE, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, UPKEEP, COMMA, SPACE, SACRIFICE, SPACE, A, SPACE, CREATURE, SPACE, OTHER, SPACE, THAN, SPACE, TILDE, PERIOD, SPACE, IF, SPACE, YOU, SPACE, CAN, NOT, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, new Number(7), SPACE, DAMAGE, SPACE, TO, SPACE, YOU, PERIOD);
            }

            @Test
            @DisplayName("Mind Twist")
            void mindTwist() {
                text = "Target player discards X cards at random.";
                tokens = List.of(TARGET, SPACE, PLAY, ER, SPACE, DISCARD, SPACE, X, SPACE, CARD, S, SPACE, AT, SPACE, RANDOM, PERIOD);
            }

            @Test
            @DisplayName("Nether Shadow")
            void netherShadow() {
                text = """
                        Haste
                        At the beginning of your upkeep, if ~ is in your graveyard with three or more creature cards above it, you may put ~ onto the battlefield.""";
                tokens = List.of(HASTE, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, UPKEEP, COMMA, SPACE, IF, SPACE, TILDE, SPACE, IS, SPACE, IN, SPACE, YOU, POSSESSIVE, SPACE, GRAVEYARD, SPACE, WITH, SPACE, THREE, SPACE, OR, SPACE, MORE, SPACE, CREATURE, SPACE, CARD, S, SPACE, ABOVE, SPACE, IT, COMMA, SPACE, YOU, SPACE, MAY, SPACE, PUT, SPACE, TILDE, SPACE, ON, TO, SPACE, THE, SPACE, BATTLEFIELD, PERIOD);
            }

            @Test
            @DisplayName("Nettling Imp")
            void nettlingImp() {
                text = "{T}: Choose target non-Wall creature the active player has controlled continuously since the beginning of the turn. That creature attacks this turn if able. Destroy it at the beginning of the next end step if it didn\u2019t attack this turn. Activate only during an opponent\u2019s turn, before attackers are declared.";
                tokens = List.of(LBRACKET, T, RBRACKET, COLON, SPACE, CHOOSE, SPACE, TARGET, SPACE, NOT, MINUS, WALL, SPACE, CREATURE, SPACE, THE, SPACE, ACTIVE, SPACE, PLAY, ER, SPACE, HAVE, SPACE, CONTROL, ED, SPACE, CONTINUOUSLY, SPACE, SINCE, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, TURN, PERIOD, SPACE, THAT, SPACE, CREATURE, SPACE, ATTACK, SPACE, THIS, SPACE, TURN, SPACE, IF, SPACE, ABLE, PERIOD, SPACE, DESTROY, SPACE, IT, SPACE, AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, NEXT, SPACE, END, SPACE, STEP, SPACE, IF, SPACE, IT, SPACE, DO, NOT, SPACE, ATTACK, SPACE, THIS, SPACE, TURN, PERIOD, SPACE, ACTIVATE, SPACE, ONLY, SPACE, DURING, SPACE, AN, SPACE, OPPONENT, POSSESSIVE, SPACE, TURN, COMMA, SPACE, BEFORE, SPACE, ATTACK, S, SPACE, IS, SPACE, DECLARE, ED, PERIOD);
            }

            @Test
            @DisplayName("Nightmare")
            void nightmare() {
                text = """
                        Flying
                        ~\u2019s power and toughness are each equal to the number of Swamps you control.""";
                tokens = List.of(FLYING, NEWLINE,
                        TILDE, POSSESSIVE, SPACE, POWER, SPACE, AND, SPACE, TOUGHNESS, SPACE, IS, SPACE, EACH, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, NUMBER, SPACE, OF, SPACE, SWAMP, S, SPACE, YOU, SPACE, CONTROL, PERIOD);
            }

            @Test
            @DisplayName("Paralyze")
            void paralyze() {
                text = """
                        Enchant creature
                        When ~ enters the battlefield, tap enchanted creature.
                        Enchanted creature doesn\u2019t untap during its controller\u2019s untap step.
                        At the beginning of the upkeep of enchanted creature\u2019s controller, that player may pay {4}. If the player does, untap the creature.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        WHEN, SPACE, TILDE, SPACE, ENTER, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, TAP, SPACE, ENCHANT, ED, SPACE, CREATURE, PERIOD, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, DO, NOT, SPACE, NOT, TAP, SPACE, DURING, SPACE, IT, POSSESSIVE, SPACE, CONTROL, ER, POSSESSIVE, SPACE, NOT, TAP, SPACE, STEP, PERIOD, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, UPKEEP, SPACE, OF, SPACE, ENCHANT, ED, SPACE, CREATURE, POSSESSIVE, SPACE, CONTROL, ER, COMMA, SPACE, THAT, SPACE, PLAY, ER, SPACE, MAY, SPACE, PAY, SPACE, LBRACKET, Number.FOUR, RBRACKET, PERIOD, SPACE, IF, SPACE, THE, SPACE, PLAY, ER, SPACE, DO, COMMA, SPACE, NOT, TAP, SPACE, THE, SPACE, CREATURE, PERIOD);
            }

            @Test
            @DisplayName("Pestilence")
            void pestilence() {
                text = """
                        At the beginning of the end step, if no creatures are on the battlefield, sacrifice ~.
                        {B}: ~ deals 1 damage to each creature and each player.""";
                tokens = List.of(AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, END, SPACE, STEP, COMMA, SPACE, IF, SPACE, NO, SPACE, CREATURE, S, SPACE, IS, SPACE, ON, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, SACRIFICE, SPACE, TILDE, PERIOD, NEWLINE,
                        LBRACKET, B, RBRACKET, COLON, SPACE, TILDE, SPACE, DEAL, SPACE, Number.ONE, SPACE, DAMAGE, SPACE, TO, SPACE, EACH, SPACE, CREATURE, SPACE, AND, SPACE, EACH, SPACE, PLAY, ER, PERIOD);
            }

            @Test
            @DisplayName("Plague Rats")
            void plagueRats() {
                text = "~\u2019s power and toughness are each equal to the number of creatures named Plague Rats on the battlefield.";
                tokens = List.of(TILDE, POSSESSIVE, SPACE, POWER, SPACE, AND, SPACE, TOUGHNESS, SPACE, IS, SPACE, EACH, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, NUMBER, SPACE, OF, SPACE, CREATURE, S, SPACE, NAME, ED, SPACE, PLAGUE, SPACE, RATS, SPACE, ON, SPACE, THE, SPACE, BATTLEFIELD, PERIOD);
            }

            @Test
            @DisplayName("Raise Dead")
            void raiseDead() {
                text = "Return target creature card from your graveyard to your hand.";
                tokens = List.of(RETURN, SPACE, TARGET, SPACE, CREATURE, SPACE, CARD, SPACE, FROM, SPACE, YOU, POSSESSIVE, SPACE, GRAVEYARD, SPACE, TO, SPACE, YOU, POSSESSIVE, SPACE, HAND, PERIOD);
            }

            @Test
            @DisplayName("Royal Assassin")
            void royalAssassin() {
                text = "{T}: Destroy target tapped creature.";
                tokens = List.of(LBRACKET, T, RBRACKET, COLON, SPACE, DESTROY, SPACE, TARGET, SPACE, TAP, ED, SPACE, CREATURE, PERIOD);
            }

            @Test
            @DisplayName("Sacrifice")
            void sacrifice() {
                text = """
                        As an additional cost to cast this spell, sacrifice a creature.
                        Add an amount of {B} equal to the sacrificed creature\u2019s mana value.""";
                tokens = List.of(AS, SPACE, AN, SPACE, ADDITIONAL, SPACE, COST, SPACE, TO, SPACE, CAST, SPACE, THIS, SPACE, SPELL, COMMA, SPACE, SACRIFICE, SPACE, A, SPACE, CREATURE, PERIOD, NEWLINE,
                        ADD, SPACE, AN, SPACE, AMOUNT, SPACE, OF, SPACE, LBRACKET, B, RBRACKET, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, SACRIFICE, ED, SPACE, CREATURE, POSSESSIVE, SPACE, MANA, SPACE, VALUE, PERIOD);
            }

            @Test
            @DisplayName("Scathe Zombies")
            void scatheZombies() {
                text = "";
                tokens = List.of();
            }

            @Test
            @DisplayName("Scavenging Ghoul")
            void scavengingGhoul() {
                text = """
                        At the beginning of each end step, put a corpse counter on ~ for each creature that died this turn.
                        Remove a corpse counter from ~: Regenerate ~.""";
                tokens = List.of(AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, EACH, SPACE, END, SPACE, STEP, COMMA, SPACE, PUT, SPACE, A, SPACE, CORPSE, SPACE, COUNTER, SPACE, ON, SPACE, TILDE, SPACE, FOR, SPACE, EACH, SPACE, CREATURE, SPACE, THAT, SPACE, DIE, ED, SPACE, THIS, SPACE, TURN, PERIOD, NEWLINE,
                        REMOVE, SPACE, A, SPACE, CORPSE, SPACE, COUNTER, SPACE, FROM, SPACE, TILDE, COLON, SPACE, REGENERATE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Sengir Vampire")
            void sengirVampire() {
                text = """
                        Flying
                        Whenever a creature dealt damage by ~ this turn dies, put a +1/+1 counter on ~.""";
                tokens = List.of(FLYING, NEWLINE,
                        WHENEVER, SPACE, A, SPACE, CREATURE, SPACE, DEAL, ED, SPACE, DAMAGE, SPACE, BY, SPACE, TILDE, SPACE, THIS, SPACE, TURN, SPACE, DIE, COMMA, SPACE, PUT, SPACE, A, SPACE, PLUS, Number.ONE, SLASH, PLUS, Number.ONE, SPACE, COUNTER, SPACE, ON, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Simulacrum")
            void simulacrum() {
                text = "You gain life equal to the damage dealt to you this turn. ~ deals damage to target creature you control equal to the damage dealt to you this turn.";
                tokens = List.of(YOU, SPACE, GAIN, SPACE, LIFE, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, DAMAGE, SPACE, DEAL, ED, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, PERIOD, SPACE, TILDE, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, TARGET, SPACE, CREATURE, SPACE, YOU, SPACE, CONTROL, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, DAMAGE, SPACE, DEAL, ED, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Sinkhole")
            void sinkhole() {
                text = "Destroy target land.";
                tokens = List.of(DESTROY, SPACE, TARGET, SPACE, LAND, PERIOD);
            }

            @Test
            @DisplayName("Terror")
            void terror() {
                text = "Destroy target nonartifact, nonblack creature. It can\u2019t be regenerated.";
                tokens = List.of(DESTROY, SPACE, TARGET, SPACE, NOT, ARTIFACT, COMMA, SPACE, NOT, BLACK, SPACE, CREATURE, PERIOD, SPACE, IT, SPACE, CAN, NOT, SPACE, BE, SPACE, REGENERATE, ED, PERIOD);
            }

            @Test
            @DisplayName("Unholy Strength")
            void unholyStrength() {
                text = """
                        Enchant creature
                        Enchanted creature gets +2/+1.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, Number.TWO, SLASH, PLUS, Number.ONE, PERIOD);
            }

            @Test
            @DisplayName("Wall of Bone")
            void wallOfWater() {
                text = """
                        Defender
                        {B}: Regenerate ~.""";
                tokens = List.of(DEFENDER, NEWLINE,
                        LBRACKET, B, RBRACKET, COLON, SPACE, REGENERATE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Warp Artifact")
            void feedback() {
                text = """
                        Enchant artifact
                        At the beginning of the upkeep of enchanted artifact\u2019s controller, ~ deals 1 damage to that player.""";
                tokens = List.of(ENCHANT, SPACE, ARTIFACT, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, UPKEEP, SPACE, OF, SPACE, ENCHANT, ED, SPACE, ARTIFACT, POSSESSIVE, SPACE, CONTROL, ER, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, Number.ONE, SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, PLAY, ER, PERIOD);
            }

            @Test
            @DisplayName("Weakness")
            void weakness() {
                text = """
                        Enchant creature
                        Enchanted creature gets -2/-1.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, MINUS, Number.TWO, SLASH, MINUS, Number.ONE, PERIOD);
            }

            @Test
            @DisplayName("Will-o'-the-Wisp")
            void willOTheWisp() {
                text = """
                        Flying
                        {B}: Regenerate ~.""";
                tokens = List.of(FLYING, NEWLINE,
                        LBRACKET, B, RBRACKET, COLON, SPACE, REGENERATE, SPACE, TILDE, PERIOD);
            }

            @Test
            @DisplayName("Word of Command")
            void wordOfCommand() {
                text = "Look at target opponent\u2019s hand and choose a card from it. You control that player until ~ finishes resolving. The player plays that card if able. While doing so, the player can activate mana abilities only if they\u2019re from lands that player controls and only if mana they produce is spent to activate other mana abilities of lands the player controls and/or to play that card. If the chosen card is cast as a spell, you control the player while that spell is resolving.";
                tokens = List.of(LOOK, SPACE, AT, SPACE, TARGET, SPACE, OPPONENT, POSSESSIVE, SPACE, HAND, SPACE, AND, SPACE, CHOOSE, SPACE, A, SPACE, CARD, SPACE, FROM, SPACE, IT, PERIOD, SPACE, YOU, SPACE, CONTROL, SPACE, THAT, SPACE, PLAY, ER, SPACE, UNTIL, SPACE, TILDE, SPACE, FINISH, SPACE, RESOLVE, ING, PERIOD, SPACE, THE, SPACE, PLAY, ER, SPACE, PLAY, SPACE, THAT, SPACE, CARD, SPACE, IF, SPACE, ABLE, PERIOD, SPACE, WHILE, SPACE, DO, ING, SPACE, SO, COMMA, SPACE, THE, SPACE, PLAY, ER, SPACE, CAN, SPACE, ACTIVATE, SPACE, MANA, SPACE, ABILITY, S, SPACE, ONLY, SPACE, IF, SPACE, THEY, IS, SPACE, FROM, SPACE, LAND, S, SPACE, THAT, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, AND, SPACE, ONLY, SPACE, IF, SPACE, MANA, SPACE, THEY, SPACE, PRODUCE, SPACE, IS, SPACE, SPEND, ED, SPACE, TO, SPACE, ACTIVATE, SPACE, OTHER, SPACE, MANA, SPACE, ABILITY, S, SPACE, OF, SPACE, LAND, S, SPACE, THE, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, AND, SLASH, OR, SPACE, TO, SPACE, PLAY, SPACE, THAT, SPACE, CARD, PERIOD, SPACE, IF, SPACE, THE, SPACE, CHOSEN, SPACE, CARD, SPACE, IS, SPACE, CAST, SPACE, AS, SPACE, A, SPACE, SPELL, COMMA, SPACE, YOU, SPACE, CONTROL, SPACE, THE, SPACE, PLAY, ER, SPACE, WHILE, SPACE, THAT, SPACE, SPELL, SPACE, IS, SPACE, RESOLVE, ING, PERIOD);
            }

            @Test
            @DisplayName("Zombie Master")
            void zombieMaster() {
                text = """
                        Other Zombie creatures have swampwalk.
                        Other Zombies have \u201C{B}: Regenerate this permanent.\u201D""";
                tokens = List.of(OTHER, SPACE, ZOMBIE, SPACE, CREATURE, S, SPACE, HAVE, SPACE, SWAMP, WALK, PERIOD, NEWLINE,
                        OTHER, SPACE, ZOMBIE, S, SPACE, HAVE, SPACE, OPENQUOTE, LBRACKET, B, RBRACKET, COLON, SPACE, REGENERATE, SPACE, THIS, SPACE, PERMANENT, PERIOD, CLOSEQUOTE);
            }
        }

        @Nested
        @DisplayName("Red Cards")
        class RedCardTests {
            @Test
            @DisplayName("Burrowing")
            void burrowing() {
                text = """
                        Enchant creature
                        Enchanted creature has mountainwalk.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, MOUNTAIN, WALK, PERIOD);
            }

            @Test
            @DisplayName("Chaoslace")
            void Chaoslace() {
                text = "Target spell or permanent becomes red.";
                tokens = List.of(TARGET, SPACE, SPELL, SPACE, OR, SPACE, PERMANENT, SPACE, BECOME, SPACE, RED, PERIOD);
            }

            @Test
            @DisplayName("Disintegrate")
            void disintegrate() {
                text = "~ deals X damage to any target. If it\u2019s a creature, it can\u2019t be regenerated this turn, and if it would die this turn, exile it instead.";
                tokens = List.of(TILDE, SPACE, DEAL, SPACE, X, SPACE, DAMAGE, SPACE, TO, SPACE, ANY, SPACE, TARGET, PERIOD, SPACE, IF, SPACE, IT, IS, SPACE, A, SPACE, CREATURE, COMMA, SPACE, IT, SPACE, CAN, NOT, SPACE, BE, SPACE, REGENERATE, ED, SPACE, THIS, SPACE, TURN, COMMA, SPACE, AND, SPACE, IF, SPACE, IT, SPACE, WOULD, SPACE, DIE, SPACE, THIS, SPACE, TURN, COMMA, SPACE, EXILE, SPACE, IT, SPACE, INSTEAD, PERIOD);
            }

            @Test
            @DisplayName("Dragon Whelp")
            void dragonWhelp() {
                text = """
                        Flying
                        {R}: ~ gets +1/+0 until end of turn. If this ability has been activated four or more times this turn, sacrifice ~ at the beginning of the next end step.""";
                tokens = List.of(FLYING, NEWLINE,
                        LBRACKET, R, RBRACKET, COLON, SPACE, TILDE, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, new Number(0), SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD, SPACE, IF, SPACE, THIS, SPACE, ABILITY, SPACE, HAVE, SPACE, ED, SPACE, ACTIVATE, ED, SPACE, FOUR, SPACE, OR, SPACE, MORE, SPACE, TIME, S, SPACE, THIS, SPACE, TURN, COMMA, SPACE, SACRIFICE, SPACE, TILDE, SPACE, AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, NEXT, SPACE, END, SPACE, STEP, PERIOD);
            }

            @Test
            @DisplayName("Dwarven Demolition Team")
            void dwarvenDemolitionTeam() {
                text = "{T}: Destroy target Wall.";
                tokens = List.of(LBRACKET, T, RBRACKET, COLON, SPACE, DESTROY, SPACE, TARGET, SPACE, WALL, PERIOD);
            }

            @Test
            @DisplayName("Dwarven Warriors")
            void dwarvenWarriors() {
                text = "{T}: Target creature with power 2 or less can\u2019t be blocked this turn.";
                tokens = List.of(LBRACKET, T, RBRACKET, COLON, SPACE, TARGET, SPACE, CREATURE, SPACE, WITH, SPACE, POWER, SPACE, Number.TWO, SPACE, OR, SPACE, LESS, SPACE, CAN, NOT, SPACE, BE, SPACE, BLOCK, ED, SPACE, THIS, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Earth Elemental")
            void earthElemental() {
                text = "";
                tokens = List.of();
            }

            @Test
            @DisplayName("Earthbind")
            void earthbind() {
                text = """
                        Enchant creature
                        When ~ enters the battlefield, if enchanted creature has flying, ~ deals 2 damage to that creature and ~ gains \u201CEnchanted creature loses flying.\u201D""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        WHEN, SPACE, TILDE, SPACE, ENTER, SPACE, THE, SPACE, BATTLEFIELD, COMMA, SPACE, IF, SPACE, ENCHANT, ED, SPACE, CREATURE, SPACE, HAVE, SPACE, FLYING, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, Number.TWO, SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, CREATURE, SPACE, AND, SPACE, TILDE, SPACE, GAIN, SPACE, OPENQUOTE, ENCHANT, ED, SPACE, CREATURE, SPACE, LOSE, SPACE, FLYING, PERIOD, CLOSEQUOTE);
            }

            @Test
            @DisplayName("Earthquake")
            void earthquake() {
                text = "~ deals X damage to each creature without flying and each player.";
                tokens = List.of(TILDE, SPACE, DEAL, SPACE, X, SPACE, DAMAGE, SPACE, TO, SPACE, EACH, SPACE, CREATURE, SPACE, WITH, OUT, SPACE, FLYING, SPACE, AND, SPACE, EACH, SPACE, PLAY, ER, PERIOD);
            }

            @Test
            @DisplayName("False Orders")
            void falseOrders() {
                text = """
                        Cast this spell only during the declare blockers step.
                        Remove target creature defending player controls from combat. Creatures it was blocking that had become blocked by only that creature this combat become unblocked. You may have it block an attacking creature of your choice.""";
                tokens = List.of(CAST, SPACE, THIS, SPACE, SPELL, SPACE, ONLY, SPACE, DURING, SPACE, THE, SPACE, DECLARE, SPACE, BLOCK, ER, S, SPACE, STEP, PERIOD, NEWLINE,
                        REMOVE, SPACE, TARGET, SPACE, CREATURE, SPACE, DEFENDING, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, FROM, SPACE, COMBAT, PERIOD, SPACE, CREATURE, S, SPACE, IT, SPACE, IS, ED, SPACE, BLOCK, ING, SPACE, THAT, SPACE, HAVE, ED, SPACE, BECOME, SPACE, BLOCK, ED, SPACE, BY, SPACE, ONLY, SPACE, THAT, SPACE, CREATURE, SPACE, THIS, SPACE, COMBAT, SPACE, BECOME, SPACE, NOT, BLOCK, ED, PERIOD, SPACE, YOU, SPACE, MAY, SPACE, HAVE, SPACE, IT, SPACE, BLOCK, SPACE, AN, SPACE, ATTACK, ING, SPACE, CREATURE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, PERIOD);
            }

            @Test
            @DisplayName("Fire Elemental")
            void fireElemental() {
                text = "";
                tokens = List.of();
            }

            @Test
            @DisplayName("Fireball")
            void fireball() {
                text = """
                        This spell costs {1} more to cast for each target beyond the first.
                        ~ deals X damage divided evenly, rounded down, among any number of targets.""";
                tokens = List.of(THIS, SPACE, SPELL, SPACE, COST, SPACE, LBRACKET, Number.ONE, RBRACKET, SPACE, MORE, SPACE, TO, SPACE, CAST, SPACE, FOR, SPACE, EACH, SPACE, TARGET, SPACE, BEYOND, SPACE, THE, SPACE, FIRST, PERIOD, NEWLINE,
                        TILDE, SPACE, DEAL, SPACE, X, SPACE, DAMAGE, SPACE, DIVIDE, ED, SPACE, EVENLY, COMMA, SPACE, ROUNDED, SPACE, DOWN, COMMA, SPACE, AMONG, SPACE, ANY, SPACE, NUMBER, SPACE, OF, SPACE, TARGET, S, PERIOD);
            }

            @Test
            @DisplayName("Firebreathing")
            void firebreathing() {
                text = """
                        Enchant creature
                        {R}: Enchanted creature gets +1/+0 until end of turn.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        LBRACKET, R, RBRACKET, COLON, SPACE, ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, new Number(0), SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Flashfires")
            void flashfires() {
                text = "Destroy all Plains.";
                tokens = List.of(DESTROY, SPACE, ALL, SPACE, PLAINS, PERIOD);
            }

            @Test
            @DisplayName("Fork")
            void fork() {
                text = "Copy target instant or sorcery spell, except that the copy is red. You may choose new targets for the copy.";
                tokens = List.of(COPY, SPACE, TARGET, SPACE, INSTANT, SPACE, OR, SPACE, SORCERY, SPACE, SPELL, COMMA, SPACE, EXCEPT, SPACE, THAT, SPACE, THE, SPACE, COPY, SPACE, IS, SPACE, RED, PERIOD, SPACE, YOU, SPACE, MAY, SPACE, CHOOSE, SPACE, NEW, SPACE, TARGET, S, SPACE, FOR, SPACE, THE, SPACE, COPY, PERIOD);
            }

            @Test
            @DisplayName("Goblin Balloon Brigade")
            void goblinBalloonBrigade() {
                text = "{R}: ~ gains flying until end of turn.";
                tokens = List.of(LBRACKET, R, RBRACKET, COLON, SPACE, TILDE, SPACE, GAIN, SPACE, FLYING, SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Goblin King")
            void goblinKing() {
                text = "Other Goblins get +1/+1 and have mountainwalk.";
                tokens = List.of(OTHER, SPACE, GOBLIN, S, SPACE, GET, SPACE, PLUS, Number.ONE, SLASH, PLUS, Number.ONE, SPACE, AND, SPACE, HAVE, SPACE, MOUNTAIN, WALK, PERIOD);
            }
        }
    }
}
