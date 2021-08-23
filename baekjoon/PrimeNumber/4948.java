package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Integer[] map;

    public static void main(String[] args) throws IOException{

        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        N = Integer.parseInt(st.nextToken());

        while(N!=0){
            map = new Integer[2*N+1];
            initiallize(2*N);
            filter(2*N);
            print_map(N, 2*N);
            st = new StringTokenizer(br.readLine(), "");
            N=Integer.parseInt(st.nextToken());
        }

    }

    public static void initiallize(int size){
        for(int i=1; i<=size; i++){
            map[i] = i;
        }
    }

    public static void filter(int size){
        for(int i=2; i<=size; i++){
            if(map[i]!=0)
                for(int j=i+i ; j<=size; j+=i){
                    map[j] = 0;
            }
        }
    }

    public static void print_map(int start, int end){
        int count=0;
        for(int i=start+1; i<=end; i++){
            if(map[i]!=0){
                count++;
            }
        }
//        bw.write((int)count + "\n");
        System.out.println(count);
    }
}
