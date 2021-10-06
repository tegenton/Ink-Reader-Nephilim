package tegenton.card.game.concepts.symbols.chapter;

class MultipleChapterSymbol extends ChapterSymbol {
    private final int[] chapters;

    private MultipleChapterSymbol(int[] chapters) {
        this.chapters = chapters;
    }

    public static MultipleChapterSymbol fromString(String s) {
        int[] chapters;
        switch (s.toUpperCase()) {
            case "I,II":
                chapters = new int[]{1, 2};
                break;
            case "II,III":
                chapters = new int[]{2, 3};
                break;
            case "I,II,III":
                chapters = new int[]{1, 2, 3};
                break;
            default:
                return null;
        }
        return new MultipleChapterSymbol(chapters);
    }

    public int[] getChapters() {
        return chapters;
    }
}
