package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static int N;
    public static int[][] street;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        street = new int[N][3];
        dp = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++){
                street[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMin();
    }

    public static void findMin() {
        dp[0][0] = street[0][0];
        dp[0][1] = street[0][1];
        dp[0][2] = street[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        dp[i][0] = street[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                        break;

                    case 1:
                        dp[i][1] = street[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                        break;

                    case 2:
                        dp[i][2] = street[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                        break;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            if(min > dp[N-1][i])
                min = dp[N-1][i];
        }
        System.out.println(min);
    }

}