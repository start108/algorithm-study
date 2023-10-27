package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dfs1260 {

    static int[][] edgeArr;

    static boolean[] isVisit;

    static int node;

    static int line;

    static int start;

    static int count;

    static Queue<Integer> queue = new LinkedList<>();

    public static void dfs(int start) {

        isVisit[start] = true;
        System.out.print(start + " ");

        if(count == node) return;
        count++;

        for(int i = 1; i <= node; i++) {
            if(edgeArr[start][i] == 1 && isVisit[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {

        queue.offer(start);
        isVisit[start] = true;
        System.out.print(start + " ");

        while (!queue.isEmpty()) {

            start = queue.poll();

            for(int i = 1; i <= node; i++) {
                if(edgeArr[start][i] == 1 && isVisit[i] == false) {
                    isVisit[i] = true;
                    queue.offer(i);
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        edgeArr = new int[1001][1001];
        isVisit = new boolean[1001];

        for(int i = 0; i < line; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edgeArr[x][y] = edgeArr[y][x] = 1;
        }

        dfs(start);
        System.out.println();

        isVisit = new boolean[1001];

        bfs(start);
    }
}
