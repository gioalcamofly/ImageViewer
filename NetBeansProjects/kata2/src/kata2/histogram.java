package kata2;

import java.util.HashMap;
import java.util.Map;

public class histogram {
    private final int data[];

    public histogram(int[] data) {
        this.data = data;
    }

    public int[] getData() {
        return data;
    }
    public Map<Integer, Integer> getHistogram() {
        Map<Integer, Integer> histogram = new HashMap<>();
        for (int value: data) {
            histogram.put(value, histogram.containsKey(value)?histogram.get(value) + 1: 1);
        }
        return histogram;
    }
}
