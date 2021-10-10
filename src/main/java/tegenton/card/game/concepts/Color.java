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
        switch (s.toUpperCase()) {
            case "{W}":
            case "W":
                return white;
            case "{U}":
            case "U":
                return blue;
            case "{B}":
            case "B":
                return black;
            case "{R}":
            case "R":
                return red;
            case "{G}":
            case "G":
                return green;
            case "{C}":
            case "C":
                return null;
            default:
                throw new InvalidColorException();
        }
    }
}
