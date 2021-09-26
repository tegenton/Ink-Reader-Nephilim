package generic;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Filter<T> {
    private final List<Function<String, Optional<T>>> filter;

    public Filter(List<Function<String, Optional<T>>> methods) {
        filter = methods;
    }

    public Optional<T> filter(String s) {
        T result;
        for (Function<String, Optional<T>> test : filter) {
            result = test.apply(s).orElse(null);
            if (result != null) {
                return Optional.of(result);
            }
        }
        return Optional.empty();
    }
}
