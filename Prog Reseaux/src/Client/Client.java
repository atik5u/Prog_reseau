package Client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) {
	try {
		Socket s= new Socket("localhost", 1234);
		OutputStream os = s.getOutputStream();
		//InputStream is = s.getInputStream();
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
		Scanner sc = new Scanner(System.in);
		out.println(sc.nextLine());
		System.out.println(in.readLine());
		sc.close();
		s.close();
	}catch(Exception e) {
		//exception
	
	}
}
	
}
