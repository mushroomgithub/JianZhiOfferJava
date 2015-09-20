import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Main9 {

	public static void main(String[] args) {
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n=s.nextInt();
		int x1,y1,x2,y2;
		int X[]=new int[n];//����n����ĺ�����
		int Y[]=new int[n];//����n�����������
		for(int i=0;i<n;i++){
			X[i]=s.nextInt();
			Y[i]=s.nextInt();	
		}
		int squere=function(X,Y);
		System.out.println(squere);
	}

	private static int function(int[] x, int[] y) {
		int row=Integer.MAX_VALUE;
		int col=Integer.MAX_VALUE;
		//���������С��ֵ
		for(int i=0;i<x.length;i++){
			int temp=getDistance(x[i],x[i+1]);
			if(row>temp){
				row=temp;
			}
		}
		//����������С��ֵ
		for(int i=0;i<y.length;i++){
			int temp=getDistance(y[i],y[i+1]);
			if(row>temp){
				row=temp;
			}
		}
		//�������������ֵ��Ϊ�����������Сʱ�ı�
		int r=Math.max(row, col);
		return r*r;
	}

	private static  int getDistance(int a, int b) {
		int res=Math.abs(a-b);
		return res;
	}

}
