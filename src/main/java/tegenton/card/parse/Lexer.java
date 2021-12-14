package tegenton.card.parse;

import tegenton.card.parse.lexicon.Word;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public final class Lexer implements Collector<String, Stream.Builder<Word>, Stream<Word>> {
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

    public List<Word> lex(final String s) {
        String[] text = s.split(" ");
        for (int i = 0; i < text.length - 1; i++) {
            text[i] += ' ';
        }
        return Arrays.stream(text).parallel().collect(this).toList();
    }
}
