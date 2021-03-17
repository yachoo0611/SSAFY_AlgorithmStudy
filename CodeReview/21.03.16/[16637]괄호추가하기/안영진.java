package boj.gold.l3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @문제링크 https://www.acmicpc.net/problem/16637
 * @메모리 11600
 * @시간 80
 */
public class BOJ_16637_괄호추가하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static String str;
	static int max = Integer.MIN_VALUE;
	
	static List<Integer> operands = new ArrayList<>();
	static List<Character> operators = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		str = input.readLine();
		
		for (int s = 0; s < str.length(); s++) {
			if (s % 2 == 0) operands.add(str.charAt(s)-'0');
			else operators.add(str.charAt(s));
		}
		
		recur(0, operands.get(0));
		
		System.out.println(max);
	}
	
	private static void recur(int idx, int val) {
		if (idx >= operators.size()) {
			max = Math.max(max, val);
			return;
		}
		
		// 괄호 X
		int temp = calc(val, operands.get(idx+1), operators.get(idx));
		recur(idx+1, temp);
		
		// 괄호 O
		if (idx+1 < operators.size()) {
			temp = calc(operands.get(idx+1), operands.get(idx+2), operators.get(idx+1));
			temp = calc(val, temp, operators.get(idx));
			recur(idx+2, temp);
		}
	}
	
	private static int calc(int a, int b, char operator) {
		switch(operator) {
		case '+': return a+b;
		case '-': return a-b;
		case '*': return a*b;
		}
		return 0;
	}
}
