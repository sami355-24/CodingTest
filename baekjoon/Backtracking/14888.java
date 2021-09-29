package com.company;


import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static int N;
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] arr;
    public static int[] opr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        opr = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            opr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, arr[0]);
        System.out.println(MAX + "\n" + MIN);
    }


    public static void DFS(int depth, int val) {
        if (depth + 1 == N) {
            if (MAX < val)
                MAX = val;
            if (MIN > val)
                MIN = val;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opr[i] == 0)
                continue;


            opr[i]--;
            switch (i) {
                case 0:
                    DFS(depth + 1, val + arr[depth + 1]);
                    break;
                case 1:
                    DFS(depth + 1, val - arr[depth + 1]);
                    break;
                case 2:
                    DFS(depth + 1, val * arr[depth + 1]);
                    break;
                case 3:
                    DFS(depth + 1, val / arr[depth + 1]);
                    break;
            }
            opr[i]++;
        }
    }
}
