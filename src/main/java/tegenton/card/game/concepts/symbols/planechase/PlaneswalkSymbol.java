package tegenton.card.game.concepts.symbols.planechase;

class PlaneswalkSymbol extends PlanechaseSymbol {
    private PlaneswalkSymbol() {
        super();
    }

    public static PlaneswalkSymbol fromString(String s) {
        if (s.equalsIgnoreCase("PW")) {
            return new PlaneswalkSymbol();
        }
        return null;
    }
}
