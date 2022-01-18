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
import static tegenton.card.parse.lexicon.Conjunction.*;
import static tegenton.card.parse.lexicon.Determiner.*;
import static tegenton.card.parse.lexicon.Genitive.HALF;
import static tegenton.card.parse.lexicon.Morpheme.*;
import static tegenton.card.parse.lexicon.Noun.*;
import static tegenton.card.parse.lexicon.Particle.UP;
import static tegenton.card.parse.lexicon.Preposition.*;
import static tegenton.card.parse.lexicon.SubordinateConjunction.*;
import static tegenton.card.parse.lexicon.Symbol.MINUS;
import static tegenton.card.parse.lexicon.Symbol.*;
import static tegenton.card.parse.lexicon.game.Color.U;
import static tegenton.card.parse.lexicon.game.Color.W;
import static tegenton.card.parse.lexicon.game.ColorWord.*;
import static tegenton.card.parse.lexicon.game.GameNoun.*;
import static tegenton.card.parse.lexicon.game.GameVerb.BE;
import static tegenton.card.parse.lexicon.game.Keyword.*;
import static tegenton.card.parse.lexicon.game.Tap.T;
import static tegenton.card.parse.lexicon.game.TriggerWord.*;
import static tegenton.card.parse.lexicon.game.Zone.*;
import static tegenton.card.parse.lexicon.game.source.SourceNoun.SOURCE;
import static tegenton.card.parse.lexicon.game.source.SourceVerb.DEAL;
import static tegenton.card.parse.lexicon.game.source.SourceVerb.DO;
import static tegenton.card.parse.lexicon.game.source.target.TargetAdjective.ABLE;
import static tegenton.card.parse.lexicon.game.source.target.TargetAuxiliaryVerb.CAN;
import static tegenton.card.parse.lexicon.game.source.target.TargetAuxiliaryVerb.WOULD;
import static tegenton.card.parse.lexicon.game.source.target.TargetModifier.POSSESSIVE;
import static tegenton.card.parse.lexicon.game.source.target.TargetNoun.THEY;
import static tegenton.card.parse.lexicon.game.source.target.TargetNoun.WHO;
import static tegenton.card.parse.lexicon.game.source.target.TargetVerb.GAIN;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute.*;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun.*;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb.*;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerAdjective.ACTIVE;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerAdjective.DEFENDING;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerAdverb.CONTINUOUSLY;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerNoun.OPPONENT;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerNoun.YOU;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb.*;
import static tegenton.card.parse.lexicon.game.turn.Chronology.BEFORE;
import static tegenton.card.parse.lexicon.game.turn.Chronology.DURING;
import static tegenton.card.parse.lexicon.game.turn.Duration.SINCE;
import static tegenton.card.parse.lexicon.game.turn.Duration.UNTIL;
import static tegenton.card.parse.lexicon.game.turn.Phase.BEGINNING;
import static tegenton.card.parse.lexicon.game.turn.Phase.COMBAT;
import static tegenton.card.parse.lexicon.game.turn.Step.END;
import static tegenton.card.parse.lexicon.game.turn.Step.UPKEEP;
import static tegenton.card.parse.lexicon.game.type.CardType.*;
import static tegenton.card.parse.lexicon.game.type.CreatureType.MERFOLK;
import static tegenton.card.parse.lexicon.game.type.CreatureType.WALL;
import static tegenton.card.parse.lexicon.game.type.EnchantmentType.AURA;
import static tegenton.card.parse.lexicon.game.type.LandType.*;
import static tegenton.card.parse.lexicon.game.type.SuperType.BASIC;
import static tegenton.card.parse.lexicon.value.EnglishNumber.ONE;
import static tegenton.card.parse.lexicon.value.EnglishNumber.THREE;
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
                        LBRACKET, W, RBRACKET, COLON, SPACE, ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, new Number(1), SLASH, PLUS, new Number(1), SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
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
                tokens = List.of(NOT, TAP, ED, SPACE, CREATURE, S, SPACE, YOU, SPACE, CONTROL, SPACE, GET, SPACE, PLUS, new Number(0), SLASH, PLUS, new Number(2), PERIOD);
            }

            @Test
            @DisplayName("Circle of Protection: Blue")
            void circleOfProtectionBlue() {
                text = "{1}: The next time a blue source of your choice would deal damage to you this turn, prevent that damage.";
                tokens = List.of(LBRACKET, new Number(1), RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, TIME, SPACE, A, SPACE, BLUE, SPACE, SOURCE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, SPACE, WOULD, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, COMMA, SPACE, PREVENT, SPACE, THAT, SPACE, DAMAGE, PERIOD);
            }

            @Test
            @DisplayName("Circle of Protection: Green")
            void circleOfProtectionGreen() {
                text = "{1}: The next time a green source of your choice would deal damage to you this turn, prevent that damage.";
                tokens = List.of(LBRACKET, new Number(1), RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, TIME, SPACE, A, SPACE, GREEN, SPACE, SOURCE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, SPACE, WOULD, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, COMMA, SPACE, PREVENT, SPACE, THAT, SPACE, DAMAGE, PERIOD);
            }

            @Test
            @DisplayName("Circle of Protection: Red")
            void circleOfProtectionRed() {
                text = "{1}: The next time a red source of your choice would deal damage to you this turn, prevent that damage.";
                tokens = List.of(LBRACKET, new Number(1), RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, TIME, SPACE, A, SPACE, RED, SPACE, SOURCE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, SPACE, WOULD, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, COMMA, SPACE, PREVENT, SPACE, THAT, SPACE, DAMAGE, PERIOD);
            }

            @Test
            @DisplayName("Circle of Protection: White")
            void circleOfProtectionWhite() {
                text = "{1}: The next time a white source of your choice would deal damage to you this turn, prevent that damage.";
                tokens = List.of(LBRACKET, new Number(1), RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, TIME, SPACE, A, SPACE, WHITE, SPACE, SOURCE, SPACE, OF, SPACE, YOU, POSSESSIVE, SPACE, CHOICE, SPACE, WOULD, SPACE, DEAL, SPACE, DAMAGE, SPACE, TO, SPACE, YOU, SPACE, THIS, SPACE, TURN, COMMA, SPACE, PREVENT, SPACE, THAT, SPACE, DAMAGE, PERIOD);
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
                tokens = List.of(WHITE, SPACE, CREATURE, S, SPACE, GET, SPACE, PLUS, new Number(1), SLASH, PLUS, new Number(1), PERIOD);
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
                        IF, SPACE, YOU, SPACE, DO, COMMA, SPACE, YOU, SPACE, GAIN, SPACE, new Number(1), SPACE, LIFE, PERIOD, CLOSEQUOTE);
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
                        UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, COMMA, SPACE, YOU, SPACE, MAY, SPACE, PAY, SPACE, LBRACKET, new Number(1), RBRACKET, SPACE, ANY, SPACE, TIME, SPACE, YOU, SPACE, COULD, SPACE, CAST, SPACE, AN, SPACE, INSTANT, PERIOD, SPACE,
                        IF, SPACE, YOU, SPACE, DO, COMMA, SPACE, PREVENT, SPACE, THE, SPACE, NEXT, SPACE, new Number(1), SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, THAT, SPACE, PERMANENT, SPACE, OR, SPACE, PLAY, ER, SPACE, THIS, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Healing Salve")
            void healingSalve() {
                text = """
                        Choose one \u2014
                        \u2022 Target player gains 3 life.
                        \u2022 Prevent the next 3 damage that would be dealt to any target this turn.""";
                tokens = List.of(CHOOSE, SPACE, ONE, SPACE, DASH, NEWLINE,
                        BULLET, SPACE, TARGET, SPACE, PLAY, ER, SPACE, GAIN, SPACE, new Number(3), SPACE, LIFE, PERIOD, NEWLINE,
                        BULLET, SPACE, PREVENT, SPACE, THE, SPACE, NEXT, SPACE, new Number(3), SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, ANY, SPACE, TARGET, SPACE, THIS, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Holy Armor")
            void holyArmor() {
                text = """
                        Enchant creature
                        Enchanted creature gets +0/+2.
                        {W}: Enchanted creature gets +0/+1 until end of turn.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, new Number(0), SLASH, PLUS, new Number(2), PERIOD, NEWLINE,
                        LBRACKET, W, RBRACKET, COLON, SPACE, ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, new Number(0), SLASH, PLUS, new Number(1), SPACE, UNTIL, SPACE, END, SPACE, OF, SPACE, TURN, PERIOD);
            }

            @Test
            @DisplayName("Holy Strength")
            void holyStrength() {
                text = """
                        Enchant creature
                        Enchanted creature gets +1/+2.""";
                tokens = List.of(ENCHANT, SPACE, CREATURE, NEWLINE,
                        ENCHANT, ED, SPACE, CREATURE, SPACE, GET, SPACE, PLUS, new Number(1), SLASH, PLUS, new Number(2), PERIOD);
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
                tokens = List.of(LBRACKET, new Number(0), RBRACKET, COLON, SPACE, THE, SPACE, NEXT, SPACE, new Number(1), SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, TILDE, SPACE, THIS, SPACE, TURN, SPACE, IS, SPACE, DEAL, ED, SPACE, TO, SPACE, IT, POSSESSIVE, SPACE, OWN, ER, SPACE, INSTEAD, PERIOD, SPACE,
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
                tokens = List.of(LBRACKET, T, RBRACKET, COLON, SPACE, PREVENT, SPACE, THE, SPACE, NEXT, SPACE, new Number(1), SPACE, DAMAGE, SPACE, THAT, SPACE, WOULD, SPACE, BE, SPACE, DEAL, ED, SPACE, TO, SPACE, ANY, SPACE, TARGET, SPACE, THIS, SPACE, TURN, PERIOD);
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
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, UPKEEP, SPACE, OF, SPACE, ENCHANT, ED, SPACE, ENCHANTMENT, POSSESSIVE, SPACE, CONTROL, ER, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, new Number(1), SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, PLAY, ER, PERIOD);
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
                tokens = List.of(WHENEVER, SPACE, A, SPACE, FOREST, SPACE, AN, SPACE, OPPONENT, SPACE, CONTROL, SPACE, BECOME, SPACE, TAP, ED, COMMA, SPACE, YOU, SPACE, GAIN, SPACE, new Number(1), SPACE, LIFE, PERIOD);
            }

            @Test
            @DisplayName("Lord of Atlantis")
            void lordOfAtlantis() {
                text = "Other Merfolk get +1/+1 and have islandwalk.";
                tokens = List.of(OTHER, SPACE, MERFOLK, SPACE, GET, SPACE, PLUS, new Number(1), SLASH, PLUS, new Number(1), SPACE, AND, SPACE, HAVE, SPACE, ISLAND, WALK, PERIOD);
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
                        LBRACKET, T, RBRACKET, COLON, SPACE, TILDE, SPACE, DEAL, SPACE, new Number(1), SPACE, DAMAGE, SPACE, TO, SPACE, ANY, SPACE, TARGET, PERIOD, NEWLINE,
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
                        TILDE, SPACE, DEAL, SPACE, new Number(2), SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, PLAY, ER, PERIOD, SPACE,
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
                tokens = List.of(LBRACKET, T, RBRACKET, COLON, SPACE, TILDE, SPACE, DEAL, SPACE, new Number(1), SPACE, DAMAGE, SPACE, TO, SPACE, ANY, SPACE, TARGET, PERIOD);
            }

            @Test
            @DisplayName("Psionic Blast")
            void psionicBlast() {
                text = "~ deals 4 damage to any target and 2 damage to you.";
                tokens = List.of(TILDE, SPACE, DEAL, SPACE, new Number(4), SPACE, DAMAGE, SPACE, TO, SPACE, ANY, SPACE, TARGET, SPACE, AND, SPACE, new Number(2), SPACE, DAMAGE, SPACE, TO, SPACE, YOU, PERIOD);
            }

            @Test
            @DisplayName("Psychic Venom")
            void psychicVenom() {
                text = """
                        Enchant land
                        Whenever enchanted land becomes tapped, ~ deals 2 damage to that land\u2019s controller.""";
                tokens = List.of(ENCHANT, SPACE, LAND, NEWLINE,
                        WHENEVER, SPACE, ENCHANT, ED, SPACE, LAND, SPACE, BECOME, SPACE, TAP, ED, COMMA, SPACE, TILDE, SPACE, DEAL, SPACE, new Number(2), SPACE, DAMAGE, SPACE, TO, SPACE, THAT, SPACE, LAND, S, SPACE, CONTROL, ER, PERIOD);
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
                tokens = List.of(CAST, SPACE, THIS, SPACE, SPELL, SPACE, ONLY, SPACE, DURING, SPACE, AN, SPACE, OPPONENT, S, SPACE, TURN, COMMA, SPACE, BEFORE, SPACE, ATTACK, S, SPACE, IS, SPACE, DECLARE, ED, PERIOD, NEWLINE,
                        CREATURE, S, SPACE, THE, SPACE, ACTIVE, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, ATTACK, SPACE, THIS, SPACE, TURN, SPACE, IF, SPACE, ABLE, PERIOD, NEWLINE,
                        AT, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, NEXT, SPACE, END, SPACE, STEP, COMMA, SPACE, DESTROY, SPACE, ALL, SPACE, NOT, MINUS, WALL, SPACE, CREATURE, S, SPACE, THAT, SPACE, PLAY, ER, SPACE, CONTROL, SPACE, THAT, SPACE, DO, NOT, SPACE, ATTACK, SPACE, THIS, SPACE, TURN, PERIOD, SPACE, IGNORE, SPACE, THIS, SPACE, EFFECT, SPACE, FOR, SPACE, EACH, SPACE, CREATURE, SPACE, THE, SPACE, PLAY, ER, SPACE, DO, NOT, SPACE, CONTROL, SPACE, CONTINUOUSLY, SPACE, SINCE, SPACE, THE, SPACE, BEGINNING, SPACE, OF, SPACE, THE, SPACE, TURN, PERIOD);
            }
        }
    }
}
