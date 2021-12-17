package tegenton.card.parse.lexicon;

public enum Noun implements Word {
    AMOUNT, HEIGHT, NUMBER, TEXT, WORD;

    @Override
    public String getWord() {
        return this.name();
    }
}
