import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2798 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] cards;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			cards[i] = Integer.parseInt(st.nextToken());

		int sum = 0;
		for (int i = 0; i < N-2; i++) {// 1번째카드
			for (int j = i + 1; j < N - 1; j++) {// 2번째카드
				for (int k = j + 1; k < N; k++) {// 3번째카드
					sum = cards[i] + cards[j] + cards[k];
					if (sum <= M) {
						answer = Math.max( sum,answer);
					}
				}
			}
		}
		System.out.println(answer);
 

	}
}