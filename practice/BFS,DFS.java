package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int n; //정점개수
    public static int m; //간선개수
    public static int start; //시작점
    public static int[][] graph;
    public static boolean[] visited;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[1001][1001];
        visited = new boolean[10001];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs();
        bw.write("\n");

        visited = new boolean[1001];

        bfs();
        bw.flush();
        bw.close();

    }

    public static void bfs() throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        bw.write((int) start + " ");
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i <= n; i++) {
                if (visited[i] == false && graph[temp][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    bw.write((int) i + " ");
                }
            }
        }
    }

    public static void dfs() throws IOException {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        int pos = start;
        bw.write((int) pos + " ");

        while (!stack.isEmpty()) {
            boolean isConnection = false;

            for (int i = 1; i <= n; i++) {
                if (visited[i] == false && graph[pos][i] == 1) {
                    pos = i;
                    i=1;
                    stack.push(pos);
                    visited[pos] = true;
                    isConnection = true;
                    bw.write((int) pos + " ");
                }
            }

            if (isConnection == false)
                pos = stack.pop();

        }
    }

}
