package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking15652 {

    static int[] edgeArr;

    static boolean[] isVisited;

    static int n;

    static int m;

    static StringBuilder sb;

    public static void dfs(int depth, int start) {

        if (depth == m) {
            for (int val : edgeArr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            isVisited[i] = true;
            edgeArr[depth] = i + 1;
            dfs(depth + 1, i);
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        edgeArr = new int[m];
        isVisited = new boolean[n];

        dfs(0, 0);

        System.out.println(sb);
    }
}
