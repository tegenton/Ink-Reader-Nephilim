package tegenton.card.parse.lexicon.value;

public enum Variable implements ValueWord {
    X, Y;

    @Override
    public String getWord() {
        return this.name();
    }

    @Override
    public int getVal() {
        return 0;
    }
}
