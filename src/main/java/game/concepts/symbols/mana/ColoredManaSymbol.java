package game.concepts.symbols.mana;

import game.concepts.Color;

import java.util.EnumSet;

abstract class ColoredManaSymbol extends ManaSymbol {
    protected Color color;

    @Override
    public EnumSet<Color> getType() {
        if (color == null) {
            return EnumSet.noneOf(Color.class);
        }
        return EnumSet.of(color);
    }
}
