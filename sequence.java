
import java.util.*;

public class sequence {
	private TreeSet<String> set = new TreeSet<String>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("str1:");
		String str1 = sc.next();
		System.out.println("str2:");
		String str2 = sc.next();
		System.out.println(lcs(str1,str2));
	}
	
	public static String lcs(String s1, String s2){
		String common = "";
		
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		int m = a.length;
		int n = b.length;
		int[][] array = new int[m+1][n+1];
		for (int i = 0; i < a.length; i++) 
			array[i][0] = 0;
		for (int i = 0; i < b.length; i++) 
			array[0][i] = 0;
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a[i-1] == b[j-1]) 
					array[i][j] = array[i-1][j-1] + 1;
			
				else {
					if (array[i][j-1] > array[i-1][j])
						array[i][j] = array[i][j-1];
					else 
						array[i][j] = array[i-1][j];
				}
			}
		}
		int i = m;
		int j = n;
		while (true) {
			if (i == 0 || j == 0) {
				break;
			}
			else if (a[i-1] == b[j-1]) {
				common = a[i-1] + common;
				i--;
				j--;
			}
			else {
				if (array[i][j-1] > array[i-1][j]) {
					j--;
				}
				else if (array[i-1][j] > array[i][j-1]) {
					i--;
				}
				else {
					
				}
			}
		}
		
		
		return common.toString();
		
	}
}
