package ssafy.boj;

import java.util.Scanner;

public class Boj_1436 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();

        int n=665;
        int count=0;

        while(count<input) {
            n++;
            if (Integer.toString(n).contains("666")) {
                count++;
            }
        }
        System.out.println(n);

    }
} 