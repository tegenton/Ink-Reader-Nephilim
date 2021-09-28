package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.symbols.Symbol;

import java.util.Optional;

class SnowManaSymbol extends ManaSymbol {
    private SnowManaSymbol() {
        super();
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.equalsIgnoreCase("S")) {
            return Optional.of(new SnowManaSymbol());
        }
        return Optional.empty();
    }

    @Override
    public int getManaValue() {
        return 1;
    }

}
