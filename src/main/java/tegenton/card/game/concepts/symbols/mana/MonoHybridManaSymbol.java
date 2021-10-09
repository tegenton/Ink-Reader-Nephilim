package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.InvalidColorException;

class MonoHybridManaSymbol extends ColoredManaSymbol {
    private final int value;

    private MonoHybridManaSymbol(int value, Color c) {
        super();
        this.value = value;
        color = c;
    }

    public static MonoHybridManaSymbol fromString(String s) {
        MonoHybridManaSymbol symbol;
        String[] parts = s.split("/");
        if (parts.length == 2) {
            try {
                symbol = new MonoHybridManaSymbol(Integer.parseInt(parts[0]),
                        Color.fromString(parts[1]));
            } catch (NumberFormatException | InvalidColorException e) {
                return null;
            }
            return symbol;
        }
        return null;
    }

    @Override
    public int getManaValue() {
        return value;
    }
}
