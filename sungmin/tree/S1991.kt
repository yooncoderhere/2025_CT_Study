import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S1991().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S1991 {
    fun solution(input: List<String>): String {
        val arr = Array(26) { IntArray(2) { -1 } }
        for (i in 1 until input.size) {
            val s = input[i]
            val p = arr[s[0] - 'A']
            if ('.' != s[2]) {
                p[0] = s[2] - 'A'
            }
            if ('.' != s[4]) {
                p[1] = s[4] - 'A'
            }
        }

        // 전위 순회한 결과 : ABDCEFG (루트) (왼쪽 자식) (오른쪽 자식)
        val front = front(arr)

        // 중위 순회한 결과 : DBAECFG (왼쪽 자식) (루트) (오른쪽 자식)
        val middle = middle(arr)

        // 후위 순회한 결과 : DBEGFCA (왼쪽 자식) (오른쪽 자식) (루트)
        val back = back(arr)
        return front + '\n' + middle + '\n' + back
    }

    fun front(arr: Array<IntArray>): String {
        val b = StringBuilder()
        val stack = Stack<Int>()
        stack.add(0)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            b.append((node + 65).toChar())

            if (arr[node][1] != -1) {
                stack.add(arr[node][1])
            }
            if (arr[node][0] != -1) {
                stack.add(arr[node][0])
            }
        }
        return b.toString()
    }

    fun middle(arr: Array<IntArray>): String {
        val b = StringBuilder()
        val visited = BooleanArray(26)
        val stack = Stack<Int>()
        stack.add(0)
        while (stack.isNotEmpty()) {
            val m = stack.peek()
            val mid = arr[m]
            val l = mid[0]
            val r = mid[1]

            if (l != -1 && !visited[l]) {
                stack.push(l)
            } else {
                b.append((m + 65).toChar())
                visited[m] = true
                stack.pop()
                if (r != -1) {
                    stack.push(r)
                }
            }
        }

        return b.toString()
    }

    fun back(arr: Array<IntArray>): String {
        val b = StringBuilder()
        val visited = BooleanArray(26)
        val stack = Stack<Int>()
        stack.add(0)
        while (stack.isNotEmpty()) {
            val m = stack.peek()
            val mid = arr[m]
            val l = mid[0]
            val r = mid[1]

            if (l != -1 && !visited[l]) {
                stack.push(l)
            } else if (r != -1 && !visited[r]) {
                stack.push(r)
            } else {
                b.append((m + 65).toChar())
                visited[m] = true
                stack.pop()
            }
        }

        return b.toString()
    }
}
