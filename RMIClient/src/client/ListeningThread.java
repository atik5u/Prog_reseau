package client;


import java.io.IOException;
import java.util.ArrayList;

import serveur.ServeurIntf;

public class ListeningThread extends Thread {
	Client cli;

	public ListeningThread(Client c) throws IOException {

		cli = c;
	}

	public void run() {
		try {
			while (!cli.isStop()) {
				ArrayList<String> res = cli.Serveur.receiveMessages(cli.lastMsg);
				cli.lastMsg = cli.Serveur.getMsgs().size();
				if (res.size() != 0) {
					for (String string : res) {
						System.out.println(string);
					}
				}

				Thread.sleep(1000);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
