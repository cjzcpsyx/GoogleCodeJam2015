import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		for (int i = 0; i < numCases; i++) {
			int n = input.nextInt();
			int[] p = new int[n];

			for (int j = 0; j < n; j++) {
				p[j] = input.nextInt();
			}

			Arrays.sort(p);
			int max = p[n-1];
			int total = max;
			for (int k = 1; k <= max; k++) {
				int current = k;
				for (int l = 0; l < n; l++) {
					current += (p[l] - 1) / k;
				}
				total = Math.min(total, current);
			}

			System.out.printf("Case #%d: %d\n", i+1, total);
		}
	}
}