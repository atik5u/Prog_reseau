package Client;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Client {
	public static void main(String[] args) {
		try {
//			System.out.println("entrer le site");
//			Scanner sc = new Scanner(System.in);
//			String url = sc.nextLine();
//			sc.close();
			Socket s= new Socket("vdespre.free.fr", 80);
			PrintWriter out =new PrintWriter(s.getOutputStream(), true);
			BufferedReader in =new BufferedReader(new InputStreamReader(s.getInputStream()));
			//out.println("GET /TPHTTP.php HTTP/1.1\\r\\n\"" + url+"\r\n \r\n");
			out.println("POST /TPHTTP.php HTTP/1.1\r\n" + 
					"host: vdespre.free.fr\r\n" + 
					"content-type: application/x-www-form-urlencoded\r\n" + 
					"content-length: 12\r\n" + "\r\n"+
					"nom=abir&submit=ok\r\n"+
					"\r\n");
		
		String msg = in.readLine();
		while(msg!=null) {
			System.out.println(msg);
			msg= in.readLine();
		}
		msg= in.readLine();
		out.println("GET /TPHTTP.php HTTP/1.1\r\n" + 
				"host: vdespre.free.fr\r\n" + 
				"\r\n");
		s.close();
			
//			boolean cond = false;
//			
//			String msg = in.readLine();
//			while(!msg.equals(null)) {
//				if(msg.equals("<body>")) {
//					 try {
//					      FileWriter myWriter = new FileWriter("/Users/PC/Desktop/eclipse stuff/ClientHTTP/bodyuRu.txt");
//					      while(!cond) {
//								myWriter.write(msg + "\n");
//								msg= in.readLine();
//								if(msg.equals("</body>")) cond = true;
//					      }
//					      myWriter.close();
//					      System.out.println("Successfully wrote to the file.");
//					    } catch (IOException e) {
//					      System.out.println("An error occurred.");
//					      e.printStackTrace();
//					    }
//					
//					  }
//				System.out.println(msg);
//				msg= in.readLine();
//					
//				}
//				
//	
//			
//			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
