import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class S1655_2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    // TODO 우선순위큐를 양쪽으로 만들어서 가운데 숫자를 알수 있게 저장한다
    //  maxQueue[1 2 3] [4 5 6]minQueue 저장되어있을때 중간값 3으로 산출됨
    //  maxQueue의 가장 끝 수가 항상 답이 되게 입력함
    //  maxQueue가 minQueue보다 1 크거나 같도록 크기를 유지한다.
    //  1- maxQueue[1] []minQueue
    //  5- maxQueue[1] [5]minQueue
    //  2- maxQueue[1 2] [5]minQueue
    //  10- maxQueue[1 2] [5 10]minQueue
    //  -99- maxQueue[-99 1 2] [5 10]minQueue
    //  7- maxQueue[-99 1 2] [5 7 10]minQueue
    //  5- maxQueue[-99 1 2 5] [5 7 10]minQueue
    public static String solution(List<String> input) {
        int[] nums = new int[input.size()-1];
        for (int i = 1; i < input.size(); i++) {
            nums[i-1] = Integer.parseInt(input.get(i));
        }

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        // TODO 54~55번쨰라인에서 PriorityQueue에서 poll할때 항상 값이 있도록 초기값 삽입
        maxQueue.add(Integer.MIN_VALUE);
        minQueue.add(Integer.MAX_VALUE);

        StringBuilder b = new StringBuilder();
        for (int num : nums) {
            if (maxQueue.size() > minQueue.size()) {
                minQueue.add(num);
            } else {
                maxQueue.add(num);
            }

            int left = maxQueue.peek();
            int right = minQueue.peek();
            if (left > right) {
                maxQueue.poll();
                maxQueue.add(right);
                minQueue.poll();
                minQueue.add(left);
            }

            b.append(maxQueue.peek());
            b.append('\n');
        }

        return b.toString();
    }
}
