import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class S11286 {
    public static void main(String[] args) throws IOException {
        int c = Comparator.comparingInt((Integer it) -> Math.abs(it))
                .thenComparingInt((Integer it) -> it).compare(-1, 1);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt((Integer it) -> Math.abs(it))
                        .thenComparingInt((Integer it) -> it)
        );
//        Queue<Integer> pq = new Queue<>(
//                Comparator.comparingInt((Integer it) -> Math.abs(it))
//                        .thenComparingInt((Integer it) -> it)
//        );
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.size(); i++) {
            int v = Integer.parseInt(input.get(i));
            if (v == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll());
                    sb.append('\n');
                }
            } else {
                pq.add(v);
            }
        }
        return sb.toString();
    }

    static class Queue<T> {
        Object[] arr;
        int size;
        Comparator<T> comparator;
        public Queue(Comparator<T> comparator) {
            this.arr = new Object[8];
            this.comparator = comparator;
        }

        @SuppressWarnings("unchecked")
        void push(T t) {
            if (size == 0) {
                arr[0] = t;
            } else if (arr.length == size) {
                // 길이 에러남
                arr = Arrays.copyOf(arr, arr.length * 2);
            }

            int l = 0;
            int r = size - 1;
            while(l < r) {
                int m = (l + r) / 2;
                int compare = comparator.compare(t, (T) arr[m]);
                if (compare == 0) {
                    l = m;
                    break;
                } else if (compare < 0) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            int c = comparator.compare(t, (T) arr[l]);
            int index = c <= 0 ? l : l+1;
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }

            arr[index] = t;
            size++;
        }

        @SuppressWarnings("unchecked")
        T pop() {
            if (size == 0) {
                return null;
            }

            T value = (T) arr[0];
            for (int i = 0; i < size; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            return value;
        }
    }
}
