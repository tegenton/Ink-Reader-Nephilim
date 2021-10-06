package tegenton.card.game.concepts.symbols.mana;

class SnowManaSymbol extends ManaSymbol {
    private SnowManaSymbol() {
        super();
    }

    public static SnowManaSymbol fromString(String s) {
        if (s.equalsIgnoreCase("S")) {
            return new SnowManaSymbol();
        }
        return null;
    }

    @Override
    public int getManaValue() {
        return 1;
    }

}
