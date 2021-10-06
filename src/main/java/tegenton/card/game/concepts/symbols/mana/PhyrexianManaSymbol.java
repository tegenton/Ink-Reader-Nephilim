package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;

class PhyrexianManaSymbol extends ColoredManaSymbol {
    private PhyrexianManaSymbol(Color color) {
        super();
        this.color = color;
    }

    public static PhyrexianManaSymbol fromString(String s) {
        PhyrexianManaSymbol symbol;
        String[] parts = s.split("/");
        if (parts.length == 2 && parts[1].equalsIgnoreCase("P")) {
            try {
                symbol = new PhyrexianManaSymbol(Color.fromString(parts[0]));
            } catch (InvalidColorException e) {
                return null;
            }
            return symbol;
        }
        return null;
    }

    @Override
    public int getManaValue() {
        return 1;
    }
}
