package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    public static int M, N;
    public static int[][] box;
    public static boolean[][] visited;
    public static int[] dr_x = {-1, 0, 1, 0};
    public static int[] dr_y = {0, 1, 0, -1};
    public static int cnt;
    public static Queue<point> queue = new LinkedList<point>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        BFS();

    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            point cur = queue.poll();
            cnt = box[cur.getX()][cur.getY()];
            for (int i = 0; i < 4; i++) {
                int temp_x = cur.getX() + dr_x[i];
                int temp_y = cur.getY() + dr_y[i];

                if (temp_x < 0 || temp_y < 0 || temp_x >= N || temp_y >= M
                        || box[temp_x][temp_y] == -1 || visited[temp_x][temp_y]) {
                    continue;
                }

                box[temp_x][temp_y] = box[cur.getX()][cur.getY()] + 1;

                queue.offer(new point(temp_x, temp_y));
                visited[temp_x][temp_y] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt - 1);

    }

    static class point {
        private int x;
        private int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}