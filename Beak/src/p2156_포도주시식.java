import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2156_포도주시식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		
	}
	
	public static int[] arr;
	public static int[] dp;
	

}
