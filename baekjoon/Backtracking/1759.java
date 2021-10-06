package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static int L, C;
    public static String[] arr; //arr 저장하는곳
    public static boolean[] visited; //각 원소의 선택여부를 판단
    public static int num_vow; //모음 수
    public static int num_cons; //자음 수
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //띄어쓰기 기준으로 자름

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine(), " "); // 띄어쓰기 기준으로 자름
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr); //정렬

        MakePassWord(0, 0);
        bw.flush();
        bw.close();
    }

    public static void MakePassWord(int depth, int idx) throws IOException {
        if (depth == L) { //만약 전부 선택 되어있다면 출력메소드로 이동
            printArr();
            return;
        }

        for (int i = idx; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true; //미방문이라면 방문값을 true로 해놓고 재귀적으로 호출
                MakePassWord(depth + 1, i + 1);
                visited[i] = false; //방문끝났으면 false로 바꿈
            }
        }
    }

    private static void printArr() throws IOException { //출력
        int i = 0;
        for (String val : arr) { //자음수와 모음수를 계산
            if (visited[i++]) {
                if (val.equals("a") || val.equals("e") || val.equals("i") || val.equals("o") || val.equals("u")) {
                    num_vow++;
                } else num_cons++;
            }
        }

        if (!(num_vow >= 1 && num_cons >= 2)) { // 만약 자음의 수이 두개 이상이 안되거나 모음의 수이 하나 이상이 안될시
            num_vow=0;
            num_cons=0;
            return;
        }

        i = 0;
        for (String val : arr) {
            if (visited[i++])
                bw.write(val);
        }
        bw.write("\n");
        num_cons = 0;
        num_vow = 0;
        return;
    }
}