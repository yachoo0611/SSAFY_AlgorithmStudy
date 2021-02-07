import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		int[][] weight = new int[T][T];
		int[] rank = new int[T];

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				weight[i][j] = Integer.parseInt(st.nextToken());
			}
			rank[i] = 1;
		}
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < T; j++) {
				if (weight[i][0] > weight[j][0] && weight[i][1] > weight[j][1]) { // i는 본인, j는 본인제외 모두.
					rank[j]++; // i+1의 사람의 덩치가 더 작으면 j의 rank에 ++
				} else if (weight[i][0] < weight[j][0] && weight[j][1] < weight[j][1]) {
					rank[i]++; // i의 사람의 덩치가 더 작으면 i의 rank에 ++
				}
			}
		}
		for (int answer : rank) {
			sb.append(answer + " ");
		}
		System.out.println(sb);
	}
}