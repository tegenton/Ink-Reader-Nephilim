package tegenton.card.generic;

import java.util.List;
import java.util.function.Function;

public class Filter<T> {
    private final List<Function<String, T>> filter;

    public Filter(List<Function<String, T>> methods) {
        filter = methods;
    }

    public T filter(String s) {
        T result;
        for (Function<String, T> test : filter) {
            result = test.apply(s);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
