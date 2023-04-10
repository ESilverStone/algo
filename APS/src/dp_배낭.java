import java.util.Scanner;

public class dp_�賶 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//�������� ���� N�� / �ִ� ������ ���� W
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] weights = new int[N+1];
		int[] cost = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][W+1]; 
		//�������� �ѹ��� ������� �������� 0�࿡ 0���� �ʱ�ȭ�� �Ǿ������� ���ҷ�
		//�������� �Ѱ��� �÷����鼭 ����� �غ���
		for(int i = 1; i <=N; i++) {
			//������ �������� �̿��Ͽ� ������ ����
			//w : �ӽ� �賶�� ũ��
			for(int w = 0 ; w<=W; w++) {
				if(weights[i] <= w) {
					//�ش� ������ ������ ���� �Ǵ��� �غ��ڴ�.
					//�ش� w�� �����ش� : dp[i-1][w]
					//�̹� ������ ����ϴ� �����ش� : dp[i-1][w-weights[i]]+cost[i]
					//���� �ΰ��� ���� �� �����ɷ� �����ϰڴ�.
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+cost[i]);
				}else{
					dp[i][w] = dp[i-1][w]; //���� �ӽù��԰� ���� ������ ���� �� ��� �������
				}
			}
		}
		
		System.out.println(dp[N][W]);	
	}	
}
