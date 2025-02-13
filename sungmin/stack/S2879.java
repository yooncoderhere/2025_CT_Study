import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// TODO 이게맞아? for문 무식하게 돌려도 되네....
public class S2879 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int[] start = Arrays.stream(input.get(1).split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] dest = Arrays.stream(input.get(2).split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] distance = new int[start.length];
        for (int i = 0; i < start.length; i++) {
            distance[i] = start[i] - dest[i];
        }

        int unResolvedIndex = 0;
        int result = 0;
        while (unResolvedIndex < distance.length) {
            if (distance[unResolvedIndex] == 0) {
                unResolvedIndex++;
            } else {
                resolve(unResolvedIndex, distance);
                result++;
            }
        }

        return String.valueOf(result);
    }

    private static void resolve(int index, int[] distance) {
        int endIndex = index;
        int moveCount = 1;

        if (distance[index] < 0) {
            for (int i = index + 1; i < distance.length; i++) {
                if (distance[i] < 0) {
                    moveCount++;
                } else {
                    moveCount = moveCount - 2;
                }

                if (moveCount < 0) {
                    break;
                } else if (distance[i] < 0) {
                    endIndex = i;
                }
            }
            for (int i = index; i <= endIndex; i++) {
                distance[i]++;
            }
        } else {
            for (int i = index + 1; i < distance.length; i++) {
                if (distance[i] > 0) {
                    moveCount++;
                } else {
                    moveCount = moveCount - 2;
                }

                if (moveCount < 0) {
                    break;
                } else if (distance[i] > 0) {
                    endIndex = i;
                }
            }
            for (int i = index; i <= endIndex; i++) {
                distance[i]--;
            }
        }
    }
}
