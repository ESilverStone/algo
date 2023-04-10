
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트랙킹 방식
public class Test {
    
    static int[][] arr;
    static int zeroCnt;
    static boolean pass;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        arr = new int[9][9];
        
        //입력받기
        for (int i=0; i<9; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            for (int j=0; j<9; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        pass = true;
        
        sudoku(0);

        //출력하기
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
        
    }
    
    //백트랙킹
    static void sudoku (int r) {
    	
        for (int i=r; i<9; i++) {
        	
            for (int j=0; j<9; j++) {
            	
            	// 0인 것만 관심 있음
                if (arr[i][j] == 0) {
                	
                    for (int k=1; k<=9; k++) {
                    	
                    	// 해당 구역에 숫자k가 적합한지 체크
                        if (isPromising(k, i, j)) {
                        	
                        	// 적합하다면 대체한다.
                            arr[i][j] = k;
                            
                            // 다음 영역으로 이동 > i로 둔 이유는 시간 절약하기 위해
                            sudoku(i);
                            
                            // 초기화 작업 
                            // 그러나 끝까지 도달해서 답을 다 잘 넣었는데 return으로 돌아오면서 다시 0으로 전환됨
                            // 해결방안으로 ****참고
                            if(pass) arr[i][j]= 0;
                        }    
                    }
                    // 검사시 가능한 숫자가 없다 > return
                    if (arr[i][j] == 0) return;
                }
                // ****스도쿠의 끝에 도달하였다면 0으로 전환하는 것을 막는다. 
                if(i == 8 && j == 8) pass = false;
                
            }
        }
        return;    
    }
    
    
    
    //백트랙킹
    static void sudoku2 (int i, int j) {
    	
    	
    	// 탈출조건
    	if(i == 8 && j == 8) {
    		pass = false;
    		return;
    	}
    	
    	// 인덱스 수정
    	if(j==9) {j=0; i++;}
    
    	
    	// 작업 
    	// 조건으로 거르기
    	if (arr[i][j] != 0) sudoku2(i, j+1);
   
    	// 해당 조건 만족 > 0인거
    	else {
         	
            for (int k=1; k<=9; k++) {
            	
            	// 해당 구역에 숫자k가 적합한지 체크
                if (isPromising(k, i, j)) {
                	
                	// 적합하다면 대체한다.
                    arr[i][j] = k;
                    
            		sudoku2(i, j+1);
               
                    if(pass) arr[i][j]= 0;			// 초기화
                }    
            } 
        }
        return;    
    }
    
    
    static boolean isPromising(int o, int r, int c) {
        //행검사
        for (int i=0; i<9; i++) {
            if (arr[r][i] ==o) {
                return false;
            }
        }
        
        //열검사
        for (int i=0; i<9; i++) {
            if (arr[i][c] ==o) {
                return false;
            }
        }
        
        //3*3 사각형 검사
        int a = (r/3)*3;
        int b = (c/3)*3;
        
        for (int i=a; i<a+3; i++) {
            for (int j=b; j<b+3; j++) {
                if (arr[i][j]==o) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
    
    
}