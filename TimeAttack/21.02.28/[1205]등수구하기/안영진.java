package boj.silver.l4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @문제링크 https://www.acmicpc.net/problem/1205
 * @메모리 11544 kb
 * @시간 80 ms
 * @분류 
 * @고려사항 
 */
public class BOJ_1205_등수구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, newScore, P;
	static int[] ranking;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());			// 현재 랭킹에 있는 점수 개수
		newScore = Integer.parseInt(tokens.nextToken());	// 유진이의 점수
		P = Integer.parseInt(tokens.nextToken());			// 랭킹 리스트 사이즈
		ranking = new int[P];
		
		if (N > 0) {
			tokens = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				ranking[i] = Integer.parseInt(tokens.nextToken());
			}			
		}
		
//		System.out.println(Arrays.toString(ranking));
		// 입력 완료
		
		if (N >= P && ranking[P-1] >= newScore) {
			// 랭킹이 다 찼고, 마지막이 유진이 점수보다 크거나 같다면
			System.out.println(-1);
			
		} else {	// 아니라면 유진이의 순위 계산
			int rank = 1;
			for (int i = 0; i < P; i++) {
				if (ranking[i] > newScore) {
					rank++;
					
				} else if (ranking[i] <= newScore) {
					System.out.println(rank);
					break;
				}
			}
			
		}
		
	}
}











