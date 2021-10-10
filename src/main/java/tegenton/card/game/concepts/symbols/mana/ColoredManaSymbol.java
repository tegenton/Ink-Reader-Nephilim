package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import java.util.EnumSet;

abstract class ColoredManaSymbol extends ManaSymbol {
    private Color color;

    @Override
    public EnumSet<Color> getType() {
        if (color == null) {
            return EnumSet.noneOf(Color.class);
        }
        return EnumSet.of(color);
    }

    void setColor(final Color newColor) {
        this.color = newColor;
    }
}
