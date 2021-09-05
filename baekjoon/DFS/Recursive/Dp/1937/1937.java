package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dr_x = {-1, 0, 1, 0};
    static int[] dr_y = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        dp = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j])
                    DFS(i,j);
            }
        }

        int max = -1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(max < dp[i][j])
                    max = dp[i][j];
            }
        }

        System.out.println(max);
    }

    public static int DFS(int x, int y){
        int temp = 0; //주변에 갈수있는곳들의 Dp중 가장큰 곳을 저장한 변수
        if(x < 0 || x>=N || y < 0 || y>=N)
            return 0;

        if(visited[x][y])
            return dp[x][y];

        visited[x][y] = true;
        for(int i=0; i<4; i++){
            //경계선을 벗어 났을때
            if(x + dr_x[i]<0 || x + dr_x[i]>=N || y + dr_y[i]<0 ||y + dr_y[i]>=N)
                continue;
            //다음 좌표의 대나무가 현재좌표보다 많을때 == 갈수있을때
            if(map[x + dr_x[i]][y + dr_y[i]] > map[x][y]) {
                temp = Math.max(DFS(x + dr_x[i],y + dr_y[i]), temp);
//                dp[x][y] = Math.max(DFS(x + dr_x[i],y + dr_y[i]) + dp[x][y], dp[x][y]);
            }
        }
        //map[x][y]에서 탐색이 끝났을때.
        dp[x][y] += temp;
        return dp[x][y];
    }
}