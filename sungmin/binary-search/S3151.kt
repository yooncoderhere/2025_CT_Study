import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors
import kotlin.math.max

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S3151().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S3151 {
    fun solution(input: List<String>): String {
        val len = input[0].toInt()
        val st = StringTokenizer(input[1])
        val nums = IntArray(len)
        for (i in 0 until len) {
            nums[i] = st.nextToken().toInt()
        }
        Arrays.sort(nums)

        var result = 0L
        for (fix1 in 0 until len - 2) {
            inner@ for (fix2 in fix1+1 until len - 1) {
                val twoSum = nums[fix1] + nums[fix2]
                val startIndex = findStartZeroPoint(
                    twoSum,
                    fix2 + 1,
                    len - 1,
                    nums
                )
                if (startIndex >= nums.size) {
                    continue@inner
                }

                val endIndex = findEndZeroPoint(startIndex, nums)
                result += (endIndex - startIndex + 1)
            }
        }

        return result.toString()
    }

    fun findStartZeroPoint(twoSum: Int, l: Int, r: Int, nums: IntArray): Int {
        var left = l
        var right = r
        while (left <= right) {
            val mid = (left + right) / 2
            val sum = twoSum + nums[mid]
            if (sum < 0) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        val min = Math.min(left, right)
        val max = Math.max(left, right)
        if (min > l && twoSum + nums[min] == 0) {
            return min
        } else if (max < nums.size && twoSum + nums[max] == 0) {
            return max
        } else {
            return nums.size
        }
    }

    fun findEndZeroPoint(startIndex: Int, nums: IntArray): Int {
        val target = nums[startIndex]
        var left = startIndex
        var right = nums.size - 1
        var result = left
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) {
                result = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return result
    }
}
