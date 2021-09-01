package com.company;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int x;
        int out;
        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), "");
            x = Integer.parseInt(st.nextToken());
            if(x!=0){
                pq.offer(-x);
            }
            else{
                if(!pq.isEmpty())
                    System.out.println(-pq.poll());
                else
                    System.out.println(0);
            }
        }
    }
}
