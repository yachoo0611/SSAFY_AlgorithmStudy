import java.util.Scanner;

public class Boj_2231 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		int answer = 0;

		//1,000,000

		for(int i =1;i<=n;i++) {
			answer = i + (i/1000000)+ (i%1000000)/100000+ (i%100000)/10000+ (i%10000)/1000+ (i%1000)/100 + (i%100)/10+(i%10);
			if(answer==n) {
				System.out.print(i);
				break;
			}
			if(i==n) {
				System.out.println(0);
			}
		}
	}

}