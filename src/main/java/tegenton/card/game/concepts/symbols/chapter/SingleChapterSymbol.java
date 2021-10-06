package tegenton.card.game.concepts.symbols.chapter;

class SingleChapterSymbol extends ChapterSymbol {
    private final int chapter;

    private SingleChapterSymbol(int chapter) {
        this.chapter = chapter;
    }

    public static SingleChapterSymbol fromString(String s) {
        int chapter;
        switch (s.toUpperCase()) {
            case "I":
                chapter = 1;
                break;
            case "II":
                chapter = 2;
                break;
            case "III":
                chapter = 3;
                break;
            case "IV":
                chapter = 4;
                break;
            case "V":
                chapter = 5;
                break;
            default:
                return null;
        }
        return new SingleChapterSymbol(chapter);
    }

    public int getChapter() {
        return chapter;
    }
}
