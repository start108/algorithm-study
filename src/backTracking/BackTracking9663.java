package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking9663 {

    public static int[] arr;

    public static int n;

    public static int count = 0;

    public static void dfs(int depth) {

        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {

            arr[depth] = i;

            if (possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean possibility(int column) {

        for (int i = 0; i < column; i++) {
            if (arr[column] == arr[i]) {
                return false;
            } else if(Math.abs(column - i) == Math.abs(arr[column] - arr[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        dfs(0);
        System.out.println(count);
    }
}
