package tegenton.card.game.concepts.symbols.planechase;

final class PlaneswalkSymbol extends PlanechaseSymbol {
    private PlaneswalkSymbol() {
        super();
    }

    public static PlaneswalkSymbol fromString(final String s) {
        if (s.equalsIgnoreCase("PW")) {
            return new PlaneswalkSymbol();
        }
        return null;
    }
}
