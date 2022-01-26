package tegenton.card.lexer;

import tegenton.card.lexicon.Lexicon;
import tegenton.card.lexicon.Word;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public final class Lexer
        implements Collector<String, Stream.Builder<Word>, Stream<Word>> {
    @Override
    public Supplier<Stream.Builder<Word>> supplier() {
        return Stream::builder;
    }

    @Override
    public BiConsumer<Stream.Builder<Word>, String> accumulator() {
        return (stream, s) -> Lexicon.lookup(s).forEach(stream::add);
    }

    @Override
    public BinaryOperator<Stream.Builder<Word>> combiner() {
        return (streamA, streamB) -> {
            streamB.build().forEach(streamA::add);
            return streamA;
        };
    }

    @Override
    public Function<Stream.Builder<Word>, Stream<Word>> finisher() {
        return Stream.Builder::build;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }

    /**
     * Split string on spaces, lex each individual section, then return each
     * word encountered.
     *
     * @param s String to lex.
     * @return List of Words that the string contains.
     */
    public List<Word> lex(final String s) {
        return split(s).parallel().collect(this).toList();
    }

    private Stream<String> split(String s) {
        Stream.Builder<String> stream = Stream.builder();
        int i = 0;
        for (int next = s.indexOf(' '); next != -1; ) {
            next++;
            stream.add(s.substring(i, next));
            i = next;
            next = s.indexOf(' ', next);
        }
        stream.add(s.substring(i));
        return stream.build();
    }
}
