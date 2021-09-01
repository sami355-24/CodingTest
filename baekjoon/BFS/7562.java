package com.company;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class point {
    private int x;
    private int y;
    private int cnt;

    public point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCnt() {
        return cnt;
    }
}

class Main {

    static int testCase;
    static int I;
    static point start;
    static point goal;
    static boolean visited[][];
    static int[] dr_x = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dr_y = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");

        testCase = Integer.parseInt(st.nextToken());
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine(), "");
            I = Integer.parseInt(st.nextToken());
            visited = new boolean[I][I];
            st = new StringTokenizer(br.readLine(), " ");
            start = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine(), " ");
            goal = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            bw.write(BFS() + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int BFS(){
        Queue<point> q = new LinkedList<>();
        q.offer(start);
        visited[start.getX()][start.getY()] = true;
        while(!q.isEmpty()){
            point p = q.poll();
            if(p.getX() == goal.getX() && p.getY() == goal.getY())
                return p.getCnt();
            for(int i=0; i<8; i++){
                int temp_x = p.getX() + dr_x[i];
                int temp_y = p.getY() + dr_y[i];

                if(temp_x < 0 || temp_x >=I || temp_y < 0 ||temp_y >= I)
                    continue;

                if(visited[temp_x][temp_y] == false){
                    point temp_point = new point(temp_x, temp_y, p.getCnt()+1);
                    q.offer(temp_point);
                    visited[temp_x][temp_y] = true;
                }
            }
        }
        return -1;
    }
}
