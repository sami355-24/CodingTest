package com.company;

import java.io.*;

import java.util.StringTokenizer;

public class Main {
    final static long p = 1000000007;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long number = factorial(N);
        long denom = factorial(K) * factorial(N-K) % p;

        System.out.println(number * pow(denom, p-2) % p);

    }

    public static long factorial(long n){
        long result = 1L;
        while(n>0){
            result *= n;
            result %= p;
            n--;
        }
        return result;
    }

    public static long pow(long base, long expo){
        long result = 1;
        while(expo > 0){
            if (expo%2 == 1) {
                result *= base;
                result %=p;
            }
            base = base * base;
            base %= p;
            expo /= 2;
        }
        return result;
    }
}

