package Arrays.path_finder_1;

import java.util.LinkedList;
import java.util.Stack;

public class PathFinderOne {

    static boolean pathFinder(String maze) {
        int N = maze.indexOf("\n");
        maze = maze.replaceAll("\n", "");

        if (maze.length() == 1)
            return true;

        LinkedList<Integer>[] link = new LinkedList[N * N];

        for (int i = 0; i < N * N; i++) {
            link[i] = new LinkedList<Integer>();

            if (maze.codePointAt(i) == 'W')
                continue;

            if (i - N >= 0 && maze.codePointAt(i - N) != 'W')
                link[i].add(i - N);

            if (i / N == (i - 1) / N && i - 1 >= 0 && maze.codePointAt(i - 1) != 'W')
                link[i].add(i - 1);

            if (i / N == (i + 1) / N && maze.codePointAt(i + 1) != 'W')
                link[i].add(i + 1);

            if (i + N < N * N && maze.codePointAt(i + N) != 'W')
                link[i].add(i + N);
        }

        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[N * N];
        visited[0] = true;
        while (!link[0].isEmpty()) {
            stack.push(link[0].poll());
        }

        while (!stack.isEmpty()) {
            int next = stack.pop();

            if (!visited[next]) {
                visited[next] = true;
                while (!link[next].isEmpty()) {
                    stack.push(link[next].poll());
                    if (stack.peek() == N * N - 1)
                        return true;
                }
            }
        }

        return false;
    }

}
