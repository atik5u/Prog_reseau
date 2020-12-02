package threading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListeningThread extends Thread {
	BufferedReader in;
	public ListeningThread(Socket S) throws IOException {
		in = new BufferedReader(new InputStreamReader(S.getInputStream()));
	}
	public void run() {
		try {
			while(true) {
				System.out.println(in.readLine());
			}
		}catch(IOException e) {
			
		}
	}
}
