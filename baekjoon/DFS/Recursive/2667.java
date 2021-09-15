package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main{
    public static int [][]map;
    public static boolean [][] visited;
    public static int []dr_x = {-1, 0, 1, 0};
    public static int []dr_y = {0, 1, 0, -1};
    public static int N;
    public static int clusterNumber = 1;
    public static int cnt=0;
    public static ArrayList<Integer> clusterElementNumber = new ArrayList<Integer>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    DFS(i,j);
                    clusterNumber++;
                    clusterElementNumber.add(cnt);
                    cnt = 0;
                }
            }
        }
        Collections.sort(clusterElementNumber);
        bw.write(String.valueOf(clusterElementNumber.size()) + "\n");
        for(int i=0; i<clusterElementNumber.size(); i++){
            bw.write(String.valueOf(clusterElementNumber.get(i)) + "\n");
        }
        bw.flush();
        bw.close();

    }

    public static void DFS(int x, int y){
        if(x<0 || y<0 || x>=N || y>=N || map[x][y] == 0)
            return;

        if(visited[x][y])
            return;

        map[x][y] = clusterNumber;
        cnt++;
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int temp_x = x+ dr_x[i];
            int temp_y = y+ dr_y[i];
            DFS(temp_x, temp_y);
        }
    }
}