import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		
		int[] arr = new int[] {4,6,1,8,9};
		
		int rst = Arrays.binarySearch(arr, 1);
		System.out.println(rst);
	}
}
