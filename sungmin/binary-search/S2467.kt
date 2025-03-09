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
            bw.write(S2467().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S2467 {
    fun solution(input: List<String>): String {
        val len = input[0].toInt()
        val st = StringTokenizer(input[1])
        val nums = IntArray(len)
        for (i in 0 until len) {
            nums[i] = st.nextToken().toInt()
        }

        var l = 0
        var r = len - 1
        val result = intArrayOf(nums[l], nums[r])
        var min = abs(nums[l] + nums[r])
        while (l < r) {
            val sum = nums[l] + nums[r]
            if (abs(sum) < min) {
                min = abs(sum)
                result[0] = nums[l]
                result[1] = nums[r]
                if (min == 0) {
                    break
                }
            } else {
                if (sum < 0) {
                    l++
                } else {
                    r--
                }
            }
        }

        return result[0].toString() + " " + result[1]
    }
}
