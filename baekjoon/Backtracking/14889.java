package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static int N;
    public static int [][]map;
    public static boolean [] visit;
    public static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0 ; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0,0);
        System.out.println(Min);



    }

    public static void combi(int depth, int idx){
        if(depth == N/2){
            diff();
            return;
        }

        for(int i = idx; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                combi(depth+ 1 , i + 1);
                visit[i] = false;
            }
        }
    }

    public static void diff(){
        int team_start = 0;
        int team_link = 0;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
               if(visit[i]==true && visit[j]==true){
                   team_link += map[i][j];
                   team_link += map[j][i];
               }
               else if(visit[i] == false && visit[j] == false){
                   team_start += map[i][j];
                   team_start += map[j][i];
               }
            }
        }
        int val = Math.abs(team_link- team_start);
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }

        Min = Math.min(val, Min);
    }


}