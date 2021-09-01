package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int S;
    static int count=0;
    static int Sum;
    static int[] Num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        Num = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++)
            Num[i] = Integer.parseInt(st.nextToken());

        DFS(0,0);
        if(S == 0)
            count--;
        System.out.println(count);
    }

    public static void DFS(int depth, int sum) {
        if (depth == N) {
            if (sum == S)
                count++;
            return;
        }

        //현재 인덱스 더하기
        DFS(depth+1, sum + Num[depth]);
        //현재 인덱스 더하지 않음
        DFS(depth+1, sum);
    }
}