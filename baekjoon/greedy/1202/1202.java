package com.company;

import java.io.IOException;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    static int N;
    static int K;
    static Gem[] gem;
    static int[] C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C= new int[K];
        gem = new Gem[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            gem[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++)
            C[i] = Integer.parseInt(br.readLine());


        Arrays.sort(gem);
        Arrays.sort(C);

        long ans = 0;
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && gem[j].M <= C[i]) {
                pq.add(-gem[j].V);
                j++;
            }
            if (!pq.isEmpty()) {
                ans += Math.abs(pq.poll());
            }
        }
        System.out.println(ans);

    }

    static class Gem implements Comparable<Gem> {
        private int M;
        private int V;

        public int getM() {
            return M;
        }

        public int getV() {
            return V;
        }

        public void setM(int m) {
            M = m;
        }

        public void setV(int v) {
            V = v;
        }

        public Gem(int m, int v) {
            M = m;
            V = v;
        }

        @Override
        public int compareTo(Gem o) {
            return this.M - o.M;
        }
    }
}