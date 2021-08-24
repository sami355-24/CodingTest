package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int []ary;
    static boolean []skip;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if(n==0)
                break;

            ary = new int[n];
            skip = new boolean[n];

            for(int i=0; i<n; i++){
                ary[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ary);
            DFS(0, 0);
            System.out.println();
        }

    }

    public static void DFS(int start, int count){
        if(count == 6) {
            for(int i=0; i<n; i++){
                if(skip[i])
                    System.out.print(ary[i] + " ");
            }
            System.out.println();
        }

        for(int i = start; i < n; i++){
            skip[i] =true;
            DFS(i+1, count+1);
            skip[i] = false;
        }
    }
}
