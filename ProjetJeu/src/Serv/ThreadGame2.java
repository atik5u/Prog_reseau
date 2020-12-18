package Serv;

import java.net.Socket;

public class ThreadGame2 extends ThreadGame {

	public  ThreadGame2(Socket joueur2, Game game) {
			super(joueur2, game);
			try {
				this.playerNum = 2;
				out.println("Vous etes joueur 2"); // leave this line
			} catch (Exception e) {
				System.out.println("Erreur instanciation ThreadGameP2");
			}
		}

}
