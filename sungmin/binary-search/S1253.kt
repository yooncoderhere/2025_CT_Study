package algorithm.bakjon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(KS1253().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class KS1253 {
    fun solution(input: List<String>): String {
        val len = input[0].toInt()
        val nums = IntArray(len)
        val st = StringTokenizer(input[1])
        for (i in 0 until len) {
            nums[i] = st.nextToken().toInt()
        }
        Arrays.sort(nums)

        var result = 0
        for (i in 0 until len) {
            val target = nums[i]
            var l = 0
            var r = len - 1
            while (l < r) {
                if (l == i) {
                    l++
                    continue
                }
                if (r == i) {
                    r--
                    continue
                }
                val sum = nums[l] + nums[r]
                if (sum == target) {
                    result++
                    break
                } else if (sum < target) {
                    l++
                } else {
                    r--
                }
            }
        }
        return result.toString()
    }
}
