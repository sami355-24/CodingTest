package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static int[][] map;
    public static boolean[][] visited;
    public static int col, row;
    public static Stack<String> stack;
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static int cnt;
    public static int[] dr_x = {-1, 0, 1, 0};
    public static int[] dr_y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[col][row];
        visited = new boolean[col][row];
        String s;
        for (int i = 0; i < col; i++) {
            s = br.readLine();
            for (int j = 0; j < row; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        BFS(0, 0);
    }

    public static void BFS(int x, int y) {
        Queue<point> queue = new LinkedList<point>();
        queue.offer(new point(x,y));
        visited[x][y] = true;
        cnt=1;

        int temp_x = 0;
        int temp_y = 0;

        while(!queue.isEmpty()){
            point cur = queue.poll();
            if(cur.getX() == col-1 && cur.getY() == row -1) {
                System.out.println(map[col-1][row-1]);
                return;
            }
            for(int i=0; i<4; i++){
                temp_x = cur.getX() + dr_x[i];
                temp_y = cur.getY() + dr_y[i];

                if(temp_x < 0 || temp_y <0 || temp_x >= col || temp_y >= row)
                    continue;
                if(visited[temp_x][temp_y] || map[temp_x][temp_y]==0)
                    continue;

                map[temp_x][temp_y] = map[cur.getX()][cur.getY()] + 1;
                queue.offer(new point(temp_x, temp_y));
                visited[temp_x][temp_y] = true;
            }
        }
    }

    static class point{
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