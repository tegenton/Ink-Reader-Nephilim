package tegenton.card.game.concepts.token;

public abstract class PredefinedToken extends Token {
    /*111.10a A Treasure token is a colorless Treasure artifact token with
    “{T}, Sacrifice this artifact: Add one mana of any color.”
111.10b A Food token is a colorless Food artifact token with “{2}, {T}, Sacrifice this artifact: You
gain 3 life.”
111.10c A Gold token is a colorless Gold artifact token with “Sacrifice this artifact: Add one mana
of any color.”
111.10d A Walker token is a 2/2 black Zombie creature token named Walker.
111.10e A Shard token is a colorless Shard enchantment token with “{2}, Sacrifice this
enchantment: Scry 1, then draw a card.”
111.10f A Clue token is a colorless Clue artifact token with “{2}, Sacrifice this artifact: Draw a
card.”*/
    public static Token create(String s) {
        switch (s.toLowerCase()) {
            case "treasure":
                return Token.create("colorless Treasure artifact");
            case "food":
                return Token.create("colorless Food artifact");
            case "gold":
                return Token.create("colorless Gold artifact");
            case "walker":
                return Token.create("2/2 black Zombie creature named Walker");
            case "shard":
                return Token.create("colorless Shard enchantment");
            case "clue":
                return Token.create("colorless Clue artifact");
            default:
                return null;
        }
    }
}
