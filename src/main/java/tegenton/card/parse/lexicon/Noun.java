package tegenton.card.parse.lexicon;

public enum Noun implements Word {
    AMOUNT, FOOT, HEIGHT, LABEL, NUMBER, ORDER, RANDOM, REST, TEXT, TIME, WAY, WORD;

    @Override
    public String getWord() {
        return this.name();
    }
}
