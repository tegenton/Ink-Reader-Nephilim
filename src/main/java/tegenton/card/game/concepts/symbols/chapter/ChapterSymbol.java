package tegenton.card.game.concepts.symbols.chapter;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;

import java.util.List;
import java.util.function.Function;

public abstract class ChapterSymbol extends Symbol {
    private static Filter<ChapterSymbol> filter;

    private static void setupFilter() {
        List<Function<String, ChapterSymbol>> chapterSymbols;
        chapterSymbols = List.of(SingleChapterSymbol::fromString,
                MultipleChapterSymbol::fromString);
        filter = new Filter<>(chapterSymbols);
    }

    public static ChapterSymbol fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }
}
