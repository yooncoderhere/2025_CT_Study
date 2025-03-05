import java.util.HashMap;
import java.util.Map;

// TODO 답보고 배낌
public class S992_3 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int result = 0;
        for (int left = 0; left < nums.length; left++) {
            int[] frequency = new int[nums.length + 1];
            int variety = 0;

            // TODO 1-1. 왼쪽(시작지점)이 고정이고 / 오른쪽을 계속 갔을떄 k-1에서 k로 변하는 지점이 어디인가?
            int kUnderPoint = -1;
            for (int i = left; i < nums.length; i++) {
                int nextNum = nums[i];
                frequency[nextNum]++;
                if (frequency[nextNum] == 1) {
                    variety++;
                    if (variety == k) {
                        kUnderPoint = i;
                        break;
                    }
                }
            }

            // TODO 1-2. k까지 도달하지 못함 -> 이 뒤로 정답이 나올수 없음 장사 접어
            if (kUnderPoint == -1) {
                break;
            }

            // TODO 2-1. 왼쪽(시작지점)이 고정이고 / 오른쪽을 계속 갔을때 k에서 k+1로 변하는 지점이 어디인가?
            int kOverPoint = kUnderPoint;
            for (int i = kOverPoint + 1; i < nums.length; i++) {
                int nextNum = nums[i];
                frequency[nextNum]++;
                if (frequency[nextNum] == 1) {
                    break;
                } else {
                    kOverPoint = i;
                }
            }

            // TODO 3-2. 이 두 지점의 차이가 추가할 count
            result = result + kOverPoint - kUnderPoint + 1;
        }
        return result;
    }
}
