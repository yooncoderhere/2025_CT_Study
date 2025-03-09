import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors
import kotlin.math.abs

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S2473().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

// TODO
//  1. 정렬하고 2중 for문으로 전체순회하면서 2개의 수를 더한 값을 찾느다.
//  2. 이진 탐색으로 (1)에 더했을때 가장 작아지는 값을 찾는다.
class S2473 {
    fun solution(input: List<String>): String {
        val len = input[0].toInt()
        val st = StringTokenizer(input[1])
        val nums = IntArray(len)
        for (i in 0 until len) {
            nums[i] = st.nextToken().toInt()
        }
        Arrays.sort(nums)

        if(nums[0] > 0) {
            return "${nums[0]} ${nums[1]} ${nums[2]}"
        } else if (nums[len - 1] < 0) {
            return "${nums[len - 3]} ${nums[len - 2]} ${nums[len - 1]}"
        }

        var min = Math.abs(nums[0].toLong() + nums[1] + nums[2])
        val result = intArrayOf(nums[0], nums[1], nums[2])
        for (fix1 in 0 until len - 2) {
            for (fix2 in fix1+1 until len - 1) {
                val twoSum = (nums[fix1] + nums[fix2]).toLong()
                var l = fix2 + 1
                var r = len - 1
                while (l <= r) {
                    val m = (l + r) / 2
                    val sum = twoSum + nums[m]
                    if (sum == 0L) {
                        return "${nums[fix1]} ${nums[fix2]} ${nums[m]}"
                    } else if (sum < 0L) {
                        if (-sum < min) {
                            min = -sum
                            result[0] = nums[fix1]
                            result[1] = nums[fix2]
                            result[2] = nums[m]
                        }
                        l = m + 1
                    } else {
                        if (sum < min) {
                            min = sum
                            result[0] = nums[fix1]
                            result[1] = nums[fix2]
                            result[2] = nums[m]
                        }
                        r = m - 1
                    }
                }
            }
        }

        return "${result[0]} ${result[1]} ${result[2]}"
    }
}
