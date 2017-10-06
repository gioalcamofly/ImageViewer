package kata2;

import java.util.HashMap;
import java.util.Map;

public class histogram<T> {
    private final T data[];

    public histogram(T data) {
        this.data = (T[]) data;
    }

    public T getData() {
        return (T) data;
    }
    public Map<T, Integer> getHistogram() {
        Map<T, Integer> histogram = new HashMap<>();
        for (T value: data) {
            histogram.put(value, histogram.containsKey(value)?histogram.get(value) + 1: 1);
        }
        return histogram;
    }
}
