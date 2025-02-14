import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S2879_2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int len = Integer.parseInt(input.get(0));
        StringTokenizer l = new StringTokenizer(input.get(1), " ");
        StringTokenizer r = new StringTokenizer(input.get(2), " ");
        int[] distances = new int[len];
        for (int i = 0; i < len; i++) {
            distances[i] = Integer.parseInt(l.nextToken()) - Integer.parseInt(r.nextToken());
        }

        int count = 0;
        int index = 0;
        while (index < len) {
            if (distances[index] == 0) {
                index++;
            } else {
                move(index, distances);
                count++;
            }
        }

        return String.valueOf(count);
    }

    static void move(int start, int[] distances) {
        int direction = Integer.compare(distances[start], 0);
        int end = start;
        int count = 1;
        for (int i = start+1; i < distances.length; i++) {
            if (direction == Integer.compare(distances[i], 0)) {
                count++;
                end = i;
            } else {
                count = count - 2;
                if (count < 0) {
                    break;
                }
            }
        }

        for (int i = start; i <= end; i++) {
            distances[i] = distances[i] - direction;
        }
    }
}
