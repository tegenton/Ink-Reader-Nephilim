package tegenton.card.game.concepts.symbols.planechase;

final class ChaosSymbol extends PlanechaseSymbol {
    private ChaosSymbol() {
        super();
    }

    public static ChaosSymbol fromString(final String s) {
        if (s.equalsIgnoreCase("CHAOS")) {
            return new ChaosSymbol();
        }
        return null;
    }
}
