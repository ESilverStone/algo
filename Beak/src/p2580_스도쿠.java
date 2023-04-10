import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p2580_스도쿠 {
	public static List<Integer> listI;
	public static List<Integer> listJ;
	public static int[][] arr;
	
	public static void cal(int idx) {
		
		if(idx == listI.size()) {	
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		int curI = listI.get(idx);
		int curJ = listJ.get(idx);
		
		// 1부터 9까지 중복 체크
		for(int i=1; i<=9; i++) {
			if(check(curI,curJ,i)) {
				arr[curI][curJ] = i;	// 중복이 없다면 대체
				cal(idx+1);
                arr[curI][curJ] = 0;
			}
		}
		
		// 초기화
		return;	
	}
	
	public static boolean check(int row, int col, int val) {
		// 가로 검사
		for(int i=0; i<9; i++) {
			if(arr[row][i] == val) return false;
		}
		
		// 세로 검사
		for(int i=0; i<9; i++) {
			if(arr[i][col] == val) return false;
		}
	
		int setRow = (row / 3) * 3;
		int setCol = (col / 3) * 3;
		
		// 9칸 체크
		for(int i=setRow; i<setRow+3; i++) {
			for(int j=setCol; j<setCol+3; j++) {
				if(arr[i][j] == val) {
					return false;
				}
			}
		}
		// 중복되는 숫자가 없는 경우
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 9;
		arr = new int[9][9];
		
		listI = new ArrayList<>();
		listJ = new ArrayList<>();
			
		for(int i=0; i<9; i++) {
			
			for(int j=0; j<9; j++) {
				arr[i][j] = sc.nextInt();
				
				// 0인 위치 저장
				if(arr[i][j] == 0) {
					listI.add(i);
					listJ.add(j);
				}	
			}
		}
		cal(0);
		
	}
}