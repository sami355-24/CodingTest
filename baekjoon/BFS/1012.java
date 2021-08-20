package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int [][]map;
    static boolean [][]visited;
    static int []dr = {-1, 1, 0, 0};
    static int []dc = {0, 0, -1, 1};
    static int M;
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();

        for(int TC=0; TC<TestCase;TC++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            int count=0;
            map = new int[M][N];
            visited = new boolean[M][N];

            for(int k=0; k<K; k++)
                map[sc.nextInt()][sc.nextInt()] = 1;

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==1 && visited[i][j] == false)
                    {
                        bfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count + " ");

        }

    }

    public static void bfs(int r, int c){
        Queue<position> queue = new LinkedList<>();
        position p = new position(r, c);
        queue.offer(p);
        visited[p.getR()][p.getC()] = true;

        while(!queue.isEmpty()) {
            position p1 = queue.poll();
            visited[p1.getR()][p1.getC()] = true;

            for (int i = 0; i < 4; i++) {
                int new_r = p1.getR() + dr[i];
                int new_c = p1.getC() + dc[i];
                if (new_c >= 0 && new_r >= 0 && new_r < M && new_c < N) {
                    if (map[new_r][new_c] == 1 && visited[new_r][new_c] == false) {
                        position p2 = new position(new_r, new_c);
                        queue.offer(p2);
                        visited[new_r][new_c] = true;
                    }
                }
            }
        }
    }

}


class position{
    private int r;
    private int c;

    public position(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}
