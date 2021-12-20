package tegenton.card.parse.lexicon;

public enum Noun implements Word {
    AMOUNT, FOOT, HEIGHT, NUMBER, ORDER, RANDOM, TEXT, TIME, WAY, WORD;

    @Override
    public String getWord() {
        return this.name();
    }
}
