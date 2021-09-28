package tegenton.card.game.concepts;

public enum Color {
    white,
    blue,
    black,
    red,
    green;

    public static Color fromString(String s) throws InvalidColorException {
        switch (s) {
            case "{W}":
            case "{w}":
            case "W":
            case "w":
                return white;
            case "{U}":
            case "{u}":
            case "U":
            case "u":
                return blue;
            case "{B}":
            case "{b}":
            case "B":
            case "b":
                return black;
            case "{R}":
            case "{r}":
            case "R":
            case "r":
                return red;
            case "{G}":
            case "{g}":
            case "G":
            case "g":
                return green;
            case "{C}":
            case "{c}":
            case "C":
            case "c":
                return null;
            default:
                throw new InvalidColorException();
        }
    }
}
