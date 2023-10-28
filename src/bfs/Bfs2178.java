package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs2178 {

    static int[][] map;

    static boolean[][] isVisited;

    static int n;

    static int m;

    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};

    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int x, int y) {

        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (isVisited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                queue.offer(new int[]{nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                isVisited[nextX][nextY] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        isVisited[0][0] = true;
        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]);
    }
}
