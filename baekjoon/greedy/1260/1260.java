package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int start;
    static boolean[] visited;
    static int[][] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        check = new int[1001][1001];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            check[x][y] = 1;
            check[y][x] = 1;
        }

        visited = new boolean[1001];


        dfs(start);


        visited = new boolean[1001];

        System.out.println();
        bfs(start);

    }

    public static void dfs(int curr_node) {
        visited[curr_node] = true;
        System.out.print(curr_node + " ");
        for (int j = 0; j <=n ; j++) {
            if (check[curr_node][j] == 1 && visited[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs(int cutt_node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cutt_node);
        visited[cutt_node] = true;
        System.out.print(cutt_node + " ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int j = 0; j <=n; j++) {
                if (check[temp][j] == 1 && visited[j] == false) {
                    queue.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }

    }
}
