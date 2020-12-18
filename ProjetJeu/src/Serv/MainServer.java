package Serv;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServer {

	public static void main(String[] args) {
		try {
			ServerSocket ecoute = new ServerSocket(1500);
			System.out.println("Serveur lanc�!");
			while(true) {
				
				Socket player1 = ecoute.accept();
				System.out.println("Joueur 1 connect�!");
				
				Socket player2 = ecoute.accept();
				System.out.println("Joueur 2 connect�!");
				
				Game game = createGame();
				
				new ThreadGame1(player1, game).start();
				new ThreadGame2(player2, game).start();
			}
		} catch(Exception e) {
			System.out.println("Erreur de d�marrage du serveur");
		}
	}
	
	private static Game createGame() {
		// Ici vous pouvez modifier les param�tres de la partie
		
		int width = 6, length = 6;
		ArrayList<Integer> ships = new ArrayList<Integer>();
		ships.add(2);
		ships.add(2);
		ships.add(2);
		ships.add(3);
		ships.add(4);
		ships.add(3);


		Game game = new Game(width, length, ships);
		
		return game;
	}

}