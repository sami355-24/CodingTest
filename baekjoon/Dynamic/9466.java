package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int testCase;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        int n = 0;

        testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine(), "");
            n = Integer.parseInt(st.nextToken());
            int[][] cost = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int p = 0; p < 2; p++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int q = 1; q <= n; q++) {
                    cost[p][q] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = cost[0][1];
            dp[1][1] = cost[1][1];
            for(int a=2; a<=n; a++){
                dp[0][a] = Math.max(dp[1][a-1], dp[1][a-2]) + cost[0][a];
                dp[1][a] = Math.max(dp[0][a-1], dp[0][a-2]) + cost[1][a];
            }
            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}