package tegenton.card.generic;

public class StringSplitter {
    private final String delim = " ,.";
    private String string;

    public StringSplitter(String s) {
        string = s;
    }

    public boolean hasNext() {
        return !string.isEmpty();
    }

    public String getNext() {
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                token.append(string.charAt(i));
            }
            if (string.length() == i + 1 || string.charAt(i + 1) == ' ') {
                string = string.substring(i + 1);
                break;
            } else if (delim.contains(string.substring(i + 1, i + 2))) {
                string = string.substring(i + 1);
                break;
            }
        }
        return String.valueOf(token);
    }
}
