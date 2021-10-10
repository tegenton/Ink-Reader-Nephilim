package tegenton.card.generic;

/**
 * Split a string into a pseudo stream.
 */
public final class StringSplitter {
    private final String delim = " ,.";
    private String string;

    /**
     * Create a new string splitter with the given string.
     *
     * @param s a string to split
     */
    public StringSplitter(final String s) {
        string = s;
    }

    /**
     * If this method returns true, a call to getNext should return a non-empty
     * string.
     *
     * @return are there any characters left in the string?
     */
    public boolean hasNext() {
        return !string.isEmpty();
    }

    /**
     * The string of characters between the last value returned and the next
     * instance of a delimiter character.
     *
     * @return substring of the original string
     */
    public String getNext() {
        final StringBuilder token = new StringBuilder();
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
