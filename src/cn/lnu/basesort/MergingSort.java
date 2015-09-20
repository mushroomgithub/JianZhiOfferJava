package cn.lnu.basesort;

public class MergingSort {
	 public static void main(String[] args) {
	  int a[] = {10,45,643,2,32,12,34,56,7,78,65,9,34,32,5,25,324,4,2,5,456,5,3,2,634,34,23,8,7,6,5,4,3,2,1};
	 
	  sort(a);
	  show(a);
	 }
	 
	 public static void sort(int a[]) {
	  int[] b = new int[a.length];
	  msort(a, b, 0, a.length-1);
	 }
	 
	 public static void msort(int[] a,int[] b, int low, int high) {
	  if (low < high) {
	   int mid = (low + high) / 2;
	   msort(a, b, low, mid);
	   msort(a, b, mid+1, high);
	   merging(a, b, low, mid, high);
	  }
	 }
	 
	 public static void merging(int[] a, int[] b, int low, int mid, int high) {
	  int i = low;
	  int j = mid + 1;
	  int k = low;
	 
	  while (i <= mid && j <= high) {
	   if (a[i] < a[j])
	    b[k++] = a[i++];
	   else
	    b[k++] = a[j++];
	  }
	  while (i <= mid)
	   b[k++] = a[i++];
	  while (j <= high)
	   b[k++] = a[j++];
	 
	  for (int g = low; g <= high ; g++)
	   a[g] = b[g];
	 }
	 
	 public static void show(int a[]) {
	  System.out.print(a[0]);
	  for (int i = 1; i < a.length; i++) {
	   System.out.print(" " + a[i]);
	  }
	  System.out.println();
	 }
	 
	}
