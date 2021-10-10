package tegenton.card.game.concepts.symbols.chapter;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;
import java.util.List;
import java.util.function.Function;

public abstract class ChapterSymbol extends Symbol {
    private static Filter<ChapterSymbol> filter;

    private static void setupFilter() {
        final List<Function<String, ChapterSymbol>> chapterSymbols;
        chapterSymbols = List.of(SingleChapterSymbol::fromString,
                MultipleChapterSymbol::fromString);
        filter = new Filter<>(chapterSymbols);
    }

    /**
     * Determine if s represents a chapter symbol.
     *
     * @param s a string which might represent a chapter symbol, such as II,III
     * @return the ChapterSymbol object represented by s, or null if s does not
     * represent a chapter symbol
     */
    public static ChapterSymbol fromString(final String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }
}
