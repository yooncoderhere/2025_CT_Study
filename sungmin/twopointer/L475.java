import algorithm.Eq;

import java.util.Arrays;

public class S475 {
    public static void main(String[] args) {
        S475 e = new S475();
        Eq.print(e.findRadius(new int[]{1,2,3},new int[]{2}),1);
        Eq.print(e.findRadius(new int[]{1,2,3,4},new int[]{1,4}),1);
        Eq.print(e.findRadius(new int[]{1,5},new int[]{2}),3);
    }

    // TODO 첫번쨰 접근방법
    //  집과 히터를 정렬한다. -> 히터와 집은 가장 작은 왼쪽 끝에서 부터 시작한다.
    //  house를 순차 탐색 하면서 해당 집과 가장 가까운 히터를 찾아 계속 이동한다.
    //  house {[1], 2, 3, 4} / heater {[1], 4} -> 1-1 = 0
    //  house {1, [2], 3, 4} / heater {[1], 4} -> 1-2 = -1
    //  house {1, 2, [3], 4} / heater {1, [4]} -> 4-3 = 1
    //  house {1, 2, 3, [4]} / heater {1, [4]} -> 4-4 = 4
    //                                    절대값으로 최대 값 1
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int heaterI = 0;
        Integer max = null;
        for (int house : houses) {
            int distance = Math.abs(heaters[heaterI] - house);
            while (heaterI + 1 < heaters.length) {
                int nextDistance = Math.abs(heaters[heaterI + 1] - house);
                if (distance >= nextDistance) {
                    heaterI++;
                    distance = nextDistance;
                } else {
                    break;
                }
            }
            if (max == null) {
                max = distance;
            } else {
                max = Math.max(max, distance);
            }
        }

        return max;
    }
}