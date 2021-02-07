package ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_15655 {

	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] str = in.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		str = in.readLine().split(" ");
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(numbers);
		combination(M, numbers, 0, new int[M], 0);
		System.out.println(sb.toString());
	}
	
	static void combination(int M, int[] numbers, int dest, int[] choosed, int startIdx) {
		if (dest == M) {
			for (int i = 0; i < M; i++) {
				sb.append(choosed[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = startIdx; i < numbers.length; i++) {
			choosed[dest] = numbers[i];
			combination(M, numbers, dest+1, choosed, i+1);
		}
	}
}
