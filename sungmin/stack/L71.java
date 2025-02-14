import algorithm.Eq;

import java.util.Arrays;
import java.util.Stack;

public class S71 {
    public static void main(String[] args) {
        S71 e = new S71();
        Eq.print(e.simplifyPath("/home/"), "/home");
        Eq.print(e.simplifyPath("/home//foo/"), "/home/foo");
        Eq.print(e.simplifyPath("/home/user/Documents/../Pictures"), "/home/user/Pictures");
        Eq.print(e.simplifyPath("/../"), "/");
        Eq.print(e.simplifyPath("/.../a/../b/c/../d/./"), "/.../b/d");
        Eq.print(e.simplifyPath("/.././GVzvE/./xBjU///../..///././//////T/../../.././zu/q/e"), "/zu/q/e");
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Arrays.stream(path.split("/"))
                .filter(it -> !it.isEmpty() && !it.equals("."))
                .forEach(p -> {
                    if (p.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else {
                        stack.push(p);
                    }
                });

        StringBuilder b = new StringBuilder();
        for (String p : stack) {
            b.append('/');
            b.append(p);
        }
        return b.length() == 0 ? "/" : b.toString();
    }
}
