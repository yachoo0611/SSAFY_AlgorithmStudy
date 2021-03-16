package ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17281 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, hits[][], entry[], resMax;
	static final int ONE = 1, TWO = 2, THREE = 3, HOMERUN = 4, OUT = 0;
	static boolean  selected[], base[];
	static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		hits = new int[N+1][10];
		entry = new int[10];
		selected = new boolean[10];


		for(int n = 1; n <= N; n++) {  
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= 9; i++) {
				hits[n][i] = Integer.parseInt(st.nextToken());
			}
		} 
		entry[4] = 1; 
		selected[1] = true;
		permutation(1);
		System.out.println(resMax);
	}

 
	private static void permutation(int idx) {
		if(idx == 10) {  
			calcScore();  
			return;
		}
		if(idx == 4) permutation(idx+1);  
		else {
			for(int j = 2; j <= 9; j++) {
				if(selected[j]) continue;
				selected[j] = true;
				entry[idx] = j;
				permutation(idx+1);
				selected[j] = false;
			}
		}
	}

 
	private static void calcScore() {
		int outCnt = 0;
		int no = 1;  
		int score = 0;
		boolean stop = false;
		for(int i = 1; i <= N; i++) {  
			stop = false;
			base = new boolean[4]; 
			while(!stop) {  
				switch(hits[i][entry[no]]) {
				case OUT:
					if(++outCnt == 3) {  
						outCnt = 0; 
						stop = true; 
					}
					break;
				case ONE:
					score += go(1);
					break;
				case TWO:
					score += go(2);
					break;
				case THREE:
					score += go(3);
					break;
				case HOMERUN:
					score += go(4);
					break;
				default:
					break;
				}
				no = ++no == 10 ? 1 : no;  
			}
		}  
		resMax = Math.max(score, resMax);
	}
 
	private static int go(int hit) {
		int res = 0;
		for(int run = 3; run >= 1; run--) {  
			if(base[run]) { 
				if(run + hit >= 4) {  
					base[run] = false;  
					res++;
				} else {
					base[run] = false;  
					base[run+hit] = true;  
				}
			}
		}
		if(hit == 4) res++;  
		else base[hit] = true;  
		return res;
	}
}
