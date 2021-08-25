package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dr_x = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dr_y = {0, 1, 1, 1, 0, -1, -1, -1};
    static int count = 0;
    static int h;
    static int w;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;

        while(true){
//            w = sc.nextInt();
//            h = sc.nextInt();
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(h==0 && w==0)
                break;

            map = new int[h][w];
            visit = new boolean[h][w];
            count = 0;

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<w; j++){
                    //map[i][j] = sc.nextInt();
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j] == 1 && visit[i][j] == false){
                        visit[i][j]=true;
                        DFS(i, j);
                        count++;
                    }
                }
            }
//            System.out.println(count);
            bw.write(String.valueOf(count) + "\n");
        }
        bw.flush();
        bw.close();
    }

    //현재 좌표는
    public static void DFS(int x, int y){
        for(int d=0; d<8; d++){
            int nx = x + dr_x[d];
            int ny = y + dr_y[d];
            if(nx>=0 && nx<h && ny>=0 && ny<w)
                if(map[nx][ny]==1 && visit[nx][ny]==false) {
                    visit[nx][ny] = true;
                    DFS(nx, ny);
                }
        }
    }
}
