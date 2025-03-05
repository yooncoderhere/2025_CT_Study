import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class S2461 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        StringTokenizer st = new StringTokenizer(input.get(0));
        int rowLen = Integer.parseInt(st.nextToken());
        int colLen = Integer.parseInt(st.nextToken());
        int[][] students = new int[rowLen][];
        for (int i = 0; i < rowLen; i++) {
            StringTokenizer temp = new StringTokenizer(input.get(i+1));
            int[] row = new int[colLen];
            for (int j = 0; j < colLen; j++) {
                row[j] = Integer.parseInt(temp.nextToken());
            }
            Arrays.sort(row);
            students[i] = row;
        }

        SortedSet<int[]> set = new TreeSet<>(Comparator.comparingInt((int[] it) -> students[it[0]][it[1]]));
        for (int i = 0; i < rowLen; i++) {
            set.add(new int[]{i, 0});
        }

        PriorityQueue<Integer> min = new PriorityQueue<>();
        int[] f = set.first();
        int[] l = set.last();
        min.add(Integer.MAX_VALUE);
        int max = students[l[0]][l[1]];
        int diff = max - students[f[0]][f[1]];
        while (!set.isEmpty()) {
            int[] first = set.first();
            set.remove(first);

            if (set.isEmpty()) {
                break;
            } else if (first[1] == colLen - 1) {
                min.add(students[first[0]][first[1]]);
            } else {
                first[1]++;
                set.add(first);
            }

            int[] last = set.last();
            int[] changedFirst = set.first();
            int curMin = Math.min(min.peek(), students[changedFirst[0]][changedFirst[1]]);
            max = Math.max(max, students[last[0]][last[1]]);
            diff = Math.min(diff, max - curMin);
        }

        return String.valueOf(diff);
    }
}
