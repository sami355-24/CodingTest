package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static class Node{
        private int num; //숫자
        private Node left; //왼쪽 child
        private Node right; //오른쪽 child

        public Node(int num) { //생성자
            this.num = num;
        }

        public void insert(int n){ //child를 붙어주는 메소드
            if(this.num < n){
                if(this.right == null){ //오른쪽에 아무것도 없을때 붙여준다.
                    this.right = new Node(n);
                }
                else
                    this.right.insert(n); //만약 오른쪽에 무언가가 있다면 그 오른쪽의 노드로 이동해 insert메소드 진행.
            }
            else if(n < this.num){
                if(this.left == null){ //왼쪽에 아무것도 없을떄 붙여준다.
                    this.left = new Node(n);
                }
                else
                    this.left.insert(n); //만약 오른쪽에 무언가가 있다면 그 왼쪽의 노드로 이동해 insert메소드 진행.
            }
        }

    }

    public static void postorder(Node node){ //후위순외하는 함수
        if(node == null) //현재 노드에 아무것도 저장이 되어있지않다면 리턴.
            return;
        postorder(node.left); //현재 node의 왼쪽 child로 이동
        postorder(node.right); //현재 node의 오른쪽 child로 이동
        System.out.println(node.num); //현재 node에 저장되어있는 값 출력.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input)); //정수형태로 바꾸어 노드 생성후 저장

        while(true){
            input = br.readLine();
            if(input == null){ //만약 입력값이 없다면 break
                break;
            }
            root.insert(Integer.parseInt(input)); //insert로 들어가 동작 수행.
        }

        postorder(root); //후위순회하는 메소드
    }
}