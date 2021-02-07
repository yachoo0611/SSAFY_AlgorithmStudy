package bj.silver.l5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @since 2021. 2. 7.
 * @author yjanmin
 * @see https://www.acmicpc.net/problem/1436
 * @mem 85,776 kb
 * @time 312 ms
 * @caution 666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662 ...  
 */
public class BJ_S5_1436_영화감독숌 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		int num = 1;
		while (true) {
			if (String.valueOf(num).contains("666")) cnt++;
			if (cnt == N) break;
			num++;
		}
		System.out.println(num);
	}
}
