package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking15650 {

    static int[] edgeArr;

    static boolean[] isVisited;
    static int n;

    static int m;

    public static void dfs(int depth, int start) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(edgeArr[i] + " ");
            }

            System.out.println();

            return;
        }

        for (int i = start; i < n; i++) {
            if (isVisited[i] == false) {
                isVisited[i] = true;
                edgeArr[depth] = i + 1;
                dfs(depth + 1, i + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edgeArr = new int[m];
        isVisited = new boolean[n];

        dfs(0, 0);
    }
}
