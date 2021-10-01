package com.company;

import java.io.*;
import java.util.StringTokenizer;

class Main{

    public static int N;
    public static int M;
    public static int []arr;
    public static boolean [] visit;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        DFS(0);
        bw.flush();
        bw.close();
    }

    public static void DFS(int depth) throws IOException {
        if(depth  == M) {
            for(int val : arr) {
                bw.write(String.valueOf(val + " "));
            }
            bw.write("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i] && (depth ==0 ||arr[depth-1] < i+1)) {
                visit[i] = true;
                arr[depth] = i+1;
                DFS(depth + 1);
                visit[i] = false;
                arr[depth] = -1;
            }
       }
    }
}