import java.util.*;
import java.io.*;
public class A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		for (int i = 0; i < numCases; i++) {
			int sMax = input.nextInt();
			String s = input.next();

			int total = 0, numFriends = 0;
			for (int j = 0; j <= sMax; j++) {
				int a = s.charAt(j) - '0';
				if (a > 0 && total < j) {
					numFriends += j - total;
					total = j;
				}
				total += a;
			}

			System.out.printf("Case #%d: %d\n", i+1, numFriends);
		}
	}
}