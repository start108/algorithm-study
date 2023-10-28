package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs2606 {

    static int[][] map;

    static boolean[] isVisited;

    static int n;

    static int m;

    static int count = 0;

    static Queue<Integer> queue = new LinkedList<>();

    public static void bfs(int start) {

        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {

            start = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (map[start][i] == 1 && isVisited[i] == false) {
                    queue.offer(i);
                    isVisited[i] = true;
                    count++;
                }
            }
        }

        System.out.print(count);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = 1;
        }

        bfs(1);
    }
}
