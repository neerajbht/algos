package map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortByValue {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 50);
        map.put("Orange", 20);
        map.put("Banana", 30);

        // 1. Convert to stream, sort, and collect into a LinkedHashMap
        Map<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println(sortedMap);
    }
}