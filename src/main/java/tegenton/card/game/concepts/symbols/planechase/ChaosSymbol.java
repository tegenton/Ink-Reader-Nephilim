package tegenton.card.game.concepts.symbols.planechase;

class ChaosSymbol extends PlanechaseSymbol {
    private ChaosSymbol() {
        super();
    }

    public static ChaosSymbol fromString(String s) {
        if (s.equalsIgnoreCase("CHAOS")) {
            return new ChaosSymbol();
        }
        return null;
    }
}
