package parse;

class StringSplitter {
    private final String delim = " ,.";
    private String s;

    public StringSplitter(String s) {
        this.s = s;
    }

    public boolean hasNext() {
        return !this.s.isEmpty();
    }

    public String getNext() {
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < this.s.length(); i++) {
            if (this.s.charAt(i) != ' ') {
                token.append(this.s.charAt(i));
            }
            if (this.s.length() == i + 1 || this.s.charAt(i + 1) == ' ') {
                this.s = this.s.substring(i + 1);
                break;
            } else if (this.delim.contains(this.s.substring(i + 1, i + 2))) {
                this.s = this.s.substring(i + 1);
                break;
            }
        }
        return String.valueOf(token);
    }
}
