package boj.gold.l5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @문제링크 https://www.acmicpc.net/problem/17070
 * @메모리 11636
 * @시간 84
 */
public class BOJ_17070_파이프옮기기1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int[][] house;
	static int[][][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		house = new int[N][N];
		dp = new int[N][N][3];	// 0: 가로, 1: 세로, 2: 대각선
		
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			for (int m = 0; m < N; m++) {
				house[n][m] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dp[0][1][0] = 1;
		for (int n = 0; n < N; n++) {
			for (int m = 2; m < N; m++) {	// 파이프는 2열부터 놓을 수 있음 (1열까지 놓여있음)
				// 벽이 있는 경우
				if (house[n][m] == 1) continue;
				
				// 가로 방향: 이전 파이프가 가로, 대각선인 경우 가능
				dp[n][m][0] = dp[n][m-1][0] + dp[n][m-1][1];
				
				// 맨 윗 줄의 경우 (가로는 가능)
				if (n == 0) continue;
				
				// 세로 방향: 이전 파이프가 세로, 대각선인 경우 가능
				dp[n][m][2] = dp[n-1][m][1] + dp[n-1][m][2];

				// 대각선 파이프: 현재의 윗쪽, 왼쪽에 벽이 있으면 안됨
				if (house[n-1][m] == 1 || house[n][m-1] == 1) continue;
				
				// 대각선 방향: 이전 파이프가 가로, 세로, 대각선인 경우
				dp[n][m][1] = dp[n-1][m-1][0] + dp[n-1][m-1][1] + dp[n-1][m-1][2];
			}
		}
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}
	
}







