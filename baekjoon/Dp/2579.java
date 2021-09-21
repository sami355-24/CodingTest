package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{


    public static int arr[];
    public static Integer dp[];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dp = new Integer[n+1];

        for(int i=1; i<=n; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1];

        if(n>=2)
            dp[2]= arr[1]+arr[2];

        System.out.println(find(n));
    }

    public static int find(int x){
        if(dp[x]==null)
            dp[x] = arr[x] + Math.max(arr[x-1]+find(x-3), find(x-2));
        return dp[x];
    }

}