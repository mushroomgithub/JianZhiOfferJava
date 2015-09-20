package cn.lnu.array;

public class Test4 {
	 public static void main(String[] args) {
	  String s = "4 6 2 3 6 7 8 1";
	  function(s);
	 }

	 private static void function(String s) {
	  char[] c = deSpace(s).toCharArray();
	  c = sort(c, 0, true);
	  c = sort(c, 1, false);
	  for (int i = 0; i < c.length - 1; i++) 
	   System.out.print(c[i] + " ");
	  System.out.print(c[c.length - 1]);
	 }

	 private static char[] sort(char[] c, int begin, boolean isAscending) {
	  int i = 0;
	  int j = 0;
	  for (i = begin + 2; i < c.length; i += 2) {
	   if (compare(c[i], c[i - 2], isAscending) < 0) {
	    char temp = c[i];
	    for (j = i - 2; j >= begin && compare(temp, c[j], isAscending) < 0; j -= 2)
	     c[j + 2] = c[j];
	    c[j + 2] = temp;
	   }
	  }
	  return c;
	 }

	 private static int compare(char c1, char c2, boolean isAscending) {
	  int re = 0;
	  if (c1 <= c2) {
	   re = -1;
	  } else {
	   re = 1;
	  }
	  if (isAscending) {
	   return re;
	  } else {
	   return -re;
	  }
	 }
	 
	 private static String deSpace(String s) {
	  char[] c = s.toCharArray();
	  StringBuffer sb = new StringBuffer();
	  for (int i = 0; i < c.length ; i++)
	   if (c[i] != ' ')
	    sb.append(c[i]);
	  return sb.toString();
	 }
	 
	}

