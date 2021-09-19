package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static Queue<Integer> queue = new LinkedList<Integer>();
    public static Integer [] arr = new Integer[1000001];
    public static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue.offer(N);
        int idx = -1;
        arr[N] = 0;
        if (N == K) {
            System.out.println("0");
            return;
        }
        while(!queue.isEmpty()){
            idx = queue.poll();
            if((idx-1 >= 0) && (arr[idx-1]==null)){
                queue.offer(idx-1);
                arr[idx-1] = arr[idx]+1;
                if(idx-1 == K)
                    break;
            }
            if((idx +1 <1000001) && (arr[idx+1]==null)){
                queue.offer(idx+1);
                arr[idx+1] = arr[idx]+1;
                if(idx+1 == K)
                    break;
            }
            if((idx * 2 < 1000001) && (arr[idx*2] == null)){
                queue.offer(idx*2);
                arr[idx*2] = arr[idx]+1;
                if(idx*2 == K)
                    break;
            }
        }
        System.out.println(arr[idx]+1);
    }
}