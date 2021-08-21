package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "");

        int N = Integer.parseInt(st.nextToken());
        bw.write((int) Math.pow(2, N) - 1 + "\n");

        Hanoi(N, 1, 2, 3);

        bw.flush();
        bw.close();

    }

    public static void Hanoi(int n, int start, int mid, int to) throws IOException{

        //하나 일때 이동
        if (n == 1) {
            bw.write(start + " " + to + "\n");
            return;
        }

        //step 1  n-1 A->B이동
        Hanoi(n-1, start, to, mid);

        //step 2 1개이동 A->C이동
        bw.write(start + " " + to + "\n");

        //step 3 n-1 이동 B->C이동
        Hanoi(n-1, mid, start, to);
    }
}