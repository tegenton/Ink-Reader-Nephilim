package parse;

class StringSplitter {
    private final String delim = " ,.";
    private String s;

    public StringSplitter(String s) {
        this.s = s;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public String getNext() {
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                token.append(s.charAt(i));
            }
            if (s.length() == i + 1 || s.charAt(i + 1) == ' ') {
                s = s.substring(i + 1);
                break;
            } else if (delim.contains(s.substring(i + 1, i + 2))) {
                s = s.substring(i + 1);
                break;
            }
        }
        return String.valueOf(token);
    }
}
