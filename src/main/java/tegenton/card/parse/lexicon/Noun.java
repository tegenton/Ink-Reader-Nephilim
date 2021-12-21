package tegenton.card.parse.lexicon;

public enum Noun implements Word {
    AMOUNT, CHOICE, FOOT, HEIGHT, INSTANCE, LABEL, NUMBER, ORDER, RANDOM, REST, TEXT, TIME, WAY, WORD;

    @Override
    public String getWord() {
        return this.name();
    }
}
