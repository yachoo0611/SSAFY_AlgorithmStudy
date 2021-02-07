package ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_15654 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(str[i]);
		}

		Arrays.sort(numbers);
		permutation(M, numbers, 0, new int[M], new boolean[N]);
		System.out.print(sb.toString());
	}

	static void permutation(int M, int[] numbers, int dest, int[] choosed, boolean[] visited) {
		if (dest == M) {
			for (int i = 0; i < M; i++) {
				sb.append(choosed[i]).append(" ");	
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			choosed[dest] = numbers[i];
			permutation(M, numbers, dest+1, choosed, visited);
			visited[i] = false;
		}
	}
}