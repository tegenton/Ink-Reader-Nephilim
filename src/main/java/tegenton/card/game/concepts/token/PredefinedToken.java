package tegenton.card.game.concepts.token;

/**
 * Some effects instruct a player to create a predefined token. These effects
 * use the definition below to determine the characteristics the token is
 * created with. The effect that creates a predefined token may also modify or
 * add to the predefined characteristics.
 * <p>
 * A Treasure token is a colorless Treasure artifact token with “{T}, Sacrifice
 * this artifact: Add one mana of any color.”
 * <p>
 * A Food token is a colorless Food artifact token with “{2}, {T}, Sacrifice
 * this artifact: You gain 3 life.”
 * <p>
 * A Gold token is a colorless Gold artifact token with “Sacrifice this
 * artifact: Add one mana of any color.”
 * <p>
 * A Walker token is a 2/2 black Zombie creature token named Walker.
 * <p>
 * A Shard token is a colorless Shard enchantment token with “{2}, Sacrifice
 * this enchantment: Scry 1, then draw a card.”
 * <p>
 * A Clue token is a colorless Clue artifact token with “{2}, Sacrifice this
 * artifact: Draw a card.”
 */
public abstract class PredefinedToken extends Token {
    /**
     * Create a token with predefined characteristics.
     *
     * @param s Treasure, food, gold, walker, shard, or clue (case-insensitive)
     * @return A token with the characteristics of the given type
     */
    public static Token create(final String s) {
        return Token.create(
                switch (s.toLowerCase()) {
                    case "treasure" -> "colorless Treasure artifact";
                    case "food" -> "colorless Food artifact";
                    case "gold" -> "colorless Gold artifact";
                    case "walker" -> "2/2 black Zombie creature named Walker";
                    case "shard" -> "colorless Shard enchantment";
                    case "clue" -> "colorless Clue artifact";
                    default -> throw new IllegalArgumentException();
                });
    }
}
