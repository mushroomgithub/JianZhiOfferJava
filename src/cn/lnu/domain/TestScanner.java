package cn.lnu.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestScanner {

	/**
	 * ����Scanner��Scanner�Ĺ�����֧�ֶ������룬���ַ��������������ļ�
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//ʹ�ü�����Ϊ������
		/*Scanner scanner=new Scanner(System.in);
		System.out.println("�������ַ�����");
		while(true){
			int line=scanner.nextInt();
			if(line==-1)
				break;
			System.out.println(">>>"+line);
		}*/
		
		//ʹ���ļ���Ϊ������
		/*InputStream in=Test2.class.getClassLoader().getResourceAsStream("cn/lnu/domain/1.txt");//��ȡ��cn.lnu.domain�µ�1.txt
		InputStream in=Test2.class.getClassLoader().getResourceAsStream("1.txt");//��srcĿ¼�µ�1.txt	  
		InputStream in = new FileInputStream(new File("c:\\1.txt")); //��ȡ������C���µ�1.txt�ļ�
		BufferedReader bf=new BufferedReader(new InputStreamReader(in));
		Scanner scanner=new Scanner(bf);
		while(scanner.hasNextLine()){
			String line=scanner.nextLine();
			System.out.println(line);
		}*/
		
		//ʹ���ļ���Ϊ����
		/*File file=new File("c:\\1.txt");
		Scanner scanner=new Scanner(file);
		while(scanner.hasNextLine()){
			String line=scanner.nextLine();
			System.out.println(line);
		}*/
		
		//ʹ���ַ�����Ϊ����
		String input="1,fish,2,fish,red,fish,blue,fish";
		Scanner scanner=new Scanner(input);
		scanner.useDelimiter(",");
		while(scanner.hasNext()){
			String str=scanner.next();
			System.out.println(str);
		}
	}

}
