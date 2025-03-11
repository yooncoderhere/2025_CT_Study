import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import java.util.stream.Collectors
import kotlin.collections.ArrayList

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S12015().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

// TODO 답보고 품... https://st-lab.tistory.com/285
class S12015 {
    fun solution(input: List<String>): String {
        val len = input[0].toInt()
        val st = StringTokenizer(input[1])
        val nums = IntArray(len)
        for (i in 0 until len) {
            nums[i] = st.nextToken().toInt()
        }


        val list = ArrayList<Int>(len)
        list.add(nums.first())
        for (i in 1 until nums.size) {
            val num = nums[i]
            var l = 0
            var r = list.size - 1

            var changeIndex = 0
            while (l <= r) {
                val m = (l + r) / 2
                if (list[m] < num) {
                    changeIndex = m + 1
                    l = m + 1
                } else {
                    changeIndex = m
                    r = m - 1
                }
            }

            if (changeIndex == list.size) {
                list.add(num)
            } else {
                list[changeIndex] = num
            }
        }

        return list.size.toString()
    }
}
