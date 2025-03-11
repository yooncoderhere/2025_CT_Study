import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors

// TODO 답보고 품 https://st-lab.tistory.com/277
fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S2110().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S2110 {
    fun solution(input: List<String>): String {
        val st = StringTokenizer(input[0])
        st.nextToken()
        val count = st.nextToken().toInt()
        val nums: ArrayList<Int> = input.stream()
            .skip(1)
            .map { it.toInt() }
            .sorted()
            .collect(Collectors.toCollection { ArrayList() })

        var l = 0
        var r = 1_000_000_000
        var result = 1
        while (l <= r) {
            val m = (l + r) / 2
            val isOver = canPlace(nums, m, count)
            if (isOver) {
                result = m
                l = m + 1
            } else {
                r = m - 1
            }
        }


        return result.toString()
    }

    // TODO 이부분에서 첫번째 부터가 아니라 두번째 집부터 설치하는 경우에 답인 반례는 없나 의심이 들긴함
    private fun canPlace(nums: ArrayList<Int>, minDist: Int, target: Int): Boolean {
        var count = 0
        var pre = -1_000_000_000
        for (num in nums) {
            val dist = num - pre
            if (dist >= minDist) {
                pre = num
                count++
                if (target <= count) {
                    return true
                }
            }
        }
        return false
    }
}
