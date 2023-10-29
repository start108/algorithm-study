package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking15649 {

    static int[] edgeArr;

    static boolean[] isVisit;
    static int n;

    static int m;

    public static void dfs(int depth) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(edgeArr[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {
            if (isVisit[i] == false) {
                isVisit[i] = true;
                edgeArr[depth] = i + 1;
                dfs(depth + 1);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edgeArr = new int[m];
        isVisit = new boolean[n];

        dfs(0);
    }
}
