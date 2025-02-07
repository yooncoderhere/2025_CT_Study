import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class S2179 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        Map<String, Group> groups = new HashMap<>(26);
        Set<String> set = new HashSet<>(input.size() - 1);
        int maxLen = 1;
        for (int i = 1; i < input.size(); i++) {
            String o = input.get(i);
            maxLen = Math.max(maxLen, o.length());
            if (!set.contains(o)) {
                int finalI = i;
                set.add(o);
                groups.compute(o.substring(0, 1), (k, v) -> v == null ? new Group(o,finalI) : v.add(o,finalI));
            }
        }

        Map<String, Group> next = new HashMap<>();
        for (Map.Entry<String, Group> entry : groups.entrySet()) {
            if (entry.getValue().list.size() > 1) {
                next.put(entry.getKey(), entry.getValue());
            }
        }
        groups = next;

        int prefixLen = 1;
        while (!groups.isEmpty()) {
            next = new HashMap<>();
            prefixLen++;
            for (Map.Entry<String, Group> entry : groups.entrySet()) {
                entry.getValue().split(prefixLen, next);
            }

            Map<String, Group> temp = new HashMap<>();
            for (Map.Entry<String, Group> entry : next.entrySet()) {
                if (entry.getValue().list.size() > 1) {
                    temp.put(entry.getKey(), entry.getValue());
                }
            }

            if (temp.isEmpty()) {
                break;
            }
            groups = temp;
        }

        List<String> list = groups.entrySet().stream()
                .sorted(Comparator.comparingInt(a -> a.getValue().minIndex()))
                .findFirst()
                .get()
                .getValue()
                .list;
        return list.get(0) + '\n' + list.get(1);
    }

    static class Group {
        List<String> list = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        Group(String init, int initIndex) {
            list.add(init);
            index.add(initIndex);
        }

        Group add(String s, int sIndex) {
            list.add(s);
            index.add(sIndex);
            return this;
        }

        void split(int n, Map<String, Group> groups) {
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (s.length() >= n) {
                    Integer si = index.get(i);
                    String substring = s.substring(0, n);
                    groups.compute(substring, (k, v) -> v == null ? new Group(s, si) : v.add(s, si));
                }
            }
        }

        int minIndex() {
            return index.get(0);
        }
    }

}
