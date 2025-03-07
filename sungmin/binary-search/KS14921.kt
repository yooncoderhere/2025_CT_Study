package algorithm.bakjon

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
            bw.write(KS14921().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class KS14921 {
    fun solution(input: List<String>): String {
        val len = input[0].toInt()
        val st = StringTokenizer(input[1])
        val nums = IntArray(len)
        for (i in 0 until len) {
            nums[i] = st.nextToken().toInt()
        }
        Arrays.sort(nums);

        var l = 0
        var r = len - 1
        var result = nums[r] + nums[l]
        var min = abs(result)
        while (l < r) {
            val sum = nums[l] + nums[r]
            if (sum == 0) {
                return "0";
            } else if (sum < 0) {
                l++
            } else {
                r--
            }

            val a = abs(sum)
            if (min > a) {
                result = sum
                min = a
            }
        }

        return result.toString()
    }
}
