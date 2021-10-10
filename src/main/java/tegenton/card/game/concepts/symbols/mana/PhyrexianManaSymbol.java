package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;

final class PhyrexianManaSymbol extends ColoredManaSymbol {
    private PhyrexianManaSymbol(final Color color) {
        super();
        this.setColor(color);
    }

    public static PhyrexianManaSymbol fromString(final String s) {
        final PhyrexianManaSymbol symbol;
        final String[] parts = s.split("/");
        if (parts.length == 2 && parts[1].equalsIgnoreCase("P")) {
            try {
                symbol = new PhyrexianManaSymbol(Color.fromString(parts[0]));
            } catch (final InvalidColorException e) {
                return null;
            }
            return symbol;
        }
        return null;
    }

}
