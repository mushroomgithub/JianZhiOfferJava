import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main4 {
	static StringBuffer s1 = new StringBuffer();
	static StringBuffer s2 = new StringBuffer();
	static StringBuffer s3 = new StringBuffer();
	static StringBuffer s4 = new StringBuffer();
	static StringBuffer s5 = new StringBuffer();

	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 1) {
				s1.append("  ");
				s2.append("  ");
				s3.append("  ");
				s4.append("  ");
				s5.append("  ");

				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");
			} else if (n == 2) {
				s1.append(" ");
				s2.append(" ");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");

				s1.append("-");
				s2.append(" ");
				s3.append("-");
				s4.append(" ");
				s5.append("-");

				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append(" ");
				s5.append(" ");
			} else if (n == 3) {
				s1.append(" ");
				s2.append(" ");
				s3.append(" ");
				s4.append(" ");
				s5.append(" ");

				s1.append("-");
				s2.append(" ");
				s3.append("-");
				s4.append(" ");
				s5.append("-");

				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");
			} else if (n == 4) {
				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append(" ");
				s5.append(" ");

				s1.append(" ");
				s2.append(" ");
				s3.append("-");
				s4.append(" ");
				s5.append(" ");

				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");
			} else if (n == 5) {
				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append(" ");
				s5.append(" ");

				s1.append("-");
				s2.append(" ");
				s3.append("-");
				s4.append(" ");
				s5.append("-");

				s1.append(" ");
				s2.append(" ");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");
			} else if (n == 6) {
				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");

				s1.append("-");
				s2.append(" ");
				s3.append("-");
				s4.append(" ");
				s5.append("-");

				s1.append(" ");
				s2.append(" ");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");
			} else if (n == 7) {
				s1.append(" ");
				s2.append(" ");
				s3.append(" ");
				s4.append(" ");
				s5.append(" ");

				s1.append("-");
				s2.append(" ");
				s3.append(" ");
				s4.append(" ");
				s5.append(" ");

				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");
			} else if (n == 8) {
				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");

				s1.append("-");
				s2.append(" ");
				s3.append("-");
				s4.append(" ");
				s5.append("-");

				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");
			} else if (n == 9) {
				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append(" ");
				s5.append(" ");

				s1.append("-");
				s2.append(" ");
				s3.append("-");
				s4.append(" ");
				s5.append("-");

				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");
			}
			s1.append(" ");
			s2.append(" ");
			s3.append("*");
			s4.append(" ");
			s5.append(" ");

			for (int j = 2, k = 0, x = n; j <= n; j++) {
				for (; x > 0; k++) {
					if (x % j == 0) {
						if (k != 0)
							System.out.print("*");
						System.out.print(j);
						x /= j;
					} else
						break;
				}
			}
			System.out.println();

		}
	}
}
