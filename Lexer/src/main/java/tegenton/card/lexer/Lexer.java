package tegenton.card.lexer;

import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Word;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Lexer implements Collector<String, Stream.Builder<Word>, Stream<Word>> {
    public static List<Word> lex(String text) {
        StringStreamBuilder builder = new StringStreamBuilder(text);
        return builder.build().collect(Lexer.toWordStream()).toList();
    }

    public static Lexer toWordStream() {
        return new Lexer();
    }

    @Override
    public Supplier<Stream.Builder<Word>> supplier() {
        return Stream::builder;
    }

    @Override
    public BiConsumer<Stream.Builder<Word>, String> accumulator() {
        return (stream, string) -> stream.add(Tokenizer.tokenize(string));
    }

    @Override
    public BinaryOperator<Stream.Builder<Word>> combiner() {
        return (a, b) -> {
            b.build().forEach(a::add);
            return a;
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
}
