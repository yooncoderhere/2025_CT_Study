import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S2512().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S2512 {
    fun solution(input: List<String>): String {
        val len = input[0].toInt()
        val target = input[2].toInt()
        val st = StringTokenizer(input[1])
        val nums = IntArray(len)
        for (i in 0 until len) {
            nums[i] = st.nextToken().toInt()
        }

        Arrays.sort(nums)
        var l = 1
        var r = nums.last()
        var result = 0
        while (l <= r) {
            val m = (l + r) / 2
            val sum = sum(m, nums)
            if (sum > target) {
                r = m - 1
            } else {
                result = m
                l = m + 1
            }
        }

        return result.toString()
    }

    private fun sum(size: Int, nums: IntArray): Int {
        var sum = 0
        for (i in nums.indices) {
            if (nums[i] < size) {
                sum += nums[i]
            } else {
                sum += (nums.size - i) * size
                break
            }
        }
        return sum
    }
}
