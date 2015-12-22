import java.util.*;
import java.io.*;

public class C {
	private static int[][] M = new int[][] {
			{0, 0, 0, 0, 0},
			{0, 1, 2, 3, 4},
			{0, 2, -1, 4, -3},
			{0, 3, -4, -1, 2},
			{0, 4, 3, -2, -1},
		};


	private static int mul(int a, int b) {
		int sign = (a * b > 0) ? 1 : -1;
		return sign * M[Math.abs(a)][Math.abs(b)];

	}


	private static int power(int a, long n) {
		int value = 1;
		for (int i = 0; i < n % 4; i++) {
			value = mul(value, a);
		}
		return value;
	}

	private static boolean checkIJ(String s, int l, long x) {
		int iValue = 1;
		int jValue = 1;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < l; j++) {
				if (iValue != 2) {
					iValue = mul(iValue, (int) s.charAt(j) - (int) 'i' + 2);
				} else if (jValue != 3) {
					jValue = mul(jValue, (int) s.charAt(j) - (int) 'i' + 2);
				}
			}
		}
		return iValue == 2 && jValue == 3;
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		
		for (int i = 0; i < numCases; i++) {
			int L =  Integer.parseInt(input.next());
			long X =  Long.parseLong(input.next());
			String s = input.next();
			boolean result = true;

			int all = 1;
			for (int l = 0; l < L; l++) {
				all = mul(all, (int) s.charAt(l) - (int) 'i' + 2);
			}
			all = power(all, X);
			result = result && (all == -1) ? true : false;

			result = result && checkIJ(s, L, Math.min(8, X));

			System.out.printf("Case #%d: %s\n", i + 1, result ? "YES" : "NO");
		}
	}
}