package  com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static int N;
    public static int M;
    public static int []arr;
    public static boolean []visit;
    public static BufferedWriter br;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        DFS(0);
        System.out.println(sb);
    }

    public static void DFS(int deepth){
        if(deepth == M){
            for(int val : arr)
                sb.append(val).append(' ');
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            if(visit[i]==false){
                arr[deepth] = i+1;
                visit[i] = true;
                DFS(deepth+1);
                visit[i] = false;
            }
        }
    }
}