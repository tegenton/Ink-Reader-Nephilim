package tegenton.card.parse;

import org.junit.jupiter.api.*;

public class RulesTextParserTest {
    public static String text;

    @BeforeEach
    void setup() {
        text = null;
    }

    @AfterEach
    void cleanup() {
        RulesTextParser.fromString(text);
    }

    @Nested
    @DisplayName("Alpha")
    class LEA {
        @Nested
        @DisplayName("White cards")
        class White {
            @Test
            @DisplayName("Animate Wall")
            void animateWall() {
                text = "Enchant Wall\nEnchanted Wall can attack as though it didn't have defender.";
            }

            @Test
            @DisplayName("Armageddon")
            void armageddon() {
                text = "Destroy all lands.";
            }

            @Test
            @DisplayName("Balance")
            void balance() {
                text = "Each player chooses a number of lands they control equal to the number of lands controlled by the player who controls the fewest, then sacrifices the rest. Players discard cards and sacrifice creatures the same way.";
            }

            @Test
            @DisplayName("Benalish Hero")
            void benalishHero() {
                text = "Banding";
            }

            @Test
            @DisplayName("Black Ward")
            void blackWard() {
                text = "Enchant creature\nEnchanted creature has protection from black. This effect doesn’t remove Black Ward.";
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
                text = "Enchant creature\nEnchanted creature has protection from blue. This effect doesn’t remove Blue Ward.";
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
                text = "Enchant land\nEnchanted land has indestructible and can’t be enchanted by other Auras.";
            }

            @Test
            @DisplayName("Conversion")
            void conversion() {
                text = "At the beginning of your upkeep, sacrifice Conversion unless you pay {W}{W}.\nAll Mountains are Plains.";
            }

            @Test
            @DisplayName("Crusade")
            void crusade() {
                text = "White creatures get +1/+1.";
            }
        }
    }
}
