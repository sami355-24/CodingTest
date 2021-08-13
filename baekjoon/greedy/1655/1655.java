package com.company;

import java.io.*;
import java.util.*;

public class Main {

    static int cases;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue <Integer>max_heap = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue <Integer>min_heap = new PriorityQueue();
        int max_heap_peek;
        int min_heap_peek;

        StringTokenizer st = new StringTokenizer(br.readLine());
        cases = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine());
            if(max_heap.size() == min_heap.size())
                max_heap.add(Integer.parseInt(st.nextToken()));
            else min_heap.add(Integer.parseInt(st.nextToken()));

            if(i!=0 && max_heap.peek() > min_heap.peek()) {
                max_heap_peek = max_heap.poll();
                min_heap_peek = min_heap.poll();
                max_heap.add(min_heap_peek);
                min_heap.add(max_heap_peek);
            }

            if(i!=0 && max_heap.size() == min_heap.size())
                bw.write(String.valueOf(max_heap.peek()));
            else bw.write(String.valueOf(max_heap.peek()));
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }
}