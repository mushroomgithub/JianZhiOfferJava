import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main5 {

	static StringBuffer s1 = new StringBuffer();
	static StringBuffer s2 = new StringBuffer();
	static StringBuffer s3 = new StringBuffer();
	static StringBuffer s4 = new StringBuffer();
	static StringBuffer s5 = new StringBuffer();

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			Output(n);
		}
	}

	private static void Output(int n) {
		int j = 2;
		while (j <= n) {
			if (n % j == 0) {
				func(j);
				n = n / j;
			} else {
				j++;
			}
		}
		s1.deleteCharAt(s1.length() - 1);
		s2.deleteCharAt(s2.length() - 1);
		s3.deleteCharAt(s3.length() - 1);
		s4.deleteCharAt(s4.length() - 1);
		s5.deleteCharAt(s5.length() - 1);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		s1.delete(0, s1.length());
		s2.delete(0, s2.length());
		s3.delete(0, s3.length());
		s4.delete(0, s4.length());
		s5.delete(0, s5.length());
	}

	private static void func(int n) {
		int[] a = new int[10];
		int len = 0;

		while (n >= 1) {
			a[len++] = n % 10;
			n /= 10;
		}
		for (int i = len - 1; i >= 0; i--) {
			if (a[i] == 1) {
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

			} else if (a[i] == 2) {
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
			} else if (a[i] == 3) {
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
			} else if (a[i] == 4) {
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
			} else if (a[i] == 5) {
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
			} else if (a[i] == 6) {
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
			} else if (a[i] == 7) {
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
			} else if (a[i] == 8) {
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
			} else if (a[i] == 9) {
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
			} else if (a[i] == 0) {
				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");

				s1.append("-");
				s2.append(" ");
				s3.append(" ");
				s4.append(" ");
				s5.append("-");

				s1.append(" ");
				s2.append("|");
				s3.append(" ");
				s4.append("|");
				s5.append(" ");
			}
		}
		s1.append(" ");
		s2.append(" ");
		s3.append("*");
		s4.append(" ");
		s5.append(" ");
	}

}

