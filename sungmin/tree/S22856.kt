import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S22856().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S22856 {
    fun solution(input: List<String>): String {
        val len = input.first().toInt()
        val nodes = Array(len+1) { IntArray(2) }
        for (i in 1 until input.size) {
            val st = StringTokenizer(input[i])
            val parent = st.nextToken().toInt()
            val left = st.nextToken().toInt()
            val right = st.nextToken().toInt()
            val children = nodes[parent]
            children[0] = left
            children[1] = right
        }

        val visited = BooleanArray(len + 1)
        val path = Stack<Int>()
        path.add(1)
        visited[1] = true
        var moveCount = 0
        while (path.isNotEmpty()) {
            moveCount++
            val node = path.peek()
            val left = nodes[node][0]
            val right = nodes[node][1]
            // 1.현재 위치한 노드의 왼쪽 자식 노드가 존재하고 아직 방문하지 않았다면, 왼쪽 자식 노드로 이동한다.
            if (left != -1 && !visited[left]) {
                path.add(left)
                continue
            }

            // 2.그렇지 않고 현재 위치한 노드의 오른쪽 자식 노드가 존재하고 아직 방문하지 않았다면, 오른쪽 자식 노드로 이동한다.
            if (right != -1 && !visited[right]) {
                if (path.size == 1) {
                    path.pop()
                }
                path.add(right)
                continue
            }

            // 3.그렇지 않고 현재 노드가 유사 중위 순회의 끝이라면, 유사 중위 순회를 종료한다.
            if (
                (left == -1 || visited[left]) &&
                (right == -1 || visited[right])
            ) {
                visited[node] = true
                path.pop()
                continue
            }

            // 4.그렇지 않고 부모 노드가 존재한다면, 부모 노드로 이동한다.
            break
        }

        moveCount--
        return moveCount.toString()
    }
}
