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
	 * 测试Scanner，Scanner的构造器支持多种输入，如字符串，输入流，文件
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//使用键盘作为输入流
		/*Scanner scanner=new Scanner(System.in);
		System.out.println("请输入字符串：");
		while(true){
			int line=scanner.nextInt();
			if(line==-1)
				break;
			System.out.println(">>>"+line);
		}*/
		
		//使用文件作为输入流
		/*InputStream in=Test2.class.getClassLoader().getResourceAsStream("cn/lnu/domain/1.txt");//读取包cn.lnu.domain下的1.txt
		InputStream in=Test2.class.getClassLoader().getResourceAsStream("1.txt");//读src目录下的1.txt	  
		InputStream in = new FileInputStream(new File("c:\\1.txt")); //读取磁盘下C盘下的1.txt文件
		BufferedReader bf=new BufferedReader(new InputStreamReader(in));
		Scanner scanner=new Scanner(bf);
		while(scanner.hasNextLine()){
			String line=scanner.nextLine();
			System.out.println(line);
		}*/
		
		//使用文件作为输入
		/*File file=new File("c:\\1.txt");
		Scanner scanner=new Scanner(file);
		while(scanner.hasNextLine()){
			String line=scanner.nextLine();
			System.out.println(line);
		}*/
		
		//使用字符串作为输入
		String input="1,fish,2,fish,red,fish,blue,fish";
		Scanner scanner=new Scanner(input);
		scanner.useDelimiter(",");
		while(scanner.hasNext()){
			String str=scanner.next();
			System.out.println(str);
		}
	}

}
