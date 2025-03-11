import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S7453().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

// TODO 답보고도 못품 67% 틀렸습니다.
//  a + b 배열 모든요소 합 2중 for문 -> ab
//  c + d 배열 모든요소 합 2중 for문 -> cd
//  two pointer ab=0부터, cd=0부터 시작
//  두개의 합이 0이되는가 보면서 두개의 인덱스를 1씩 늘린다.
//  두개의 합이 0인케이스에서 멈춰서 같은 정답수를 찾는다
//  ex) 1112345 / -1-1-1-5-7-9
//      ^ ^        ^   ^
//    각 3가지 / 3가지가 조합되어 답이 가능함 -> 총 답의수 3*3 = 9개
//   답의 위치를 찾았을때 -> 나와 같은수가 어디까지 나오는지 이진탐색
class S7453 {
    fun solution(input: List<String>): String {
        val len = input[0].toInt()
        val a = IntArray(len)
        val b = IntArray(len)
        val c = IntArray(len)
        val d = IntArray(len)
        for (i in 0 until len) {
            val st = StringTokenizer(input[i+1])
            a[i] = st.nextToken().toInt()
            b[i] = st.nextToken().toInt()
            c[i] = st.nextToken().toInt()
            d[i] = st.nextToken().toInt()
        }

        val twoLen = len*len
        val ab = IntArray(twoLen)
        for (i in 0 until len) {
            for (j in 0 until len) {
                ab[i*len + j] = a[i] + b[j]
            }
        }

        val cd = IntArray(twoLen)
        for (i in 0 until len) {
            for (j in 0 until len) {
                cd[i*len + j] = -c[i] - d[j]
            }
        }
        Arrays.sort(ab)
        Arrays.sort(cd)

        var result = 0L
        var abI = 0
        var cdI = 0
        while (abI < twoLen && cdI < twoLen) {
            val sum = ab[abI] - cd[cdI]

            if (sum > 0) {
                cdI++
            } else if (sum < 0) {
                abI++
            } else {
                val abLen = continueEnd(ab, abI)
                val cdLen = continueEnd(cd, cdI)
                result += (abLen * cdLen)
                abI += abLen
                cdI += cdLen
            }
        }
        return result.toString()
    }

    private fun continueEnd(nums: IntArray, start: Int): Int {
        var l = start
        var r = nums.size - 1
        var end = start
        while (l <= r) {
            val m = l + ((r - l) / 2)
            if (nums[m] == nums[start]) {
                end = m
                l = m + 1
            } else {
                r = m - 1
            }
        }
        return end - start + 1
    }
}
