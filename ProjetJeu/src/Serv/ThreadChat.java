package Serv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadChat extends Thread{
	int id;
	BufferedReader in;
	PrintWriter out;
	BufferedReader in2;
	PrintWriter out2;
	static PrintWriter[] outs=new PrintWriter[100]; 
	static int nbid=0;
	
	public ThreadChat(int id,Socket client) {
		try {
			this.id=id;
			nbid++;
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			out.println("Id="+id+"\n");
			outs[id]=out;
		}catch (Exception e) {}
	}
	
	public ThreadChat(Socket client1, Socket client2) {
		try {
			
			in = new BufferedReader(new InputStreamReader(client1.getInputStream()));
			out = new PrintWriter(client1.getOutputStream(), true);
			out.println("vous etes le joueur 1 \n");
			
			in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
			out2 = new PrintWriter(client2.getOutputStream(), true);
			out2.println("vous etes le joueur 2 \n");
			
			
		}catch (Exception e) {}
	}
	public void brodcast(String S) {
		out.println(S);
		out2.println(S);
	}
	
	public static String printGrid(int[][] grid) {
		String S = "";
	    for(int i = 0; i < grid.length; i++) {
	        for(int j = 0; j < grid[i].length; j++) {
	            S=S + grid[i][j] + "|";
	        }
	        S = S + "\r\n";
	    }
	    return S;
	}
	public boolean getInfoPlayer1() throws IOException {
		out.println("Enter the X for your ship");
		String message=in.readLine();
		int X = Integer.parseInt(message);
		message="client 1 chose X = "+message;
		System.out.println(X+1);
		out.println(X+1);
		return false;
	}
	
	public void run() {
			
		try {
			brodcast("Le jeu commance");
			ArrayList<Integer> ships = new ArrayList<Integer>();
			ships.add(2);
			ships.add(2);
			ships.add(3);
			ships.add(4);
			Partie P= new Partie(6, 6, ships);
			brodcast("vous avez une grille de taille "+P.getLength()+"*"+P.getWidth()+ " et "+ships.size()+" bateaux");
			
			
			for (Integer integer : ships) {
				brodcast("vous avez un bateau de taille "+ integer);
			}
			P.fillGrid(P.getGrille1());
			P.fillGrid(P.getGrille2());
			out.println(printGrid(P.getGrille1()));
			out2.println(printGrid(P.getGrille2()));
			out.println("entrer les coordonnees");
			boolean b = getInfoPlayer1();
			while (true) {
				String message=in.readLine();
				message="client 1 "+message;
				System.out.println(message);
				out.println(message);
				
				message=in2.readLine();
				message="client 2 "+message;
				System.out.println(message);
				out2.println(message);
				
			}
			
		}catch (Exception e) {}
	}
}

