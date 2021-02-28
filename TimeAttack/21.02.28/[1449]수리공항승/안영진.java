package boj.silver.l3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @문제링크 https://www.acmicpc.net/problem/1449
 * @메모리 11580 kb
 * @시간 80 ms
 * @분류 
 * @고려사항 
 */
public class BOJ_1449_수리공항승 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, L;
	static boolean[] pipe = new boolean[1002];
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());	// 물이 새는 곳의 개수
		L = Integer.parseInt(tokens.nextToken());	// 테이프의 길이
		
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			pipe[Integer.parseInt(tokens.nextToken())] = true;
		}
		
		
		int answer = 0;
		for (int i = 1; i < pipe.length;) {
			if (pipe[i]) {
				i += L;
				answer++;
			} else {
				i++;
			}
		}
		System.out.println(answer);
	}
}






