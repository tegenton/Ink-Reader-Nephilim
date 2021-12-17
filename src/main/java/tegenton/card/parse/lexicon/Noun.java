package tegenton.card.parse.lexicon;

public enum Noun implements Word {
    AMOUNT, HEIGHT, NUMBER, RANDOM, TEXT, TIME, WAY, WORD;

    @Override
    public String getWord() {
        return this.name();
    }
}
