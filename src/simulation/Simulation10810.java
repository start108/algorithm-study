package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Simulation10810 {

    static int[] edgeArr;

    static int n;

    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edgeArr = new int[n];

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int j = begin - 1; j < end; j++) {
                edgeArr[j] = ball;
            }
        }

        for (int i = 0; i < edgeArr.length; i++) {
            System.out.print(edgeArr[i] + " ");
        }
    }
}
