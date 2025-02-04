import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S11728 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int[] arr1 = Arrays.stream(input.get(1).split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arr2 = Arrays.stream(input.get(2).split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int arr1Index = 0;
        int arr2Index = 0;

        StringBuilder b = new StringBuilder();
        while (arr1Index < arr1.length || arr2Index < arr2.length) {
            if (arr1Index == arr1.length) {
                b.append(arr2[arr2Index]);
                b.append(' ');
                arr2Index++;
            } else if (arr2Index == arr2.length) {
                b.append(arr1[arr1Index]);
                b.append(' ');
                arr1Index++;
            } else {
                if (arr1[arr1Index] < arr2[arr2Index]) {
                    b.append(arr1[arr1Index]);
                    b.append(' ');
                    arr1Index++;
                } else {
                    b.append(arr2[arr2Index]);
                    b.append(' ');
                    arr2Index++;
                }
            }
        }

        return b.toString();
    }
}
