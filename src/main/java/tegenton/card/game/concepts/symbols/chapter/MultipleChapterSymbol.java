package tegenton.card.game.concepts.symbols.chapter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

final class MultipleChapterSymbol extends ChapterSymbol {
    private final int[] chapters;

    private MultipleChapterSymbol(final List<Integer> chapterList) {
        chapters = new int[chapterList.size()];
        for (int i = 0; i < chapters.length; i++) {
            chapters[i] = chapterList.get(i);
        }
    }

    public static MultipleChapterSymbol fromString(final String s) {
        final String[] split = s.toUpperCase().split(",");
        final List<Integer> chapterNums = Arrays.stream(split)
                .map(SingleChapterSymbol::fromString)
                .filter(Objects::nonNull)
                .map(SingleChapterSymbol::getChapter)
                .collect(Collectors.toList());
        if (chapterNums.size() < 2 || chapterNums.size() != split.length) {
            return null;
        }
        return new MultipleChapterSymbol(chapterNums);
    }

    public int[] getChapters() {
        return chapters;
    }
}
