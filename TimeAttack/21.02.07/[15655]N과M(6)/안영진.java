package bj.silver.l3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * @since 2021. 2. 7.
 * @author yjanmin
 * @see https://www.acmicpc.net/problem/15654
 * @mem 14,576 kb
 * @time 144 ms
 * @caution 
 */
public class BJ_S3_15654_N과M_6 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		arr = new int [N];
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(arr);
		
		fun(M, new int[M], 0);
		
		System.out.println(output);
	}
	
	private static void fun(int cnt, int[] choosed, int startIdx) {
		if (cnt == 0) {
			for (int i = 0; i < M; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		
		for (int i = startIdx; i < N; i++) {
			choosed[choosed.length-cnt] = arr[i];
			fun(cnt-1, choosed, i+1);
		}
	}
}



