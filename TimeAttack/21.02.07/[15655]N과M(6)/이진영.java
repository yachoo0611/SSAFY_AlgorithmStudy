import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 7.
 * @author
 * @see https:https://www.acmicpc.net/problem/15655
 * @mem 84848kb
 * @time 320ms
 * @caution
 */

public class 이진영 {

	static int N;
	static int M;
	static int[] arr;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(M, new int[M], 0);
		System.out.println(output);
	}

	static void comb(int toChoose, int[] choosed, int startIdx) {
		if (toChoose == 0) {
			for (int a : choosed) {
				output.append(a).append(" ");
			}
			output.append("\n");
			return;
		}

		for (int i = startIdx; i < N; i++) {

			choosed[M - toChoose] = arr[i];
			comb(toChoose - 1, choosed, i + 1);

		}
	}

}
}
