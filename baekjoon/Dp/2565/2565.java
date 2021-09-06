package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args)throws IOException {
        int [][]cost;
        int [] dp;
        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");

        n= Integer.parseInt(st.nextToken());
        cost = new int[n+1][2];
        dp = new int[n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cost, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] > b[0])
                    return 1;
                else if(a[0] < b[0])
                    return -1;
                else
                    return 0;
            }
        });

        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i]=1;
            for(int j=1; j<i; j++){
                if(cost[i][1]> cost[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            if(dp[i]>max)
                max = dp[i];
        }
        System.out.println(n-max);
    }
}