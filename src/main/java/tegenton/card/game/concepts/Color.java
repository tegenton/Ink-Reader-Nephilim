package tegenton.card.game.concepts;

public enum Color {
    white,
    blue,
    black,
    red,
    green;

    /**
     * If s represents a color (or colorless), this function returns that color.
     * s may be formatted as {W},W,{w}, or w for any of WUBRG or C.
     *
     * @param s string that may contain a color
     * @return the corresponding color, or null for colorless
     * @throws InvalidColorException if s is not a color or colorless
     */
    public static Color
    fromString(final String s) throws InvalidColorException {
        return switch (s.toUpperCase()) {
            case "{W}", "W" -> white;
            case "{U}", "U" -> blue;
            case "{B}", "B" -> black;
            case "{R}", "R" -> red;
            case "{G}", "G" -> green;
            case "{C}", "C" -> null;
            default -> throw new InvalidColorException();
        };
    }
}
