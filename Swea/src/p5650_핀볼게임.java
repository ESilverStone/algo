import java.util.Scanner;

public class p5650_�ɺ����� {
	
	public static int[][] map;
	
	// �Ʒ�/����/��/������
	public static int[] vi = {1,0,-1,0};
	public static int[] vj = {0,-1,0,1};
	
	public static int score;
	public static int max;
	public static int N;
	
	public static void func(int i, int j) {
		
		// ������ 4�������� ���� �˻�
		for(int d=0; d<4; d++) {
			
			// �ʱ�ȭ
			score = 0;
			int dir = d;
			int curI = i;
			int curJ = j;
			
			while(true) {
				// ���� ��ǥ���� �� ĭ �̵�(������ ������ �ش�.)
				curI += vi[dir];
				curJ += vj[dir];
				
				// Ż�� ���ǿ� �´��� �˻�
				if(curI==i && curJ==j) break;
				
				// ���� ������ ���
				if(curI < 0 || curJ < 0 || curI >= N || curJ >= N) {
					dir = wall(curI, curJ, dir);
					score++;
				}
				
				
				
				// �ش� ���� �˻��ؼ� ���� �ִ��� üũ ��
				// �� ���� ������ �˻�
				else if(1<=map[curI][curJ] && map[curI][curJ] <=5) {
					
					// ���� ��ȯ
					dir = block(map[curI][curJ], dir);
					
					// ���� ����
					score++;
				}
				// ��Ȧ�� ���� ���
				else if(6<=map[curI][curJ] && map[curI][curJ] <=10){
					int idx = map[curI][curJ];
					
					// map�� ��- �˻��� �� �ݴ��� ��Ȧ�� �̵�
					out :
					for(int y=0; y<N; y++) {
						for(int x=0; x<N; x++) {
							// ���� ��ȣ�� ��Ȧ ��
							if(map[y][x] == idx) {
								// ���� ��ǥ�� �Ÿ���
								if(x == curJ && y == curI) continue;
								
								// ��ǥ �缳��, ������ �״��
								curI = y;
								curJ = x;
								break out;	// �ϳ� ã���� Ż��
							}	
						}
					}
				}
				// ��Ȧ
				else if(map[curI][curJ] == -1) {
					//System.out.println(score+" score "+d);
					break;
				}
					
			}
			// �ݺ��� ��
			
			// ���� ����
			if(max < score) max = score;	
		}	
	}
	
	// ���� ��ȯ�� - ��
	public static int wall(int curI, int curJ, int dir) {
		
		// ���� ��
		if(curJ < 0) {
			return 3;
		}
		// ������ ��
		else if(curJ >= N) {
			return 1;
		}
		// ���� ��
		else if(curI < 0) {
			return 0;		
		}
		// �Ʒ��� ��
		else if(curI >= N) {
			return 2;	
		}
		return -1;
	}
	
	// ���� ��ȯ�� - ��
	public static int block(int which, int dir) {
		
		switch(which) {
		
		case 1:
			switch(dir) {
			
			case 0:
				return 3;
			case 1:
				return 2;
			case 2:
				return 0;
			case 3:
				return 1;
			}

		case 2:
			switch(dir) {
			
			case 0:
				return 2;
			case 1:
				return 0;
			case 2:
				return 3;
			case 3:
				return 1;
			}
			
		case 3:
			switch(dir) {
			
			case 0:
				return 2;
			case 1:
				return 3;
			case 2:
				return 1;
			case 3:
				return 0;
			}
			
		case 4:
			switch(dir) {
			
			case 0:
				return 1;
			case 1:
				return 3;
			case 2:
				return 0;
			case 3:
				return 2;
			}
			
		case 5:
			switch(dir) {
			
			case 0:
				return 2;
			case 1:
				return 3;
			case 2:
				return 0;
			case 3:
				return 1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			
			// �Է�
			// -1 : ��Ȧ, 0 : �����
			// 1 : ��/��, 2 : ��/��, 3 : ��/��, 4 : ��/��, 5 : �簢
			// 6-10 : ����
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			max = Integer.MIN_VALUE;
			
			// 0�� ��� �������� �����غ����Ѵ�. 
			// ������ 4���� ��� ������ �� �� ����.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(map[i][j] == 0) func(i,j);
				}
			}
			// ���
			System.out.println("#"+t+" "+max);
		}
	}
}
