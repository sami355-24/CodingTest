package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static class virus{
        int x, y;
        public virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int []dir_row = {0, 1, 0, -1};
    static int []dir_col = {-1, 0, 1, 0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int m;

    static int [][] map;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0);
        System.out.println(result);
    }

    static void DFS(int depth){
        if(depth == 3) {
            BFS();
        }

        else {
            for (int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 0){
                        map[i][j] = 1;
                        DFS(depth+1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static void BFS(){
        int [][]virus_map = new int[n][m];
        Queue<virus> queue = new LinkedList <virus>();

        for(int i=0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virus_map[i][j] = map[i][j];
                if (virus_map[i][j] == 2)
                    queue.add(new virus(i, j));
            }
        }

        while(!queue.isEmpty()){
            virus temp = queue.poll();
            for(int i=0; i<4; i++){
                int row = temp.x + dir_row[i];
                int col = temp.y + dir_col[i];

                if( 0 <= row && row < n && 0 <= col && col < m){
                    if(virus_map[row][col] == 0){
                        virus_map[row][col] = 2;
                        queue.offer(new virus(row, col));
                    }
                }
            }
        }

        safe(virus_map);
    }

    static void safe(int[][] map){
        int count = 0;
        for(int i=0; i<n ; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 0)
                    count++;
            }
        }

        result = Math.max(count, result);

    }
}