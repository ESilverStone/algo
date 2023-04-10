
import java.util.Scanner;

public class p2747_피보나치수2 {
	
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력받는다
		int N = sc.nextInt();
		// 메모이제이션을 위한 배열
		arr = new int[N+1];
		
		arr[0]=0;
		arr[1]=1;
		fibonacci(N);
		System.out.println(arr[N]);
	}
	
	//피보나치 구하는 dp 함수
	static void fibonacci(int a) {
		
		if (a==1) return;
		
		if (arr[a-1] == 0)
			fibonacci(a-1); 
		
		else if (a-2>0 && arr[a-2] == 0)
			fibonacci(a-2);
		
		arr[a] = arr[a-1] + arr[a-2];
	}
}