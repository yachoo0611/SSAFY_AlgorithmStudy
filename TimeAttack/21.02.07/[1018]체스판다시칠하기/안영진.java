package bj.silver.l5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * @since 2021. 2. 7.
 * @author yjanmin
 * @see https://www.acmicpc.net/problem/1018
 * @mem 21,888 kb
 * @time 180 ms
 * @caution 
 */
public class BJ_S5_1018_체스판다시칠하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int N, M;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		board = new char[N][M];
		for (int n = 0; n < N; n++) {
			board[n] = input.readLine().toCharArray();
		}

		int min = Integer.MAX_VALUE;
		for (int r = 0; r < N - 7; r++) {
			for (int c = 0; c < M - 7; c++) {
				min = Math.min(min, paint(r,c));
			}
		}
		
		System.out.println(min);
	}

	private static int paint(int r, int c) {
		int cnt1 = 0;
		int cnt2 = 0;
		Queue<Character> q1 = new LinkedList<>();
		Queue<Character> q2 = new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			q1.offer('B');
			q1.offer('W');
			q2.offer('W');
			q2.offer('B');
		}
		
		for (int nr = r; nr < 8 + r; nr++) {
			for (int nc = c, i = 0; nc < 8 + c; nc++) {
				if (board[nr][nc] != q1.peek()) {
					cnt1++;
				}
				if (board[nr][nc] != q2.peek()) {
					cnt2++;
				}
				if (++i != 8) {
					q1.offer(q1.poll());
					q2.offer(q2.poll());
				}
			}
		}
		
		return Math.min(cnt1, cnt2);
	}
}
