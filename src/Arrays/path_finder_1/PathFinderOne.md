## Description

[Kata](https://www.codewars.com/kata/5765870e190b1472ec0022a2/java)

You are at position [0, 0] in maze NxN and you can only move in one of the four cardinal directions (i.e. North, East, South, West). Return true if you can reach position [N-1, N-1] or false otherwise.

* Empty positions are marked ..
* Walls are marked W.
* Start and exit positions are empty in all test cases.

---

## My solution
```js
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
```

---

## Best practices

***First***
```js
public class Finder {
  
    private static class Pos {
        final int x, y;
        Pos(int x, int y) { this.x = x; this.y = y; } 
        Pos[] neighbours() { return new Pos[]{ new Pos(x-1,y), new Pos(x+1,y), new Pos(x,y-1), new Pos(x,y+1) }; }
        boolean onPath(char[][]g) { return x >= 0 && x < g[0].length && y >= 0 && y < g.length && g[y][x] == '.'; }    
    }

    static boolean pathFinder(String maze) {
        final String rows[] = maze.split("\n");
        final char[][] grid = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) grid[i] = rows[i].toCharArray();
        return findExit(new Pos(0,0), grid);
    }

    private static boolean findExit(Pos p, char[][]g) {        
        if (p.x == g.length-1 && p.x == p.y) return true; // We made it to the exit!    
        if (!p.onPath(g)) return false;
        g[p.y][p.x] = 'B';  // drop a breadcrumb
        final Pos[] n = p.neighbours();
        return findExit(n[0],g) | findExit(n[1],g) | findExit(n[2],g) | findExit(n[3],g);
    }

}
```

***Second***
```js
public static boolean pathFinder(String maze) {
    char[] mazeArray = maze.toCharArray();
    int n = ((int) Math.sqrt(4 * maze.length() + 5) - 1) / 2;
    LinkedList<Integer> toTest = new LinkedList<>();
    toTest.add(0);
    while (!toTest.isEmpty()) {
        int p = toTest.pollFirst();
        if (p == mazeArray.length-1) return true;
        if (mazeArray[p]!='.') continue;
        mazeArray[p]='*';
        int y = p / (n + 1);
        int x = p - y * (n + 1);
        if (y>0 && mazeArray[p-n-1]=='.') toTest.push(p-n-1);
        if (y<n-1 && mazeArray[p+n+1]=='.') toTest.push(p+n+1);
        if (x>0 && mazeArray[p-1]=='.') toTest.push(p-1);
        if (x<n-1 && mazeArray[p+1]=='.') toTest.push(p+1);
    }
    return false;
}
```
