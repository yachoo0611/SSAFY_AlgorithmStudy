package ssafy.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14501 {

	public static void main(String[] args) throws IOException {
	
		int n;
		int day;
		int price;
		int value[];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		value = new int[n+2];

		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = i + Integer.parseInt(st.nextToken());
			price = Integer.parseInt(st.nextToken());
			if(day <= n + 1)
				value[day] = Math.max(value[day], value[i] + price);
				if(value[i] > value[i+1])
					value[i+1] = value[i];
		}			
		System.out.println(value[n+1]);
	}

}