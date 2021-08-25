package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        String ary = st.nextToken();
        boolean minus = false;
        String temp = "";
        int result = 0;

        for (int i = 0; i < ary.length(); i++) {
            if (ary.charAt(i) == '-' || ary.charAt(i) == '+') {
                if (minus) {
                    result -= Integer.parseInt(temp);
                    temp = "";
                } else {
                    result += Integer.parseInt(temp);
                    temp = "";
                }
            } else {
                temp = temp + ary.charAt(i);
            }

            if (ary.charAt(i) == '-')
                minus = true;

        }

        if (minus) {
            result -= Integer.parseInt(temp);
            temp = "";
        } else {
            result += Integer.parseInt(temp);
            temp = "";
        }
        System.out.println(result);
    }
}