package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;

final class PrimaryManaSymbol extends ColoredManaSymbol {
    // {W}, {U}, {B}, {R}, {G}, and {C}
    private PrimaryManaSymbol(final Color color) {
        this.setColor(color);
    }

    public static PrimaryManaSymbol fromString(final String s) {
        final PrimaryManaSymbol symbol;
        try {
            symbol = new PrimaryManaSymbol(Color.fromString(s));
        } catch (final InvalidColorException e) {
            return null;
        }
        return symbol;
    }

}
