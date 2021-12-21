package tegenton.card.parse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.Word;

import java.util.List;

import static tegenton.card.parse.lexicon.Adjective.EQUAL;
import static tegenton.card.parse.lexicon.Adjective.SAME;
import static tegenton.card.parse.lexicon.Adverb.NOT;
import static tegenton.card.parse.lexicon.Conjunction.AND;
import static tegenton.card.parse.lexicon.Conjunction.THEN;
import static tegenton.card.parse.lexicon.Determiner.*;
import static tegenton.card.parse.lexicon.Morpheme.*;
import static tegenton.card.parse.lexicon.Noun.*;
import static tegenton.card.parse.lexicon.Preposition.*;
import static tegenton.card.parse.lexicon.SubordinateConjunction.AS;
import static tegenton.card.parse.lexicon.SubordinateConjunction.THOUGH;
import static tegenton.card.parse.lexicon.Symbol.*;
import static tegenton.card.parse.lexicon.game.Keyword.DEFENDER;
import static tegenton.card.parse.lexicon.game.Keyword.ENCHANT;
import static tegenton.card.parse.lexicon.game.source.SourceVerb.DO;
import static tegenton.card.parse.lexicon.game.source.target.TargetAuxiliaryVerb.CAN;
import static tegenton.card.parse.lexicon.game.source.target.TargetNoun.THEY;
import static tegenton.card.parse.lexicon.game.source.target.TargetNoun.WHO;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun.CARD;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun.IT;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb.ATTACK;
import static tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb.HAVE;
import static tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb.*;
import static tegenton.card.parse.lexicon.game.type.CardType.CREATURE;
import static tegenton.card.parse.lexicon.game.type.CardType.LAND;
import static tegenton.card.parse.lexicon.game.type.CreatureType.WALL;

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
                text = "Enchant Wall\nEnchanted Wall can attack as though it didn\u2019t have defender.";
                tokens = List.of(ENCHANT, SPACE, WALL, NEWLINE, ENCHANT, ED, SPACE, WALL, SPACE, CAN, SPACE, ATTACK, SPACE, AS, SPACE, THOUGH, SPACE, IT, SPACE, DO, NOT, SPACE, HAVE, SPACE, DEFENDER, PERIOD);
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
                tokens = List.of(EACH, SPACE, PLAY, ER, SPACE, CHOOSE, SPACE, A, SPACE, NUMBER, SPACE, OF, SPACE, LAND, S, SPACE, THEY, SPACE, CONTROL, SPACE, EQUAL, SPACE, TO, SPACE, THE, SPACE, NUMBER, SPACE, OF, SPACE, LAND, S, SPACE, CONTROL, ED, SPACE, BY, SPACE, THE, SPACE, PLAY, ER, SPACE, WHO, SPACE, CONTROL, SPACE, THE, SPACE, FEWEST, COMMA, SPACE, THEN, SPACE, SACRIFICE, SPACE, THE, SPACE, REST, PERIOD, SPACE, PLAY, ER, S, SPACE, DISCARD, SPACE, CARD, S, SPACE, AND, SPACE, SACRIFICE, SPACE, CREATURE, S, SPACE, THE, SPACE, SAME, SPACE, WAY, PERIOD);
            }

            @Test
            @DisplayName("Benalish Hero")
            void benalishHero() {
                text = "Banding";
            }

            @Test
            @DisplayName("Black Ward")
            void blackWard() {
                text = "Enchant creature\nEnchanted creature has protection from black. This effect doesn\u2019t remove ~.";
            }

            @Test
            @DisplayName("Blaze of Glory")
            void blazeOfGlory() {
                text = "Cast this spell only during combat before blockers are declared.\nTarget creature defending player controls can block any number of creatures this turn. It blocks each attacking creature this turn if able.";
            }

            @Test
            @DisplayName("Blessing")
            void blessing() {
                text = "Enchant creature \n{W}: Enchanted creature gets +1/+1 until end of turn.";
            }

            @Test
            @DisplayName("Blue Ward")
            void blueWard() {
                text = "Enchant creature\nEnchanted creature has protection from blue. This effect doesn\u2019t remove ~.";
            }

            @Test
            @DisplayName("Castle")
            void castle() {
                text = "Untapped creatures you control get +0/+2.";
            }

            @Test
            @DisplayName("Circle of Protection: Blue")
            void circleOfProtectionBlue() {
                text = "{1}: The next time a blue source of your choice would deal damage to you this turn, prevent that damage.";
            }

            @Test
            @DisplayName("Circle of Protection: Green")
            void circleOfProtectionGreen() {
                text = "{1}: The next time a green source of your choice would deal damage to you this turn, prevent that damage.";
            }

            @Test
            @DisplayName("Circle of Protection: Red")
            void circleOfProtectionRed() {
                text = "{1}: The next time a red source of your choice would deal damage to you this turn, prevent that damage.";
            }

            @Test
            @DisplayName("Circle of Protection: White")
            void circleOfProtectionWhite() {
                text = "{1}: The next time a white source of your choice would deal damage to you this turn, prevent that damage.";
            }

            @Test
            @DisplayName("Consecrate Land")
            void consecrateLand() {
                text = "Enchant land\nEnchanted land has indestructible and can\u2019t be enchanted by other Auras.";
            }

            @Test
            @DisplayName("Conversion")
            void conversion() {
                text = "At the beginning of your upkeep, sacrifice ~ unless you pay {W}{W}.\nAll Mountains are Plains.";
            }

            @Test
            @DisplayName("Crusade")
            void crusade() {
                text = "White creatures get +1/+1.";
            }

            @Test
            @DisplayName("Death Ward")
            void deathWard() {
                text = "Regenerate target creature.";
            }

            @Test
            @DisplayName("Disenchant")
            void disenchant() {
                text = "Destroy target artifact or enchantment.";
            }

            @Test
            @DisplayName("Farmstead")
            void farmstead() {
                text = "Enchant land\nEnchanted land has \u201CAt the beginning of your upkeep, you may pay {W}{W}. If you do, you gain 1 life.\u201D";
            }

            @Test
            @DisplayName("Green Ward")
            void greenWard() {
                text = "Enchant creature\nEnchanted creature has protection from green. This effect doesn\u2019t remove ~.";
            }

            @Test
            @DisplayName("Guardian Angel")
            void guardianAngel() {
                text = "Prevent the next X damage that would be dealt to any target this turn. Until end of turn, you may pay {1} any time you could cast an instant. If you do, prevent the next 1 damage that would be dealt to that permanent or player this turn.";
            }

            @Test
            @DisplayName("Healing Salve")
            void healingSalve() {
                text = "Choose one \u2014\n\u2022 Target player gains 3 life.\n\u2022 Prevent the next 3 damage that would be dealt to any target this turn.";
            }

            @Test
            @DisplayName("Holy Armor")
            void holyArmor() {
                text = "Enchant creature\nEnchanted creature gets +0/+2.\n{W}: Enchanted creature gets +0/+1 until end of turn.";
            }

            @Test
            @DisplayName("Holy Strength")
            void holyStrength() {
                text = "Enchant creature\nEnchanted creature gets +1/+2.";
            }

            @Test
            @DisplayName("Island Sanctuary")
            void islandSanctuary() {
                text = "If you would draw a card during your draw step, instead you may skip that draw. If you do, until your next turn, you can\u2019t be attacked except by creatures with flying and/or islandwalk.";
            }

            @Test
            @DisplayName("Karma")
            void karma() {
                text = "At the beginning of each player\u2019s upkeep, ~ deals damage to that player equal to the number of Swamps they control.";
            }

            @Test
            @DisplayName("Lance")
            void lance() {
                text = "Enchant creature\nEnchanted creature has first strike.";
            }

            @Test
            @DisplayName("Mesa Pegasus")
            void mesaPegasus() {
                text = "Flying; banding";
            }

            @Test
            @DisplayName("Northern Paladin")
            void northernPaladin() {
                text = "{W}{W}, {T}: Destroy target black permanent.";
            }

            @Test
            @DisplayName("Pearled Unicorn")
            void pearledUnicorn() {
                text = "";
            }

            @Test
            @DisplayName("Personal Incarnation")
            void personalIncarnation() {
                text = "{0}: The next 1 damage that would be dealt to ~ this turn is dealt to its owner instead. Only ~\u2019s owner may activate this ability.\nWhen ~ dies, its owner loses half their life, rounded up.";
            }

            @Test
            @DisplayName("Purelace")
            void purelace() {
                text = "Target spell or permanent becomes white.";
            }

            @Test
            @DisplayName("Red Ward")
            void redWard() {
                text = "Enchant creature\nEnchanted creature has protection from red. This effect doesn\u2019t remove ~.";
            }

            @Test
            @DisplayName("Resurrection")
            void resurrection() {
                text = "Return target creature card from your graveyard to the battlefield.";
            }

            @Test
            @DisplayName("Reverse Damage")
            void reverseDamage() {
                text = "The next time a source of your choice would deal damage to you this turn, prevent that damage. You gain life equal to the damage prevented this way.";
            }

            @Test
            @DisplayName("Righteousness")
            void righteousness() {
                text = "Target blocking creature gets +7/+7 until end of turn.";
            }

            @Test
            @DisplayName("Samite Healer")
            void samiteHealer() {
                text = "{T}: Prevent the next 1 damage that would be dealt to any target this turn.";
            }

            @Test
            @DisplayName("Savannah Lions")
            void savannahLions() {
                text = "";
            }

            @Test
            @DisplayName("Serra Angel")
            void serraAngel() {
                text = "Flying, vigilance";
            }

            @Test
            @DisplayName("Swords to Plowshares")
            void swordsToPlowshares() {
                text = "Exile target creature. Its controller gains life equal to its power.";
            }

            @Test
            @DisplayName("Veteran Bodyguard")
            void veteranBodyguard() {
                text = "As long as ~ is untapped, all damage that would be dealt to you by unblocked creatures is dealt to ~ instead.";
            }

            @Test
            @DisplayName("Wall of Swords")
            void wallOfSwords() {
                text = "Defender\nFlying";
            }

            @Test
            @DisplayName("White Knight")
            void whiteKnight() {
                text = "First strike\nProtection from black";
            }

            @Test
            @DisplayName("White Ward")
            void whiteWard() {
                text = "Enchant creature\nEnchanted creature has protection from white. This effect doesn\u2019t remove ~.";
            }

            @Test
            @DisplayName("Wrath of God")
            void wrathOfGod() {
                text = "Destroy all creatures. They can\u2019t be regenerated.";
            }
        }
    }
}
